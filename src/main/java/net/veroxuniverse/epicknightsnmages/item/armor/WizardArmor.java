package net.veroxuniverse.epicknightsnmages.item.armor;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import mod.azure.azurelib.animatable.GeoItem;
import mod.azure.azurelib.animatable.client.RenderProvider;
import mod.azure.azurelib.constant.DataTickets;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.Animation;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.core.object.PlayState;
import mod.azure.azurelib.renderer.GeoArmorRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Util;
import net.minecraft.world.World;
import net.spell_engine.api.item.ConfigurableAttributes;
import net.spell_power.api.SpellPowerMechanics;
import net.spell_power.api.SpellSchools;
import net.veroxuniverse.epicknightsnmages.client.armor.WizardArmorRenderer;
import net.veroxuniverse.epicknightsnmages.registry.ItemsRegistry;

import java.util.EnumMap;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class WizardArmor extends KNMArmor implements ConfigurableAttributes {

    private Multimap<EntityAttribute, EntityAttributeModifier> attributes;

    public WizardArmor(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    private static final EnumMap<Type, UUID> MODIFIERS = (EnumMap) Util.make(new EnumMap(Type.class), (uuidMap) -> {
        uuidMap.put(Type.BOOTS, UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"));
        uuidMap.put(Type.LEGGINGS, UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"));
        uuidMap.put(Type.CHESTPLATE, UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"));
        uuidMap.put(Type.HELMET, UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150"));
    });


    @Override
    public void setAttributes(Multimap<EntityAttribute, EntityAttributeModifier> attributes) {
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.putAll(attributes);
        UUID uuid = MODIFIERS.get(this.type);
        builder.put(SpellSchools.ARCANE.attribute,
                new EntityAttributeModifier(uuid, "armorArcaneModifier", 2.0, EntityAttributeModifier.Operation.ADDITION));
        builder.put(SpellSchools.FIRE.attribute,
                new EntityAttributeModifier(uuid, "armorFireModifier", 2.0, EntityAttributeModifier.Operation.ADDITION));
        builder.put(SpellSchools.FROST.attribute,
                new EntityAttributeModifier(uuid, "armorFrostModifier", 2.0, EntityAttributeModifier.Operation.ADDITION));
        builder.put(SpellPowerMechanics.HASTE.attribute,
                new EntityAttributeModifier(uuid, "armorHasteModifier", 0.02, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        this.attributes = builder.build();
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (attributes == null) {
            return super.getAttributeModifiers(slot);
        }
        return slot == this.type.getEquipmentSlot() ? this.attributes : super.getAttributeModifiers(slot);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, 20, state -> {
            state.setAnimation(RawAnimation.begin().then("animation.elite_mage.idle", Animation.LoopType.LOOP));

            Entity entity = state.getData(DataTickets.ENTITY);

            if (entity instanceof ArmorStandEntity)
                return PlayState.CONTINUE;

            Set<Item> wornArmor = new ObjectOpenHashSet<>();

            for (ItemStack stack : entity.getArmorItems()) {
                if (stack.isEmpty())
                    return PlayState.STOP;

                wornArmor.add(stack.getItem());
            }
            boolean isFullSet = wornArmor.containsAll(ObjectArrayList.of(
                    ItemsRegistry.ELITE_MAGE_HELMET,
                    ItemsRegistry.ELITE_MAGE_CHESTPLATE,
                    ItemsRegistry.ELITE_MAGE_LEGGINGS,
                    ItemsRegistry.ELITE_MAGE_BOOTS));

            return isFullSet ? PlayState.CONTINUE : PlayState.STOP;
        }));
    }

    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private GeoArmorRenderer<?> renderer;
            @Override
            public BipedEntityModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, BipedEntityModel<LivingEntity> original) {
                if (this.renderer == null) {
                    this.renderer = new WizardArmorRenderer();
                }
                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }
        });
    }

    @Override
    public void inventoryTick(ItemStack itemStack, World level, Entity entity, int i, boolean bl) {

        super.inventoryTick(itemStack, level, entity, i, bl);
    }

    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    @Override
    public Supplier<Object> getRenderProvider() {
        return renderProvider;
    }

}