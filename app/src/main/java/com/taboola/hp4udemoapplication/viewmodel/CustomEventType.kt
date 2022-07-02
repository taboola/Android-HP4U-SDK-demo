
import com.taboola.android.global_components.eventsmanager.TBLEventType
import com.taboola.android.global_components.eventsmanager.events.TBLMobileEvent

//Try to extend TBLEventType interface and add there my type as custom type,

class HomePageDemoUsedEvent : TBLMobileEvent {
    constructor(eventType: String?, data: Map<String, String>) : super(eventType, data) {}
}