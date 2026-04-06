package dev.tonimatas.mixin.minecraft.advancements;

import dev.tonimatas.bridge.minecraft.advancements.AdvancementHolderBridge;
import net.minecraft.advancements.AdvancementHolder;
import org.bukkit.craftbukkit.advancement.CraftAdvancement;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(AdvancementHolder.class)
public class AdvancementHolderMixin implements AdvancementHolderBridge {
    @Override
    @Unique
    public final org.bukkit.advancement.Advancement toBukkit() {
        return new CraftAdvancement((AdvancementHolder) (Object) this);
    }
}
