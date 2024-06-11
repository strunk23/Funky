package net.strunk.funkymod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SpoonItem extends Item {
    public SpoonItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, Player player) {

        return super.onBlockStartBreak(itemstack, pos, player);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos pos = pContext.getClickedPos();

        level.removeBlock(pos, false);
        for (int i = 0; i < 40; i++) {
            double angle = 2 * Math.PI * i / 40;
            double x = pos.getX() + (3 * Math.cos(angle));
            double z = pos.getZ() + (3 * Math.sin(angle));
            int y = pos.getY();
            level.addParticle(ParticleTypes.NOTE,
                    x + 0.5,
                    y + 1,
                    z + 0.5,
                    0.0d,
                    0.0d,
                    0.0d);
            /*
            FallingBlockEntity fallingBlock = FallingBlockEntity.fall(level, pos, state);
            fallingBlock.setPos(x + 0.5, y, z + 0.5);
            fallingBlock.setDeltaMovement(0, 1, 0);
            level.addFreshEntity(fallingBlock);

             */
        }
        /*
        FallingBlockEntity fallingBlock = FallingBlockEntity.fall(level, pos, state);
        //FallingBlockEntity fallingBlock = EntityType.FALLING_BLOCK.create(level);
        //FallingBlockEntity fallingBlock = EntityType.FALLING_BLOCK.spawn(serverLevel, pos, type);
        //assert fallingBlock != null;
        fallingBlock.setPos(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
        //fallingBlock.setHurtsEntities(3, 30);
        fallingBlock.setDeltaMovement(0, 1, 1);
        level.addFreshEntity(fallingBlock);
         */

        return super.useOn(pContext);
    }
}
