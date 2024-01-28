package net.veroxuniverse.epicknightsnmages.client.armor;

import mod.azure.azurelib.renderer.GeoArmorRenderer;
import net.veroxuniverse.epicknightsnmages.item.armor.WizardArmor;

public class WizardArmorRenderer extends GeoArmorRenderer<WizardArmor> {

    public WizardArmorRenderer() {
        super(new WizardArmorModel());
    }
}
