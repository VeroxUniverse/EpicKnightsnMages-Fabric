package net.veroxuniverse.epicknightsnmages.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.veroxuniverse.epicknightsnmages.EpicKnightsnMagesFabric;
import net.veroxuniverse.epicknightsnmages.item.armor.DarkKnightArmor;

public class ItemsRegistry {

    // RESOURCES

    public static final Item CITRIN_GEM = registerItem("citrin_gem",
            new Item(new FabricItemSettings()));

    public static final Item SCARLET_GEM = registerItem("scarlet_gem",
            new Item(new FabricItemSettings()));

    public static final Item MOONLIGHT_GEM = registerItem("moonlight_gem",
            new Item(new FabricItemSettings()));

    // ARMORS

    public static final Item DARK_KNIGHT_HELMET = registerItem("dark_knight_helmet",
            new DarkKnightArmor(ArmorMaterialsRegistry.DARK, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item DARK_KNIGHT_CHESTPLATE = registerItem("dark_knight_chestplate",
            new DarkKnightArmor(ArmorMaterialsRegistry.DARK, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item DARK_KNIGHT_LEGGINGS = registerItem("dark_knight_leggings",
            new DarkKnightArmor(ArmorMaterialsRegistry.DARK, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item DARK_KNIGHT_BOOTS = registerItem("dark_knight_boots",
            new DarkKnightArmor(ArmorMaterialsRegistry.DARK, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(EpicKnightsnMagesFabric.MODID, name), item);
    }

    public static void registerModItems() {
        EpicKnightsnMagesFabric.LOGGER.info("Registering Mod Items for " + EpicKnightsnMagesFabric.MODID);
    }

}
