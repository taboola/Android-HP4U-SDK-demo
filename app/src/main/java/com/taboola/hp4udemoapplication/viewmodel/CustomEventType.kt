
import com.taboola.android.global_components.eventsmanager.events.TBLMobileEvent


class MyEvent : TBLMobileEvent {
    constructor(data: Map<String, String>?) : super(data) {}
    constructor(eventType: String?, data: Map<String, String>) : super(eventType, data) {}
}