package org.ivangeevo.no_nerdpoling;

import net.fabricmc.api.ModInitializer;
import org.ivangeevo.no_nerdpoling.event.BlockPlacementListener;

public class NoNerdpolingMod implements ModInitializer
{

    @Override
    public void onInitialize() {

        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        // Use Fabric to bootstrap the Common mod.
        Constants.LOG.info("Hello Fabric world!");
        CommonClass.init();

        BlockPlacementListener.register();
    }
}
