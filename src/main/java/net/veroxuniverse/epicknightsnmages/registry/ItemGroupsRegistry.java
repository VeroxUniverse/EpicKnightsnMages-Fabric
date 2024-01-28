package net.veroxuniverse.epicknightsnmages.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.veroxuniverse.epicknightsnmages.EpicKnightsnMagesFabric;

public class ItemGroupsRegistry {

    public static final ItemGroup KNM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(EpicKnightsnMagesFabric.MODID, "knm_group"),
            FabricItemGroup.builder().displayName(Text.translatable("itemGroup.knm_group"))
                    .icon(() -> new ItemStack(ItemsRegistry.SCARLET_GEM)).entries((displayContext, entries) -> {
                        // Item Registry
                        entries.add(ItemsRegistry.SCARLET_GEM);
                        entries.add(ItemsRegistry.MOONLIGHT_GEM);
                        entries.add(ItemsRegistry.CITRIN_GEM);
                        entries.add(ItemsRegistry.MAGICAL_INGOT);

                        // Weapon Registry
                        entries.add(ItemsRegistry.ELITE_WAND);
                        entries.add(ItemsRegistry.ELITE_SPELL_BOOK);
                        entries.add(ItemsRegistry.NOBLE_SWORD);
                        entries.add(ItemsRegistry.DARK_SWORD);

                        // Armor Registry
                        entries.add(ItemsRegistry.ELITE_MAGE_HELMET);
                        entries.add(ItemsRegistry.ELITE_MAGE_CHESTPLATE);
                        entries.add(ItemsRegistry.ELITE_MAGE_LEGGINGS);
                        entries.add(ItemsRegistry.ELITE_MAGE_BOOTS);

                        entries.add(ItemsRegistry.ARMORED_MAGE_HELMET);
                        entries.add(ItemsRegistry.ARMORED_MAGE_CHESTPLATE);
                        entries.add(ItemsRegistry.ARMORED_MAGE_LEGGINGS);
                        entries.add(ItemsRegistry.ARMORED_MAGE_BOOTS);

                        entries.add(ItemsRegistry.BLUE_KNIGHT_HELMET);
                        entries.add(ItemsRegistry.BLUE_KNIGHT_CHESTPLATE);
                        entries.add(ItemsRegistry.BLUE_KNIGHT_LEGGINGS);
                        entries.add(ItemsRegistry.BLUE_KNIGHT_BOOTS);

                        entries.add(ItemsRegistry.DARK_KNIGHT_HELMET);
                        entries.add(ItemsRegistry.DARK_KNIGHT_CHESTPLATE);
                        entries.add(ItemsRegistry.DARK_KNIGHT_LEGGINGS);
                        entries.add(ItemsRegistry.DARK_KNIGHT_BOOTS);

                        // Block Registry
                        entries.add(BlocksRegistry.SCARLET_ORE);
                        entries.add(BlocksRegistry.DEEPSLATE_SCARLET_ORE);
                        entries.add(BlocksRegistry.MOONLIGHT_ORE);
                        entries.add(BlocksRegistry.DEEPSLATE_MOONLIGHT_ORE);
                        entries.add(BlocksRegistry.CITRIN_ORE);
                        entries.add(BlocksRegistry.DEEPSLATE_CITRIN_ORE);

                    }).build());

    public static void registerItemGroups() {

    }

}
