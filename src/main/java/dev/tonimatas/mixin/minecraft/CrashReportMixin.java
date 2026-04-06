package dev.tonimatas.mixin.minecraft;

import net.minecraft.CrashReport;
import net.minecraft.SystemReport;
import org.bukkit.craftbukkit.CraftCrashReport;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CrashReport.class)
public class CrashReportMixin {
    @Shadow
    @Final
    private SystemReport systemReport;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void ethylene$init(CallbackInfo ci) {
        this.systemReport.setDetail("CraftBukkit Information", new CraftCrashReport()); // CraftBukkit
    }
    
    @Redirect(method = "preload", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/MemoryReserve;allocate()V"))
    private static void ethylene$preload() {
        // Paper - Disable memory reserve allocating
    }
}
