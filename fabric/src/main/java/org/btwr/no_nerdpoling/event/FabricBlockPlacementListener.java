package org.btwr.no_nerdpoling.event;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.world.InteractionResult;

public class FabricBlockPlacementListener {

    public static void initialize() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (!player.isCreative()) {
                if (!player.onGround()
                        && !player.isInWater()
                        && !player.onClimbable()
                        && !player.isPassenger()
                        && !player.isInLava())
                {
                    return InteractionResult.FAIL;
                }
            }

            return InteractionResult.PASS;
        });
    }

}