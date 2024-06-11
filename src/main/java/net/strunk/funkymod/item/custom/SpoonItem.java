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
        }
        return super.useOn(pContext);
    }
}
