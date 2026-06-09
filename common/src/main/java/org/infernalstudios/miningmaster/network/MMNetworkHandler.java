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
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
//import net.minecraftforge.network.NetworkRegistry;
//import net.minecraftforge.network.PacketDistributor;
//import net.minecraftforge.network.simple.SimpleChannel;
import org.infernalstudios.miningmaster.MiningMaster;

public class MMNetworkHandler {
    public static final ResourceLocation UPDATE_GEM_FORGE =
            ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "update_gem_forge");

    public static final ResourceLocation DAMAGE_KNIGHT_JUMP =
            ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "damage_knight_jump");

    public static void init() {

        NetworkManager.registerReceiver(
                NetworkManager.Side.C2S,
                UpdateGemForgePacket.TYPE,
                UpdateGemForgePacket.STREAM_CODEC,
                UpdateGemForgePacket::handle
        );

//        NetworkManager.registerReceiver(
//                NetworkManager.Side.C2S,
//                DAMAGE_KNIGHT_JUMP,
//                DamageKnightJumpPacket::handle
//        );
    }

//    private static final String PROTOCOL_VERSION = "1";
//    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
//            ResourceLocation.fromNamespaceAndPath(MiningMaster.MOD_ID, "main"),
//            () -> PROTOCOL_VERSION,
//            PROTOCOL_VERSION::equals,
//            PROTOCOL_VERSION::equals
//    );
//
//    private static int index;
//
//    public static synchronized void register() {
//        INSTANCE.messageBuilder(UpdateGemForgePacket.class, index++)
//                .encoder(UpdateGemForgePacket::encode)
//                .decoder(UpdateGemForgePacket::decode)
//                .consumerMainThread(UpdateGemForgePacket::handle).add();
//        INSTANCE.messageBuilder(DamageKnightJumpPacket.class, index++)
//                .encoder(DamageKnightJumpPacket::encode)
//                .decoder(DamageKnightJumpPacket::decode)
//                .consumerMainThread(DamageKnightJumpPacket::handle).add();
//    }
//
//    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
//        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
//    }
//
//    public static <MSG> void sendToAll(MSG message) {
//        INSTANCE.send(PacketDistributor.ALL.noArg(), message);
//    }
//
//    public static <MSG> void sendToServer(MSG message) {
//        NetworkManager.sendToServer(
//                UPDATE_GEM_FORGE,
//                buf -> MSG.encode(message, buf)
//        );
//    }

    public static <T extends CustomPacketPayload> void sendToPlayer(ServerPlayer player, T msg) {
        NetworkManager.sendToPlayer(player, msg);
    }

    public static <T extends CustomPacketPayload> void sendToServer(T msg) {
        NetworkManager.sendToServer(msg);
    }

//    public static <T extends CustomPacketPayload> void sendToAll(T msg) {
//        NetworkManager.sendToPlayers();
//    }
}
