package net.veroxuniverse.epicknightsnmages;

import mod.azure.azurelib.AzureLib;
import net.fabricmc.api.ModInitializer;
import net.veroxuniverse.epicknightsnmages.registry.BlocksRegistry;
import net.veroxuniverse.epicknightsnmages.registry.ItemGroupsRegistry;
import net.veroxuniverse.epicknightsnmages.registry.ItemsRegistry;
import net.veroxuniverse.epicknightsnmages.worldgen.gen.KNMWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EpicKnightsnMagesFabric implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("epicknightsnmages");
	public static final String MODID = "epicknightsnmages";

	@Override
	public void onInitialize() {

		AzureLib.initialize();

		KNMWorldGeneration.generateModWorldGeneration();

		ItemGroupsRegistry.registerItemGroups();
		ItemsRegistry.registerModItems();
		BlocksRegistry.registerModBlocks();

		LOGGER.info("Epic Knights'n'Mages loaded!");
	}
}