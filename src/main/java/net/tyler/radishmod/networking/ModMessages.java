package net.tyler.radishmod.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;
import net.tyler.radishmod.RadishMod;
import net.tyler.radishmod.networking.packet.RadscalS2CPacket;

public class ModMessages {
    public static final Identifier RADSCAL_SWING = new Identifier(RadishMod.MOD_ID, "radscalswing");

    public static void registerC2SPackets() {

    }

    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(RADSCAL_SWING, RadscalS2CPacket::receive);

    }
}
