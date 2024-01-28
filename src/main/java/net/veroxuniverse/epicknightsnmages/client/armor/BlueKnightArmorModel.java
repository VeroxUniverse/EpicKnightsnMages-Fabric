package net.veroxuniverse.epicknightsnmages.client.armor;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.util.Identifier;
import net.veroxuniverse.epicknightsnmages.EpicKnightsnMagesFabric;
import net.veroxuniverse.epicknightsnmages.item.armor.BlueKnightArmor;
import net.veroxuniverse.epicknightsnmages.item.armor.DarkKnightArmor;

public class BlueKnightArmorModel extends GeoModel<BlueKnightArmor> {
    @Override
    public Identifier getModelResource(BlueKnightArmor armorItem) {
        return new Identifier(EpicKnightsnMagesFabric.MODID, "geo/blue_knight_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(BlueKnightArmor armorItem) {
        return new Identifier(EpicKnightsnMagesFabric.MODID, "textures/armor/blue_knight_armor_textures_eyes.png");
    }

    @Override
    public Identifier getAnimationResource(BlueKnightArmor armorItem) {
        return new Identifier(EpicKnightsnMagesFabric.MODID, "animations/empty.animation.json");
    }
}
