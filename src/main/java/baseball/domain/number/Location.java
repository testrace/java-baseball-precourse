package baseball.domain.number;

import java.util.HashMap;
import java.util.Map;

public enum Location {

    FIRST(1),
    SECOND(2),
    THIRD(3);

    private static final Map<Integer, Location> LOCATION_CACHE = new HashMap<>();

    static {
        for (Location location : values()) {
            LOCATION_CACHE.put(location.value, location);
        }
    }

    private final int value;

    Location(int value) {
        this.value = value;
    }

    public static Location from(int value) {
        if (LOCATION_CACHE.containsKey(value)) {
            return LOCATION_CACHE.get(value);
        }

        throw new IllegalArgumentException("위치는 1, 2, 3 중 하나만 가능합니다. 현재 위치 값: " + value);
    }
}
