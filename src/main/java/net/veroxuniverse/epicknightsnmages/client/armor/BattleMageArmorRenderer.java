package net.veroxuniverse.epicknightsnmages.client.armor;

import mod.azure.azurelib.renderer.GeoArmorRenderer;
import net.veroxuniverse.epicknightsnmages.item.armor.BattleMageArmor;

public class BattleMageArmorRenderer extends GeoArmorRenderer<BattleMageArmor> {

    public BattleMageArmorRenderer() {
        super(new BattleMageArmorModel());
    }
}
