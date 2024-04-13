package net.veroxuniverse.epicknightsnmages.item.weapon;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.spell_engine.api.item.ConfigurableAttributes;
import net.spell_engine.api.item.weapon.SpellWeaponItem;
import net.spell_power.api.SpellSchools;

import java.util.UUID;

public class Flambard extends SpellWeaponItem implements ConfigurableAttributes {

    private Multimap<EntityAttribute, EntityAttributeModifier> attributes;

    public Flambard(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }


    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (slot != EquipmentSlot.MAINHAND) return super.getAttributeModifiers(slot);

        Multimap<EntityAttribute, EntityAttributeModifier> modifiers = HashMultimap.create(super.getAttributeModifiers(slot));

        modifiers.put(
                SpellSchools.FIRE.attribute,
                new EntityAttributeModifier(
                        UUID.fromString("470e6f4c-56ef-41fd-aa6d-0c8184e7b461"),
                        "swordFireModifier",
                        4.0,
                        EntityAttributeModifier.Operation.ADDITION
                )
        );

        modifiers.put(
                SpellSchools.SOUL.attribute,
                new EntityAttributeModifier(
                        UUID.fromString("1206a5ac-65db-4aa0-a9d3-1237f61700fa"),
                        "swordSoulModifier",
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

}
