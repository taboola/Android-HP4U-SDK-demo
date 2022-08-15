package com.taboola.hp4udemoapplication.event

import com.taboola.android.global_components.eventsmanager.events.TBLMobileEvent

class HP4UDemoUsageEvent(eventType: String?, data: Map<String, String>) :
    TBLMobileEvent(eventType, data) {
}