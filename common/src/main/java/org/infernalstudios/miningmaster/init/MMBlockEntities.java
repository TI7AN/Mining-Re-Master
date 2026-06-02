//package org.infernalstudios.miningmaster.init;
//
//import net.minecraft.core.Registry;
//import net.minecraft.core.registries.BuiltInRegistries;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.entity.BlockEntityType;
//import org.infernalstudios.miningmaster.MiningMaster;
//import org.infernalstudios.miningmaster.block.entity.GemForgeBlockEntity;
//
//public class MMBlockEntities {
//    public static final BlockEntityType<GemForgeBlockEntity> GEM_FORGE_BLOCK_ENTITY =
//            register("gem_forge", GemForgeBlockEntity::new, MMBlocks.GEM_FORGE);
//
//    private static <T extends BlockEntity> BlockEntityType<T> register(String name,
//                                                                       BlockEntityType.BlockEntitySupplier<? extends T> entityFactory,
//                                                                       Block... blocks) {
//        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, name);
//        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, id, BlockEntityType.Builder.<T>of(entityFactory, blocks)
//                .build()
//        );
//    }
//
//    public static void init() {
//        MiningMaster.LOGGER.info("Block entities registered");
//    };
//}
