package net.tyler.radishmod.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;
import net.tyler.radishmod.RadishMod;
import net.tyler.radishmod.networking.packet.OpenCrateS2CPacket;

public class ModMessages {
    public static final Identifier OPEN_RADISH_CRATE = new Identifier(RadishMod.MOD_ID, "open_radish_crate");

    public static void registerC2SPackets() {

    }

    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(OPEN_RADISH_CRATE, OpenCrateS2CPacket::receive);

    }
}
