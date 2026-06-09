package org.infernalstudios.miningmaster.init;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.infernalstudios.miningmaster.MiningMaster;
import org.infernalstudios.miningmaster.block.entity.GemForgeBlockEntity;

public class MMBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(MiningMaster.MOD_ID, Registries.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<GemForgeBlockEntity>> GEM_FORGE_BLOCK_ENTITY =
            BLOCK_ENTITY_TYPES.register(
                    "gem_forge_tile_entity",
                    () -> BlockEntityType.Builder.of(
                            GemForgeBlockEntity::new,
                            MMBlocks.GEM_FORGE.get())
                            .build(null)
            );

//    private static <T extends BlockEntity> BlockEntityType<T> register(
//            String name,
//            BlockEntityType.BlockEntitySupplier<? extends T> entityFactory,
//            Block... blocks)
//    {
//        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, name);
//        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, id, BlockEntityType.Builder.<T>of(entityFactory, blocks)
//                .build()
//        );
//    }

    public static void init() {
        BLOCK_ENTITY_TYPES.register();
        MiningMaster.LOGGER.info("Block entities registered");
    };
}
