package net.veroxuniverse.epicknightsnmages.client.armor;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.util.Identifier;
import net.veroxuniverse.epicknightsnmages.EpicKnightsnMagesFabric;
import net.veroxuniverse.epicknightsnmages.item.armor.DarkKnightArmor;
import net.veroxuniverse.epicknightsnmages.item.armor.WizardArmor;

public class WizardArmorModel extends GeoModel<WizardArmor> {
    @Override
    public Identifier getModelResource(WizardArmor armorItem) {
        return new Identifier(EpicKnightsnMagesFabric.MODID, "geo/elite_mage_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(WizardArmor armorItem) {
        return new Identifier(EpicKnightsnMagesFabric.MODID, "textures/armor/elite_mage_armor_textures.png");
    }

    @Override
    public Identifier getAnimationResource(WizardArmor armorItem) {
        return new Identifier(EpicKnightsnMagesFabric.MODID, "animations/elite_mage_armor.animation.json");
    }
}
