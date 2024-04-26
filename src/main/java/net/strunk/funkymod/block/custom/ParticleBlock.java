package net.strunk.funkymod.block.custom;

import net.minecraft.client.particle.NoteParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.NoteBlockEvent;
import org.jetbrains.annotations.Nullable;

public class ParticleBlock extends Block {

    public ParticleBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);
        spawnNoteParticle(pLevel, pPos.getX(), pPos.getY(), pPos.getZ());
    }

    private void spawnNoteParticle(Level level, double x, double y, double z) {
        level.addParticle(ParticleTypes.NOTE, x, y, z, 0.0d, 0.0d, 0.0d);
    }
}
