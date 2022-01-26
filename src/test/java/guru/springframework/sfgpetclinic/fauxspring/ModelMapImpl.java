package guru.springframework.sfgpetclinic.fauxspring;

import guru.springframework.sfgpetclinic.services.map.AbstractMapService;

import java.util.HashMap;
import java.util.Map;

public class ModelMapImpl implements Model {
    Map<String, Object> map = new HashMap<>();

    @Override
    public void addAttribute(String key, Object o) {
        map.put(key, o);
    }

    @Override
    public void addAttribute(Object o) {
        //DO NOTHING
    }

    public Map<String, Object> getMap() {
        return map;
    }
}
