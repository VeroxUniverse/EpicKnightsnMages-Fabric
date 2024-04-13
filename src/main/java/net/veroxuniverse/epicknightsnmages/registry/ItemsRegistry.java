package net.veroxuniverse.epicknightsnmages.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.veroxuniverse.epicknightsnmages.EpicKnightsnMagesFabric;
import net.veroxuniverse.epicknightsnmages.item.armor.BattleMageArmor;
import net.veroxuniverse.epicknightsnmages.item.armor.BlueKnightArmor;
import net.veroxuniverse.epicknightsnmages.item.armor.DarkKnightArmor;
import net.veroxuniverse.epicknightsnmages.item.armor.WizardArmor;
import net.veroxuniverse.epicknightsnmages.item.weapon.Flambard;
import net.veroxuniverse.epicknightsnmages.item.weapon.MagicStaff;
import net.veroxuniverse.epicknightsnmages.item.weapon.NobleSword;
import net.veroxuniverse.epicknightsnmages.item.weapon.SpellBook;

public class ItemsRegistry {

    // RESOURCES

    public static final Item CITRIN_GEM = registerItem("citrin_gem",
            new Item(new FabricItemSettings()));

    public static final Item SCARLET_GEM = registerItem("scarlet_gem",
            new Item(new FabricItemSettings()));

    public static final Item MOONLIGHT_GEM = registerItem("moonlight_gem",
            new Item(new FabricItemSettings()));

    public static final Item MAGICAL_INGOT = registerItem("magical_ingot",
            new Item(new FabricItemSettings()));

    // WEAPOMS

    public static final Item ELITE_WAND = registerItem("elite_wand",
            new MagicStaff(ItemMaterialsRegistry.MAGICAL, 0, -3.0f, new FabricItemSettings().fireproof()));
    public static final Item ELITE_SPELL_BOOK = registerItem("elite_spell_book",
            new SpellBook(ItemMaterialsRegistry.SPELLCASTING, 0, -3.0f, new FabricItemSettings().fireproof()));
    public static final Item NOBLE_SWORD = registerItem("noble_sword",
            new NobleSword(ItemMaterialsRegistry.NOBLE, 6, -2.4f, new FabricItemSettings().fireproof()));
    public static final Item DARK_SWORD = registerItem("dark_sword",
            new Flambard(ItemMaterialsRegistry.DARK, 11, -2.8f, new FabricItemSettings().fireproof()));

    // ARMORS

/*
    public static final Item DARK_KNIGHT_HELMET = registerItem("dark_knight_helmet",
            new DarkKnightArmor(ArmorMaterialsRegistry.DARK, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item DARK_KNIGHT_CHESTPLATE = registerItem("dark_knight_chestplate",
            new DarkKnightArmor(ArmorMaterialsRegistry.DARK, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item DARK_KNIGHT_LEGGINGS = registerItem("dark_knight_leggings",
            new DarkKnightArmor(ArmorMaterialsRegistry.DARK, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item DARK_KNIGHT_BOOTS = registerItem("dark_knight_boots",
            new DarkKnightArmor(ArmorMaterialsRegistry.DARK, ArmorItem.Type.BOOTS, new FabricItemSettings()));
 */

    public static final DarkKnightArmor DARK_KNIGHT_HELMET = new DarkKnightArmor(ArmorMaterialsRegistry.DARK, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof());
    public static final DarkKnightArmor DARK_KNIGHT_CHESTPLATE = new DarkKnightArmor(ArmorMaterialsRegistry.DARK, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof());
    public static final DarkKnightArmor DARK_KNIGHT_LEGGINGS = new DarkKnightArmor(ArmorMaterialsRegistry.DARK, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof());
    public static final DarkKnightArmor DARK_KNIGHT_BOOTS = new DarkKnightArmor(ArmorMaterialsRegistry.DARK, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof());

    public static final WizardArmor ELITE_MAGE_HELMET = new WizardArmor(ArmorMaterialsRegistry.DARK, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof());
    public static final WizardArmor ELITE_MAGE_CHESTPLATE = new WizardArmor(ArmorMaterialsRegistry.DARK, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof());
    public static final WizardArmor ELITE_MAGE_LEGGINGS = new WizardArmor(ArmorMaterialsRegistry.DARK, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof());
    public static final WizardArmor ELITE_MAGE_BOOTS = new WizardArmor(ArmorMaterialsRegistry.DARK, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof());

    public static final BattleMageArmor ARMORED_MAGE_HELMET = new BattleMageArmor(ArmorMaterialsRegistry.DARK, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof());
    public static final BattleMageArmor ARMORED_MAGE_CHESTPLATE = new BattleMageArmor(ArmorMaterialsRegistry.DARK, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof());
    public static final BattleMageArmor ARMORED_MAGE_LEGGINGS = new BattleMageArmor(ArmorMaterialsRegistry.DARK, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof());
    public static final BattleMageArmor ARMORED_MAGE_BOOTS = new BattleMageArmor(ArmorMaterialsRegistry.DARK, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof());

