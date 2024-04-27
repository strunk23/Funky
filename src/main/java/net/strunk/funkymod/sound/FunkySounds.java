package net.strunk.funkymod.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.strunk.funkymod.FunkyMod;

public class FunkySounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, FunkyMod.MOD_ID);

    public static final RegistryObject<SoundEvent> GPS_SOUND = registerSoundEvents("gps_sound");

    private static RegistryObject<SoundEvent> registerSoundEvents(String gpsSound) {
        return SOUND_EVENTS.register(gpsSound, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(FunkyMod.MOD_ID, gpsSound)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
