package net.strunk.funkymod.event;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.CatVariant;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.strunk.funkymod.FunkyMod;
import net.strunk.funkymod.entity.FunkyEntities;
import net.strunk.funkymod.entity.custom.CatEntity;

@Mod.EventBusSubscriber(modid = FunkyMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class WhiteCatInteractionEvent {
    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent.EntityInteractSpecific event) {
        Entity entity = event.getTarget();
        Level level = event.getLevel();
        ItemStack item = event.getItemStack();

        if (entity instanceof Cat && item.getItem().toString().equals("apple") && ((Cat) entity).getVariant().equals(BuiltInRegistries.CAT_VARIANT.get(CatVariant.WHITE))) {
            spawnCustomCat(level, entity, entity.getX(), entity.getY(), entity.getZ());
            item.shrink(1);
        }
    }

    private static void spawnCustomCat(Level level, Entity entity, double x, double y, double z) {
        entity.remove(Entity.RemovalReason.CHANGED_DIMENSION);
        EntityType<CatEntity> newCat = FunkyEntities.CAT_CUSTOM.get();
        CatEntity cat = newCat.create(level);
        if (cat != null) {
            cat.setPos(x, y, z);
            level.addFreshEntity(cat);
        }
    }
}
