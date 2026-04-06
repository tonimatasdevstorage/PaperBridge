package dev.tonimatas.mixin.minecraft;

import net.minecraft.ChatFormatting;
import org.jetbrains.annotations.Nullable;
import org.kettingpowered.mixinextras.Public;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ChatFormatting.class)
public abstract class ChatFormattingMixin {

    // Paper - add method to get by hex value
    @Unique
    @Public
    @Nullable
    private static ChatFormatting getByHexValue(int color) {
        for (ChatFormatting value : ChatFormatting.values()) {
            if (value.getColor() != null && value.getColor() == color) {
                return value;
            }
        }

        return null;
    }
}
