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

                        // Armor Registry
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
