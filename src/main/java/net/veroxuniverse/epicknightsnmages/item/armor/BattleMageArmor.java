package net.veroxuniverse.epicknightsnmages.item.armor;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import mod.azure.azurelib.animatable.GeoItem;
import mod.azure.azurelib.animatable.client.RenderProvider;
import mod.azure.azurelib.renderer.GeoArmorRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Util;
import net.minecraft.world.World;
import net.spell_engine.api.item.ConfigurableAttributes;
import net.spell_power.api.SpellPowerMechanics;
import net.spell_power.api.SpellSchools;
import net.veroxuniverse.epicknightsnmages.client.armor.BattleMageArmorRenderer;

import java.util.EnumMap;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BattleMageArmor extends KNMArmor implements ConfigurableAttributes {

    private Multimap<EntityAttribute, EntityAttributeModifier> attributes;

    public BattleMageArmor(ArmorMaterial material, Type type, Settings settings) {
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

        builder.put(SpellSchools.FIRE.attribute,
                new EntityAttributeModifier(uuid, "armorFireModifier", 0.25, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));

        builder.put(SpellSchools.ARCANE.attribute,
                new EntityAttributeModifier(uuid, "armorArcaneModifier", 3.0, EntityAttributeModifier.Operation.ADDITION));

        builder.put(SpellPowerMechanics.CRITICAL_DAMAGE.attribute,
                new EntityAttributeModifier(uuid, "armorCritDamageModifier", 0.1, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));

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
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private GeoArmorRenderer<?> renderer;
            @Override
            public BipedEntityModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, BipedEntityModel<LivingEntity> original) {
                if (this.renderer == null) {
                    this.renderer = new BattleMageArmorRenderer();
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