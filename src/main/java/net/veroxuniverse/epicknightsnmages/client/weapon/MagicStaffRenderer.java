package net.veroxuniverse.epicknightsnmages.client.weapon;

import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.renderer.GeoItemRenderer;
import net.minecraft.util.Identifier;
import net.veroxuniverse.epicknightsnmages.EpicKnightsnMagesFabric;
import net.veroxuniverse.epicknightsnmages.item.weapon.MagicStaff;
import net.veroxuniverse.epicknightsnmages.item.weapon.SpellBook;

public class MagicStaffRenderer extends GeoItemRenderer<MagicStaff> {

    public MagicStaffRenderer() {

        super(new GeoModel<MagicStaff>() {
            @Override
            public Identifier getModelResource(MagicStaff magicStaff) {
                return new Identifier(EpicKnightsnMagesFabric.MODID, "geo/elite_wand.geo.json");
            }

            @Override
            public Identifier getTextureResource(MagicStaff magicStaff) {
                return new Identifier(EpicKnightsnMagesFabric.MODID, "textures/item/elite_wand.png");
            }

            @Override
            public Identifier getAnimationResource(MagicStaff magicStaff) {
                return new Identifier(EpicKnightsnMagesFabric.MODID, "animations/elite_wand.animation.json");
            }
        });

    }

}
