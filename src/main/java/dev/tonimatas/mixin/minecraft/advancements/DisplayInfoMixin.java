package dev.tonimatas.mixin.minecraft.advancements;

import net.minecraft.advancements.DisplayInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(DisplayInfo.class)
public class DisplayInfoMixin {
    @Unique
    public final io.papermc.paper.advancement.AdvancementDisplay paper = new io.papermc.paper.advancement.PaperAdvancementDisplay((DisplayInfo) (Object) this); // Paper - Add more advancement API
}
