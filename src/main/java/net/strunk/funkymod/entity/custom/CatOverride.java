package net.strunk.funkymod.entity.custom;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.CatVariant;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.strunk.funkymod.entity.FunkyEntities;

public class CatOverride extends Cat {
    public CatOverride(EntityType<? extends Cat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (stack.getItem() == Items.APPLE) {
            if (!this.level().isClientSide()) {
                stack.shrink(1);
                EntityType<CatEntity> newCat = FunkyEntities.CAT_CUSTOM.get();
                CatEntity cat = newCat.create(player.level());
                if (cat != null) {
                    cat.setPos(this.getX(), this.getY(), this.getZ());
                    player.level().addFreshEntity(cat);
                }
            }
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }

    @Override
    public void die(DamageSource pCause) {
        if (getVariant().equals(BuiltInRegistries.CAT_VARIANT.get(CatVariant.WHITE))) {
            System.out.println(pCause.getDirectEntity().getEyePosition());
        }
        super.die(pCause);
    }
}
