package net.tyler.radishmod.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;

public class OpenCrateS2CPacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        // Everything here happens only on client

    }
}
