package net.veroxuniverse.epicknightsnmages.worldgen;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.veroxuniverse.epicknightsnmages.EpicKnightsnMagesFabric;

import java.util.List;

public class KNMPlacedFeatures {
    public static final RegistryKey<PlacedFeature> CITRIN_ORE_PLACED_KEY = registerKey("citrin_ore_placed");
    public static final RegistryKey<PlacedFeature> SCARLET_ORE_PLACED_KEY = registerKey("scarlet_ore_placed");
    public static final RegistryKey<PlacedFeature> MOONLIGHT_ORE_PLACED_KEY = registerKey("moonlight_ore_placed");


    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, CITRIN_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(KNMConfiguredFeatures.CITRIN_ORE_KEY),
                KNMOrePlacement.modifiersWithCount(2,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(30))));

        register(context, SCARLET_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(KNMConfiguredFeatures.SCARLET_ORE_KEY),
                KNMOrePlacement.modifiersWithCount(2,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(30))));

        register(context, MOONLIGHT_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(KNMConfiguredFeatures.MOONLIGHT_ORE_KEY),
                KNMOrePlacement.modifiersWithCount(2,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(30))));
    }


    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(EpicKnightsnMagesFabric.MODID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}