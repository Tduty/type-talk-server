package info.tduty.typetalkserver.data.serializer;

import com.google.gson.*;
import info.tduty.typetalkserver.data.event.Event;
import info.tduty.typetalkserver.data.event.EventPayload;
import info.tduty.typetalkserver.data.event.payload.*;

import java.lang.reflect.Type;

public class EventDeserializer implements JsonDeserializer<Event> {

    private Gson gson;

    public EventDeserializer(Gson gson) {
        this.gson = gson;
    }

    @Override
    public Event deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String payloadType = json.getAsJsonObject().get("type").getAsString();
        JsonElement jsonElement = json.getAsJsonObject().get("eventPayload");

        EventPayload payload;

        switch (EventPayload.Type.to(payloadType)) {
            case MESSAGE_NEW:
                payload = gson.fromJson(jsonElement, MessageNewPayload.class);
                break;
            case LESSON:
                payload = gson.fromJson(jsonElement, LessonPayload.class);
                break;
            case TYPING:
                payload = gson.fromJson(jsonElement, TypingPayload.class);
                break;
            case CORRECTION:
                payload = gson.fromJson(jsonElement, CorrectionPayload.class);
                break;
            case TASK:
                payload = gson.fromJson(jsonElement, TaskPayload.class);
                break;
            case LESSON_PROGRESS:
                payload = gson.fromJson(jsonElement, LessonProgressPayload.class);
                break;
            default:
                payload = null;
                break;
        }

        return new Event(payloadType, payload);
    }
}
