package net.strunk.funkymod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.strunk.funkymod.FunkyMod;

public class FunkyModItems {

    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, FunkyMod.MOD_ID);

    public static final RegistryObject<Item> EXAMPLE = ITEMS.register("example",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PHONE = ITEMS.register("phone",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
