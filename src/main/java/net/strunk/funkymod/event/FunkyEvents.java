package net.strunk.funkymod.event;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.tags.CatVariantTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.CatVariant;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.strunk.funkymod.FunkyMod;
import net.strunk.funkymod.entity.FunkyEntities;
import net.strunk.funkymod.entity.custom.CatEntity;
import net.strunk.funkymod.sound.FunkySounds;

import java.util.Objects;

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
    @SubscribeEvent
    public static void playCatSound(PlayerInteractEvent.EntityInteractSpecific event) {
        Entity target = event.getTarget();
        Player player = target.level().getNearestPlayer(target, 5);
        if (target instanceof CatEntity) {
            assert player != null;
            if (player.getMainHandItem().getItem().toString().equals("spoon")) {
                event.getLevel().playSeededSound(
                        null,
                        event.getPos().getX(),
                        event.getPos().getY(),
                        event.getPos().getZ(),
                        SoundEvents.CAT_PURREOW,
                        SoundSource.PLAYERS,
                        1.0f,
                        1.0f,
                        0
                );
            }
        }
    }

    @SubscribeEvent
    public static void spawnCustomCat(PlayerInteractEvent.EntityInteractSpecific event) {
        Entity target = event.getTarget();
        Player player = target.level().getNearestPlayer(target, 5);
        Level level = target.getCommandSenderWorld();
        if (target instanceof Cat) {
            assert player != null;
            if (player.getMainHandItem().getItem().equals(Items.APPLE)) {
                replaceCat(level, target, target.getX(), target.getY(), target.getZ());
            }
        }
    }

    @SubscribeEvent
    public static void despawnCustomCat(PlayerInteractEvent.EntityInteractSpecific event) {
        Entity target = event.getTarget();
        Player player = target.level().getNearestPlayer(target, 5);
        Level level = target.getCommandSenderWorld();
        if (target instanceof CatEntity) {
            assert player != null;
            if (player.getMainHandItem().getItem().toString().equals("air")) {
                replaceCatCustom(level, target, target.getX(), target.getY(), target.getZ());
            }
        }
    }

    private static Entity replaceCat(Level level, Entity entity, double x, double y, double z) {
        entity.remove(Entity.RemovalReason.CHANGED_DIMENSION);
        EntityType<CatEntity> newCat = FunkyEntities.CAT_CUSTOM.get();
        CatEntity cat = newCat.create(level);
        if (cat != null) {
            cat.setPos(x, y, z);
            level.addFreshEntity(cat);
            return cat;
        }
        return null;
    }

    private static Entity replaceCatCustom(Level level, Entity entity, double x, double y, double z) {
        entity.remove(Entity.RemovalReason.CHANGED_DIMENSION);
        EntityType<Cat> newCat = EntityType.CAT;
        Cat cat = newCat.create(level);
        if (cat != null) {
            cat.setVariant(Objects.requireNonNull(BuiltInRegistries.CAT_VARIANT.get(CatVariant.WHITE)));
            cat.setPos(x, y, z);
            level.addFreshEntity(cat);
            return cat;
        }

        //
        ; //.setVariant(variant);
        return null;
    }
}
