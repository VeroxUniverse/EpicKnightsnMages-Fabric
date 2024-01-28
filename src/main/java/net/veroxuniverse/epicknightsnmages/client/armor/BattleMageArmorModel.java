package net.veroxuniverse.epicknightsnmages.client.armor;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.util.Identifier;
import net.veroxuniverse.epicknightsnmages.EpicKnightsnMagesFabric;
import net.veroxuniverse.epicknightsnmages.item.armor.BattleMageArmor;
import net.veroxuniverse.epicknightsnmages.item.armor.DarkKnightArmor;

public class BattleMageArmorModel extends GeoModel<BattleMageArmor> {
    @Override
    public Identifier getModelResource(BattleMageArmor armorItem) {
        return new Identifier(EpicKnightsnMagesFabric.MODID, "geo/armored_mage_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(BattleMageArmor armorItem) {
        return new Identifier(EpicKnightsnMagesFabric.MODID, "textures/armor/armored_mage_armor_textures.png");
    }

    @Override
    public Identifier getAnimationResource(BattleMageArmor armorItem) {
        return new Identifier(EpicKnightsnMagesFabric.MODID, "animations/empty.animation.json");
    }
}
