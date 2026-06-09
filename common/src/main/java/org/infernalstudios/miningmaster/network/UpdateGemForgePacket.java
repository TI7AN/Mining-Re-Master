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
import net.minecraft.world.entity.player.Player;
//import net.minecraftforge.network.NetworkEvent;
import org.infernalstudios.miningmaster.MiningMaster;
import org.infernalstudios.miningmaster.container.GemForgeMenu;

import java.util.function.Supplier;

public record UpdateGemForgePacket(boolean isActive) implements CustomPacketPayload {
    public static final Type<UpdateGemForgePacket> TYPE = new Type<>(MiningMaster.prefix("gem_forge"));

    public static final StreamCodec<RegistryFriendlyByteBuf, UpdateGemForgePacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.BOOL,
            r -> r.isActive,
            UpdateGemForgePacket::new
    );

    public UpdateGemForgePacket(boolean isActive) {
        this.isActive = isActive;
    }

    public static void encode(UpdateGemForgePacket message, RegistryFriendlyByteBuf buffer) {
        buffer.writeBoolean(message.isActive);
    }

    public static UpdateGemForgePacket decode(RegistryFriendlyByteBuf buffer) {
        return new UpdateGemForgePacket(buffer.readBoolean());
    }

    public static void handle(UpdateGemForgePacket message, NetworkManager.PacketContext context) {
        context.queue(() -> {
            Player playerEntity = context.getPlayer();

            if (playerEntity != null && playerEntity.getServer() != null && playerEntity.containerMenu instanceof GemForgeMenu) {
                ((GemForgeMenu)playerEntity.containerMenu).setForgeActive(message.isActive);
            }
        });

//        context.get().setPacketHandled(true);
    }

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