    public static final BlueKnightArmor BLUE_KNIGHT_HELMET = new BlueKnightArmor(ArmorMaterialsRegistry.DARK, ArmorItem.Type.HELMET, new FabricItemSettings().fireproof());
    public static final BlueKnightArmor BLUE_KNIGHT_CHESTPLATE = new BlueKnightArmor(ArmorMaterialsRegistry.DARK, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().fireproof());
    public static final BlueKnightArmor BLUE_KNIGHT_LEGGINGS = new BlueKnightArmor(ArmorMaterialsRegistry.DARK, ArmorItem.Type.LEGGINGS, new FabricItemSettings().fireproof());
    public static final BlueKnightArmor BLUE_KNIGHT_BOOTS = new BlueKnightArmor(ArmorMaterialsRegistry.DARK, ArmorItem.Type.BOOTS, new FabricItemSettings().fireproof());

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(EpicKnightsnMagesFabric.MODID, name), item);
    }

    public static void registerModItems() {
        EpicKnightsnMagesFabric.LOGGER.info("Registering Mod Items for " + EpicKnightsnMagesFabric.MODID);
        DARK_KNIGHT_HELMET.setAttributes(DARK_KNIGHT_HELMET.getAttributeModifiers(EquipmentSlot.HEAD));
        DARK_KNIGHT_CHESTPLATE.setAttributes(DARK_KNIGHT_CHESTPLATE.getAttributeModifiers(EquipmentSlot.CHEST));
        DARK_KNIGHT_LEGGINGS.setAttributes(DARK_KNIGHT_LEGGINGS.getAttributeModifiers(EquipmentSlot.LEGS));
        DARK_KNIGHT_BOOTS.setAttributes(DARK_KNIGHT_BOOTS.getAttributeModifiers(EquipmentSlot.FEET));

        BLUE_KNIGHT_HELMET.setAttributes(BLUE_KNIGHT_HELMET.getAttributeModifiers(EquipmentSlot.HEAD));
        BLUE_KNIGHT_CHESTPLATE.setAttributes(BLUE_KNIGHT_CHESTPLATE.getAttributeModifiers(EquipmentSlot.CHEST));
        BLUE_KNIGHT_LEGGINGS.setAttributes(BLUE_KNIGHT_LEGGINGS.getAttributeModifiers(EquipmentSlot.LEGS));
        BLUE_KNIGHT_BOOTS.setAttributes(BLUE_KNIGHT_BOOTS.getAttributeModifiers(EquipmentSlot.FEET));

        ELITE_MAGE_HELMET.setAttributes(ELITE_MAGE_HELMET.getAttributeModifiers(EquipmentSlot.HEAD));
        ELITE_MAGE_CHESTPLATE.setAttributes(ELITE_MAGE_CHESTPLATE.getAttributeModifiers(EquipmentSlot.CHEST));
        ELITE_MAGE_LEGGINGS.setAttributes(ELITE_MAGE_LEGGINGS.getAttributeModifiers(EquipmentSlot.LEGS));
        ELITE_MAGE_BOOTS.setAttributes(ELITE_MAGE_BOOTS.getAttributeModifiers(EquipmentSlot.FEET));

        ARMORED_MAGE_HELMET.setAttributes(ARMORED_MAGE_HELMET.getAttributeModifiers(EquipmentSlot.HEAD));
        ARMORED_MAGE_CHESTPLATE.setAttributes(ARMORED_MAGE_CHESTPLATE.getAttributeModifiers(EquipmentSlot.CHEST));
        ARMORED_MAGE_LEGGINGS.setAttributes(ARMORED_MAGE_LEGGINGS.getAttributeModifiers(EquipmentSlot.LEGS));
        ARMORED_MAGE_BOOTS.setAttributes(ARMORED_MAGE_BOOTS.getAttributeModifiers(EquipmentSlot.FEET));

        registerItem("dark_knight_helmet", DARK_KNIGHT_HELMET);
        registerItem("dark_knight_chestplate", DARK_KNIGHT_CHESTPLATE);
        registerItem("dark_knight_leggings", DARK_KNIGHT_LEGGINGS);
        registerItem("dark_knight_boots", DARK_KNIGHT_BOOTS);

        registerItem("blue_knight_helmet", BLUE_KNIGHT_HELMET);
        registerItem("blue_knight_chestplate", BLUE_KNIGHT_CHESTPLATE);
        registerItem("blue_knight_leggings", BLUE_KNIGHT_LEGGINGS);
        registerItem("blue_knight_boots", BLUE_KNIGHT_BOOTS);

        registerItem("elite_mage_helmet", ELITE_MAGE_HELMET);
        registerItem("elite_mage_chestplate", ELITE_MAGE_CHESTPLATE);
        registerItem("elite_mage_leggings", ELITE_MAGE_LEGGINGS);
        registerItem("elite_mage_boots", ELITE_MAGE_BOOTS);

        registerItem("armored_mage_helmet", ARMORED_MAGE_HELMET);
        registerItem("armored_mage_chestplate", ARMORED_MAGE_CHESTPLATE);
        registerItem("armored_mage_leggings", ARMORED_MAGE_LEGGINGS);
        registerItem("armored_mage_boots", ARMORED_MAGE_BOOTS);
    }

}
