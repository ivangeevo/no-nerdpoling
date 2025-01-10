package org.ivangeevo.no_nerdpoling.event;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

public class BlockPlacementListener {

    // Register the event to the Forge Event Bus
    public static void register() {
        NeoForge.EVENT_BUS.register(new BlockPlacementListener());
    }

    @SubscribeEvent
    public void onBlockPlaceAttempt(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        BlockPos blockPos = event.getPos();
        BlockState blockState = player.getCommandSenderWorld().getBlockState(blockPos);

        // Check if the player is in creative mode
        if (!player.isCreative()) {

            // TODO: Implement condition to disallow placement if the player is going down ladders without having pressed shift (to stay still).
            // Prevent block placement if the player is not on the ground, is swimming or is using a ladder
            if ((!player.onGround() && !player.isInWater()) || player.isSwimming() /**|| (isPlayerSlidingOnLadder(player, blockState, blockPos) && !player.isSuppressingSlidingDownLadder())**/) {
                event.setCancellationResult(InteractionResult.FAIL); // Deny the block placement
                event.setCanceled(true); // Cancel the event
            }
        }
    }

    private boolean isPlayerSlidingOnLadder(Player player, BlockState blockState, BlockPos blockPos) {
        // Check if the block at the player's feet is a ladder and if the player is airborne or sliding
        return blockState.isLadder(player.getCommandSenderWorld(), blockPos, player) /**&& player.isFallFlying()**/;
    }
}
