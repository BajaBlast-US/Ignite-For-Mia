package net.bajablast.mixin.core;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HayBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(HayBlock.class)
public abstract class HayBlockMixin {

  /**
   * @author Baja
   * @reason Remove fall-damage reduction from hay bales
   */
  @Overwrite
  public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, double fallDistance) {
    // Apply normal fall damage (no reduction)
    entity.causeFallDamage(fallDistance, 1.0F, level.damageSources().fall());
  }
}
