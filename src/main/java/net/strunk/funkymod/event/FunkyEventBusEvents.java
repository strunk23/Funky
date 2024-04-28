package net.strunk.funkymod.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.strunk.funkymod.FunkyMod;
import net.strunk.funkymod.entity.FunkyEntities;
import net.strunk.funkymod.entity.client.CatCustom;
import net.strunk.funkymod.entity.custom.CatEntity;

@Mod.EventBusSubscriber(modid = FunkyMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FunkyEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(FunkyEntities.CAT_CUSTOM.get(), CatEntity.createAttributes().build());
    }
}
