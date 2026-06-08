package org.ivangeevo.no_nerdpoling;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.ivangeevo.no_nerdpoling.event.NeoForgeBlockPlacementListener;

@Mod(Constants.MOD_ID)
public class NoNerdpolingMod {

    public NoNerdpolingMod(IEventBus eventBus) {
        CommonClass.init();
    }
}
