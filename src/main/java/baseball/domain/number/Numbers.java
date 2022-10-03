package baseball.domain.number;

import java.util.Collections;
import java.util.Set;

public class Numbers {

    private final Set<LocationNumber> locationNumbers;

    public Numbers(Set<LocationNumber> locationNumbers) {
        validate(locationNumbers);
        this.locationNumbers = locationNumbers;
    }

    private void validate(Set<LocationNumber> locationNumbers) {
        if (locationNumbers == null || locationNumbers.isEmpty()) {
            throw new IllegalArgumentException("빈 값으로 초기화할 수 없습니다.");
        }
    }

    public boolean contains(LocationNumber guessNumber) {
        return locationNumbers.contains(guessNumber);
    }

    public boolean hasSameNumber(LocationNumber guessNumber) {
        boolean hasSameNumber = false;
        for (LocationNumber locationNumber : locationNumbers) {
            hasSameNumber = Boolean.logicalOr(hasSameNumber, locationNumber.matchOnlyNumber(guessNumber));
        }
        return hasSameNumber;
    }

    public Set<LocationNumber> getLocationNumbers() {
        return Collections.unmodifiableSet(locationNumbers);
    }

}
