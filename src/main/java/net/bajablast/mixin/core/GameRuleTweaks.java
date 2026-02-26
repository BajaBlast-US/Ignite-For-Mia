package net.bajablast.mixin.core;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.storage.PrimaryLevelData;
import org.bukkit.plugin.java.JavaPlugin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(GameRules.class)
public class GameRuleTweaks extends JavaPlugin {

  @Inject(method = "<init>*", at = @At("TAIL"))
  private void forceKeepInventory(CallbackInfo ci) {
    ServerLevel level = (ServerLevel) (Object) this;

    GameRules rules =
      ((PrimaryLevelData) level.getLevelData())
        .getGameRules();

    rules.getRule(GameRules.RULE_KEEPINVENTORY)
      .set(true, level);
  }
}

