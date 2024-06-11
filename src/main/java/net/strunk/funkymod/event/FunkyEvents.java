package net.strunk.funkymod.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.CatVariant;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SandBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.strunk.funkymod.FunkyMod;
import net.strunk.funkymod.block.FunkyModBlocks;
import net.strunk.funkymod.block.custom.ParticleBlock;
import net.strunk.funkymod.entity.FunkyEntities;
import net.strunk.funkymod.entity.custom.CatEntity;
import net.strunk.funkymod.item.FunkyModItems;
import net.strunk.funkymod.sound.FunkySounds;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = FunkyMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FunkyEvents {

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
}