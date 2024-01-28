package net.veroxuniverse.epicknightsnmages.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.veroxuniverse.epicknightsnmages.EpicKnightsnMagesFabric;

public class BlocksRegistry {

    public static final Block SCARLET_ORE = registerBlock("scarlet_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).strength(4f).requiresTool(), UniformIntProvider.create(3, 7)));
    public static final Block DEEPSLATE_SCARLET_ORE = registerBlock("deepslate_scarlet_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).strength(4f).requiresTool(), UniformIntProvider.create(3, 7)));

    public static final Block CITRIN_ORE = registerBlock("citrin_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).strength(4f).requiresTool(), UniformIntProvider.create(3, 7)));
    public static final Block DEEPSLATE_CITRIN_ORE = registerBlock("deepslate_citrin_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).strength(4f).requiresTool(), UniformIntProvider.create(3, 7)));

    public static final Block MOONLIGHT_ORE = registerBlock("moonlight_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).strength(4f).requiresTool(), UniformIntProvider.create(3, 7)));
    public static final Block DEEPSLATE_MOONLIGHT_ORE = registerBlock("deepslate_moonlight_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).strength(4f).requiresTool(), UniformIntProvider.create(3, 7)));
    
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(EpicKnightsnMagesFabric.MODID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(EpicKnightsnMagesFabric.MODID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        EpicKnightsnMagesFabric.LOGGER.info("Registering ModBlocks for " + EpicKnightsnMagesFabric.MODID);
    }
}