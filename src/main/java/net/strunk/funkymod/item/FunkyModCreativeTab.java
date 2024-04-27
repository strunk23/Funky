package net.strunk.funkymod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.strunk.funkymod.FunkyMod;
import net.strunk.funkymod.block.FunkyModBlocks;

public class FunkyModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB_FUNKY =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FunkyMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FUNKY_MOD_TAB = CREATIVE_MODE_TAB_FUNKY.register("funky_mod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(FunkyModItems.EXAMPLE.get()))
                    .title(Component.translatable("creativetab.funky_mod_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(FunkyModItems.EXAMPLE.get());
                        pOutput.accept(FunkyModItems.PHONE.get());
                        pOutput.accept(FunkyModBlocks.EXAMPLE_BLOCK.get());
                        pOutput.accept(FunkyModBlocks.PARTICLE_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB_FUNKY.register(eventBus);
    }
}
