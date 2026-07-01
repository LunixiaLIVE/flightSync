package net.lunix.flightsync.neoforge;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(value = "flightsync", dist = Dist.CLIENT)
public class FlightSyncNeoForge {

    public FlightSyncNeoForge() {
        // Logic handled via mixin — see ClientPacketListenerMixin
    }
}
