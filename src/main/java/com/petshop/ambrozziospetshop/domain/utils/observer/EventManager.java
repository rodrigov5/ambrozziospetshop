package com.petshop.ambrozziospetshop.domain.utils.observer;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private final List<IListener> listeners;

    public EventManager() {
        this.listeners = new ArrayList<>();
    }

    public void addListener(IListener listener) {
        listeners.add(listener);
    }

    public void notifyAll(IEvent event) {
        for (IListener listener : listeners)
            listener.notify(event);
    }
}
