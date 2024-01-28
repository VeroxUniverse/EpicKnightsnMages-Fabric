package net.veroxuniverse.epicknightsnmages.registry;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ItemMaterialsRegistry implements ToolMaterial {

    MAGICAL(3, 1812, 12.0f, 0.0f, 20,
            () -> Ingredient.ofItems(ItemsRegistry.MAGICAL_INGOT)),
    NOBLE(3, 1812, 12.0f, 0.0f, 12,
            () -> Ingredient.ofItems(ItemsRegistry.MAGICAL_INGOT)),
    SPELLCASTING(4, 2031, 12.0f, 0.0f, 12,
            () -> Ingredient.ofItems(Items.NETHERITE_INGOT)),
    DARK(4, 2031, 12.0f, 0.0f, 25,
            () -> Ingredient.ofItems(Items.NETHERITE_INGOT));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ItemMaterialsRegistry(int miningLevel, int itemDurability, float miningSpeed, float attckDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attckDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}