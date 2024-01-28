package net.veroxuniverse.epicknightsnmages.worldgen;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.veroxuniverse.epicknightsnmages.EpicKnightsnMagesFabric;
import net.veroxuniverse.epicknightsnmages.registry.BlocksRegistry;

import java.util.List;

public class KNMConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> CITRIN_ORE_KEY = registerKey("citrin_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SCARLET_ORE_KEY = registerKey("scarlet_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MOONLIGHT_ORE_KEY = registerKey("moonlight_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);


        List<OreFeatureConfig.Target> overworldCitrinOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, BlocksRegistry.CITRIN_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, BlocksRegistry.DEEPSLATE_CITRIN_ORE.getDefaultState()));

        register(context, CITRIN_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldCitrinOres, 9));

        List<OreFeatureConfig.Target> overworldScarletOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, BlocksRegistry.SCARLET_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, BlocksRegistry.DEEPSLATE_SCARLET_ORE.getDefaultState()));

        register(context, SCARLET_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldScarletOres, 9));

        List<OreFeatureConfig.Target> overworldMoonlightOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, BlocksRegistry.MOONLIGHT_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, BlocksRegistry.DEEPSLATE_MOONLIGHT_ORE.getDefaultState()));

        register(context, MOONLIGHT_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldMoonlightOres, 9));

    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(EpicKnightsnMagesFabric.MODID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
