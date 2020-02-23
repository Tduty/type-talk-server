package info.tduty.typetalkserver.data.serializer;

import com.google.gson.*;
import info.tduty.typetalkserver.data.event.Event;
import info.tduty.typetalkserver.data.event.EventPayload;
import info.tduty.typetalkserver.data.event.payload.LessonPayload;
import info.tduty.typetalkserver.data.event.payload.MessageNewPayload;
import info.tduty.typetalkserver.data.event.payload.TypingPayload;

import java.lang.reflect.Type;

public class EventDeserializer implements JsonDeserializer<Event> {

    private Gson gson;

    public EventDeserializer(Gson gson) {
        this.gson = gson;
    }

    @Override
    public Event deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Event event = gson.fromJson(json, Event.class);
        JsonElement jsonElement = json.getAsJsonObject().get("payload");

        EventPayload payload;

        switch (EventPayload.Type.to(event.getType())) {
            case MESSAGE_NEW:
                payload = gson.fromJson(jsonElement, MessageNewPayload.class);
                break;
            case LESSON:
                payload = gson.fromJson(jsonElement, LessonPayload.class);
                break;
            case TYPING:
                payload = gson.fromJson(jsonElement, TypingPayload.class);
                break;
            default:
                payload = null;
                break;
        }

        event.setEventPayload(payload);

        return event;
    }
}