package net.lunix.flightsync.fabric;

import net.fabricmc.api.ClientModInitializer;

public class FlightSyncFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // Logic handled via mixin — see ClientPacketListenerMixin
    }
}
