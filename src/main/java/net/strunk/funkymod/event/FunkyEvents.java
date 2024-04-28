package net.strunk.funkymod.event;

import net.minecraft.sounds.SoundSource;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.strunk.funkymod.FunkyMod;
import net.strunk.funkymod.sound.FunkySounds;

@Mod.EventBusSubscriber(modid = FunkyMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FunkyEvents {
    @SubscribeEvent
    public static void playPhoneSound(PlayerInteractEvent.RightClickItem event) {
        if (event.getItemStack().getItem().toString().equals("phone")) {
            event.getLevel().playSeededSound(
                    null,
                    event.getPos().getX(),
                    event.getPos().getY(),
                    event.getPos().getZ(),
                    FunkySounds.GPS_SOUND.get(),
                    SoundSource.PLAYERS,
                    1.0f,
                    1.0f,
                    0
            );
        }
    }
}