package net.strunk.funkymod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class ParticleBlock extends Block {

    public ParticleBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);
        pLevel.addParticle(
                ParticleTypes.NOTE,
                pPos.getX() + 0.5,
                pPos.getY() + 1,
                pPos.getZ() + 0.5,
                0.0d,
                0.0d,
                0.0d);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        pPlayer.playSound(
                SoundEvents.NOTE_BLOCK_BIT.get(),
                1f,
                1f);
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }
}
