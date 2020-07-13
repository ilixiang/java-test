package guava;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EventBusTest {
    @Test
    public void simpleFunctionTest() {

        EventBus eventBus = new EventBus();
        EventListener listener = new EventListener();
        CustomEventListener customEventListener = new CustomEventListener();

        eventBus.register(listener);
        eventBus.register(listener);
        eventBus.register(customEventListener);

        eventBus.post("String Event");
        eventBus.post(new CustomEvent("Custom Event"));
        assertThat(listener.getEventHandled()).isEqualTo(1);
        assertThat(customEventListener.getEventHandled()).isEqualTo(2);

    }

    public static class EventListener {

        private int eventHandled;

        @Subscribe
        public void stringEvent(String event) {
            eventHandled++;
        }

        public int getEventHandled() {
            return eventHandled;
        }
    }

    public static class CustomEvent {
        private String action;

        public CustomEvent(String action) {
            this.action = action;
        }

        public String getAction() {
            return action;
        }
    }

    public static class CustomEventListener {
        private int eventHandled;

        @Subscribe
        public void handle(CustomEvent event) {
            ++eventHandled;
        }

        @Subscribe
        public void handString(String event) {
            ++eventHandled;
        }

        public int getEventHandled() {
            return eventHandled;
        }
    }
}
