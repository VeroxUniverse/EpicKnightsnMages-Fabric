package net.veroxuniverse.epicknightsnmages.item.weapon;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import mod.azure.azurelib.animatable.GeoItem;
import mod.azure.azurelib.animatable.client.RenderProvider;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.Animation;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.core.object.PlayState;
import mod.azure.azurelib.renderer.GeoArmorRenderer;
import mod.azure.azurelib.renderer.GeoItemRenderer;
import mod.azure.azurelib.util.AzureLibUtil;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.spell_engine.api.item.ConfigurableAttributes;
import net.spell_engine.api.item.weapon.SpellWeaponItem;
import net.spell_power.api.MagicSchool;
import net.spell_power.api.attributes.SpellAttributes;
import net.veroxuniverse.epicknightsnmages.client.armor.WizardArmorRenderer;
import net.veroxuniverse.epicknightsnmages.client.weapon.SpellBookRenderer;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SpellBook extends SpellWeaponItem implements ConfigurableAttributes, GeoItem {
    MagicSchool school = MagicSchool.PHYSICAL_MELEE;
    public AnimatableInstanceCache factory = AzureLibUtil.createInstanceCache(this);

    private Multimap<EntityAttribute, EntityAttributeModifier> attributes;

    public SpellBook(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings, MagicSchool school) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.school = school;
    }

    public MagicSchool getSchool() {
        return school;
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {

        if (slot != EquipmentSlot.MAINHAND) return super.getAttributeModifiers(slot);

        Multimap<EntityAttribute, EntityAttributeModifier> modifiers = HashMultimap.create(super.getAttributeModifiers(slot));

        modifiers.put(
                SpellAttributes.POWER.get(MagicSchool.ARCANE).attribute,
                new EntityAttributeModifier(
                        UUID.fromString("018d5085-0325-7c62-870b-82a387be46bf"),
                        "swordArcaneModifier",
                        4.0,
                        EntityAttributeModifier.Operation.ADDITION
                )
        );

        modifiers.put(
                SpellAttributes.POWER.get(MagicSchool.FIRE).attribute,
                new EntityAttributeModifier(
                        UUID.fromString("018d5085-1954-7f69-ab62-aea2bda7b40b"),
                        "swordFireModifier",
                        4.0,
                        EntityAttributeModifier.Operation.ADDITION
                )
        );

        this.attributes = modifiers;

        return this.attributes;
    }

    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (state.isOf(Blocks.COBWEB)) {
            return 15.0F;
        } else {
            return state.isIn(BlockTags.SWORD_EFFICIENT) ? 1.5F : 1.0F;
        }
    }

    public boolean isSuitableFor(BlockState state) {
        return state.isOf(Blocks.COBWEB);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "move_controller", 5, state -> {
            state.setAnimation(RawAnimation.begin().then("animation.spellbook.idle_open", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }));
    }

    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private GeoItemRenderer<?> renderer;
            @Override
            public BuiltinModelItemRenderer getCustomRenderer() {
                if (renderer == null)
                    return new SpellBookRenderer();
                return this.renderer;
            }
        });
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.factory;
    }

    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    @Override
    public Supplier<Object> getRenderProvider() {
        return renderProvider;
    }
}
