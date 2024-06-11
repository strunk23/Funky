package net.strunk.funkymod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.animal.Cat;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.strunk.funkymod.FunkyMod;
import net.strunk.funkymod.entity.custom.CatEntity;

public class FunkyEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, FunkyMod.MOD_ID);

    public static final RegistryObject<EntityType<CatEntity>> CAT_CUSTOM =
            ENTITY_TYPES.register("cat_custom", () -> EntityType.Builder.of(CatEntity::new, MobCategory.CREATURE)
                    .sized(0.8f, 0.8f).build("cat_custom"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
