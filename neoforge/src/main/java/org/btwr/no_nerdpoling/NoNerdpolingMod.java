package org.btwr.no_nerdpoling;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class NoNerdpolingMod {
    public NoNerdpolingMod(IEventBus eventBus) {
        CommonClass.init();
    }
}