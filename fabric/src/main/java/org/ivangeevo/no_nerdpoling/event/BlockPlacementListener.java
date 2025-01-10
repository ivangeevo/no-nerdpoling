package org.ivangeevo.no_nerdpoling.event;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;

public class BlockPlacementListener {

    public static void register() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            // Check if the player is in creative mode
            if (!player.isCreative()) {

                // TODO: Implement condition to disallow placement if the player is sliding down ladders without holding shift.
                // Prevent block placement if the player is not on the ground, is swimming, or using a ladder
                if ((!player.onGround() && !player.isInWater()) || player.isSwimming() /**|| (isPlayerSlidingOnLadder(player, hitResult.getBlockPos(), world) && !player.isSuppressingSlidingDownLadder())**/) {
                    return InteractionResult.FAIL;
                }
            }

            return InteractionResult.PASS;
        });
    }

    /**
    private static boolean isPlayerSlidingOnLadder(Player player, BlockPos blockPos, World world) {
        // Check if the block the player interacts with is a ladder and they are sliding
        BlockState blockState = world.getBlockState(blockPos);
        return blockState.isLadder(world, blockPos, player) && player.isFallFlying();
    }
    **/
}
