package net.strunk.funkymod;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import net.strunk.funkymod.block.FunkyModBlocks;
import net.strunk.funkymod.entity.FunkyEntities;
import net.strunk.funkymod.entity.client.CatRenderer;
import net.strunk.funkymod.entity.custom.CatOverride;
import net.strunk.funkymod.item.FunkyModCreativeTab;
import net.strunk.funkymod.item.FunkyModItems;
import net.strunk.funkymod.sound.FunkySounds;

@Mod(FunkyMod.MOD_ID)
public class FunkyMod {
    public static final String MOD_ID = "funkymod";

    public FunkyMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        FunkyModItems.register(modEventBus);
        FunkyModBlocks.register(modEventBus);
        FunkySounds.register(modEventBus);
        FunkyModCreativeTab.register(modEventBus);
        FunkyEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(FunkyEntities.CAT_CUSTOM.get(), CatRenderer::new);
        }
    }
}
