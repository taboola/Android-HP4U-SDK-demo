package com.taboola.hp4udemoapplication

import com.taboola.android.global_components.eventsmanager.events.TBLMobileEvent

class HomePageDemoUsageEvent :TBLMobileEvent {
    constructor(eventType: String?, data: Map<String, String>) : super(eventType, data) {}

}