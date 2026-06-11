package org.infernalstudios.fabric.miningmaster.mixin;

import com.google.common.collect.ImmutableList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.infernalstudios.miningmaster.loot.function.SmeltingLootFunction;
import org.infernalstudios.miningmaster.loot.function.StonebreakerLootFunction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(LootTable.Builder.class)
public class LootTableMixin {

    @Shadow
    private final ImmutableList.Builder<LootPool> pools = ImmutableList.builder();
    @Shadow
    private final ImmutableList.Builder<LootItemFunction> functions = ImmutableList.builder();
    @Shadow
    private LootContextParamSet paramSet = LootTable.DEFAULT_PARAM_SET;
    @Shadow
    private Optional<ResourceLocation> randomSequence = Optional.empty();

    @Inject(method = "build", at = @At("HEAD"))
    private void miningmaster$injectFunctions(CallbackInfoReturnable<LootTable> cir) {
        if (this.paramSet == LootContextParamSets.BLOCK) {
            this.functions.add(SmeltingLootFunction.builder().build());
            this.functions.add(StonebreakerLootFunction.builder().build());
        }
    }


//    @ModifyArg(
//            method = "build",
//            at = @At(
//                    value = "INVOKE",
//                    target = "LootTable.<init>"
//            ),
//            index = 3
//    )
//    private static void miningmaster$injectFunctions(
//            LootContextParamSet paramSet,
//            Optional<ResourceLocation> randomSequence,
//            List<LootPool> pools,
//            List<LootItemFunction> functions,
//            CallbackInfo ci
//    ) {
//
//    }
}
