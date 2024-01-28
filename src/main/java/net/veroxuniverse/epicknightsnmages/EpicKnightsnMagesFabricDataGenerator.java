package net.veroxuniverse.epicknightsnmages;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.veroxuniverse.epicknightsnmages.datagen.KNMWorldGenerator;
import net.veroxuniverse.epicknightsnmages.worldgen.KNMConfiguredFeatures;
import net.veroxuniverse.epicknightsnmages.worldgen.KNMPlacedFeatures;

public class EpicKnightsnMagesFabricDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(KNMWorldGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, KNMConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, KNMPlacedFeatures::bootstrap);
	}
}