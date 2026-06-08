package org.ivangeevo.no_nerdpoling;

import net.fabricmc.api.ModInitializer;
import org.ivangeevo.no_nerdpoling.event.FabricBlockPlacementListener;

public class NoNerdpolingMod implements ModInitializer {

    @Override
    public void onInitialize() {
        CommonClass.init();
        FabricBlockPlacementListener.register();
    }
}
