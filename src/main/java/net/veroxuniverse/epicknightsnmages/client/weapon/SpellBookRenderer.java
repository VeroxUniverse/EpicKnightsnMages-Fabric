package net.veroxuniverse.epicknightsnmages.client.weapon;

import mod.azure.azurelib.model.GeoModel;
import mod.azure.azurelib.renderer.GeoItemRenderer;
import net.minecraft.util.Identifier;
import net.veroxuniverse.epicknightsnmages.EpicKnightsnMagesFabric;
import net.veroxuniverse.epicknightsnmages.item.weapon.SpellBook;

public class SpellBookRenderer extends GeoItemRenderer<SpellBook> {

    public SpellBookRenderer() {

        super(new GeoModel<SpellBook>() {
            @Override
            public Identifier getModelResource(SpellBook spellBook) {
                return new Identifier(EpicKnightsnMagesFabric.MODID, "geo/elite_spell_book.geo.json");
            }

            @Override
            public Identifier getTextureResource(SpellBook spellBook) {
                return new Identifier(EpicKnightsnMagesFabric.MODID, "textures/item/elite_spell_book.png");
            }

            @Override
            public Identifier getAnimationResource(SpellBook spellBook) {
                return new Identifier(EpicKnightsnMagesFabric.MODID, "animations/elite_spell_book.animation.json");
            }
        });

    }

}
