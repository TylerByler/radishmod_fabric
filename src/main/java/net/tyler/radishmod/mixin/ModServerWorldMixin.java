/*package net.tyler.radishmod.mixin;

import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.PersistentStateManager;
import net.tyler.radishmod.custom.FarmRaidManager;
import net.tyler.radishmod.util.IModServerWorldData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerWorld.class)
public abstract class ModServerWorldMixin implements IModServerWorldData {
    @Shadow public abstract PersistentStateManager getPersistentStateManager();

    private NbtCompound persistentData;
    protected final FarmRaidManager farmRaidManager;

    @Override
    public NbtCompound getPersistentData() {
        if (this.persistentData == null) {
            this.persistentData = new NbtCompound();
        }
        return persistentData;
    }

    @Inject(method = "<init>*", at = @At("RETURN"))
    public void injectConstructor(CallbackInfo info) {
        this.farmRaidManager = ;
    }
}*/
