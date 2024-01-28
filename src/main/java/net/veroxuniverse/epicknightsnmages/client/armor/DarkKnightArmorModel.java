package net.veroxuniverse.epicknightsnmages.client.armor;

import mod.azure.azurelib.model.GeoModel;
import net.minecraft.util.Identifier;
import net.veroxuniverse.epicknightsnmages.EpicKnightsnMagesFabric;
import net.veroxuniverse.epicknightsnmages.item.armor.DarkKnightArmor;

public class DarkKnightArmorModel extends GeoModel<DarkKnightArmor> {
    @Override
    public Identifier getModelResource(DarkKnightArmor armorItem) {
        return new Identifier(EpicKnightsnMagesFabric.MODID, "geo/dark_knight_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(DarkKnightArmor armorItem) {
        return new Identifier(EpicKnightsnMagesFabric.MODID, "textures/armor/dark_knight_armor_textures.png");
    }

    @Override
    public Identifier getAnimationResource(DarkKnightArmor armorItem) {
        return new Identifier(EpicKnightsnMagesFabric.MODID, "animations/empty.animation.json");
    }
}
