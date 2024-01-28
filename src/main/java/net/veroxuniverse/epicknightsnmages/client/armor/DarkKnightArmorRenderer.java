package net.veroxuniverse.epicknightsnmages.client.armor;

import mod.azure.azurelib.renderer.GeoArmorRenderer;
import net.veroxuniverse.epicknightsnmages.item.armor.DarkKnightArmor;

public class DarkKnightArmorRenderer extends GeoArmorRenderer<DarkKnightArmor> {

    public DarkKnightArmorRenderer() {
        super(new DarkKnightArmorModel());
    }
}
