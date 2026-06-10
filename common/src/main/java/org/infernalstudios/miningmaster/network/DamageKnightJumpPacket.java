/*
 * Copyright 2021 Infernal Studios
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.infernalstudios.miningmaster.network;

import dev.architectury.networking.NetworkManager;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
//import net.minecraftforge.network.NetworkEvent;
import org.infernalstudios.miningmaster.MiningMaster;

import java.util.function.Supplier;

public record DamageKnightJumpPacket(int damage) implements CustomPacketPayload {
    public static final Type<DamageKnightJumpPacket> TYPE = new Type<>(MiningMaster.prefix("damage_knight_jump"));

    public static final StreamCodec<RegistryFriendlyByteBuf, DamageKnightJumpPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT,
            r -> r.damage,
            DamageKnightJumpPacket::new
    );

    public DamageKnightJumpPacket(int damage) {
        this.damage = damage;
    }

    public static void encode(DamageKnightJumpPacket message, FriendlyByteBuf buffer) {
        buffer.writeInt(message.damage);
    }

    public static DamageKnightJumpPacket decode(FriendlyByteBuf buffer) {
        return new DamageKnightJumpPacket(buffer.readInt());
    }

    public static void handle(DamageKnightJumpPacket message, NetworkManager.PacketContext context) {
        context.queue(() -> {
            Player playerEntity = context.getPlayer();

            if (playerEntity != null) {
                ItemStack stack = playerEntity.getItemBySlot(EquipmentSlot.LEGS);
                stack.hurtAndBreak(message.damage, playerEntity
//                        , (onBroken) -> onBroken.broadcastBreakEvent(EquipmentSlot.LEGS)
                        ,EquipmentSlot.LEGS
                );
            }
        });

    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
