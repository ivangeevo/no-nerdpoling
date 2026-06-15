package org.btwr.no_nerdpoling;

import net.fabricmc.api.ModInitializer;
import org.btwr.no_nerdpoling.event.FabricBlockPlacementListener;

public class NoNerdpolingMod implements ModInitializer {

    @Override
    public void onInitialize() {
        CommonClass.init();
        FabricBlockPlacementListener.initialize();
    }

}