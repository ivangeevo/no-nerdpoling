package org.ivangeevo.no_nerdpoling.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber
public class NeoForgeBlockPlacementListener {

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        var player = event.getEntity();

        if (!player.isCreative()) {
            if (!player.onGround()
                    && !player.isInWater()
                    && !player.onClimbable()
                    && !player.isPassenger()
                    && !player.isInLava())
            {
                event.setCanceled(true);
            }
        }
    }

}