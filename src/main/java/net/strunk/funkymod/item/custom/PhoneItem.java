package net.strunk.funkymod.item.custom;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.strunk.funkymod.sound.FunkySounds;
import org.jetbrains.annotations.NotNull;

public class PhoneItem extends Item {
    public PhoneItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Player player = pContext.getPlayer();
        assert player != null;
        level.playSeededSound(
                null,
                player.getX(),
                player.getY(),
                player.getZ(),
                FunkySounds.GPS_SOUND.get(),
                SoundSource.PLAYERS,
                1.0f,
                1.0f,
                0
                );

        return super.useOn(pContext);
    }
}
