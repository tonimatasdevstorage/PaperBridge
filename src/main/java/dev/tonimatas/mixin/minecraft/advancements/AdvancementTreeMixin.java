package dev.tonimatas.mixin.minecraft.advancements;

import net.minecraft.advancements.AdvancementTree;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AdvancementTree.class)
public class AdvancementTreeMixin {
    @Redirect(method = "remove(Lnet/minecraft/advancements/AdvancementNode;)V", at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;info(Ljava/lang/String;Ljava/lang/Object;)V"))
    private void ethylene$remove(Logger instance, String s, Object o) {
        instance.debug(s, o); // Paper - Improve logging and errors
    }

    @Redirect(method = "addAll", at = @At(value = "INVOKE", target = "Lorg/slf4j/Logger;info(Ljava/lang/String;Ljava/lang/Object;)V"))
    private void ethylene$addAll(Logger instance, String s, Object o) {
        instance.debug(s, o); // CraftBukkit - moved to AdvancementDataWorld#reload // Paper - Improve logging and errors; you say it was moved... but it wasn't :) it should be moved however, since this is called when the API creates an advancement
    }
}
