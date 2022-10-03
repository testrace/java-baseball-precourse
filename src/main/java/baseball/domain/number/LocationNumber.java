package baseball.domain.number;

import java.util.Objects;

public class LocationNumber {

    private final Location location;
    private final Number number;

    public LocationNumber(Location location, Number number) {
        validateEmptyLocation(location);
        validateEmptyNumber(number);
        this.location = location;
        this.number = number;
    }

    private void validateEmptyLocation(Location location) {
        if (location == null) {
            throw new IllegalArgumentException();
        }
    }

    private void validateEmptyNumber(Number number) {
        if (number == null) {
            throw new IllegalArgumentException();
        }
    }

    public boolean matchOnlyNumber(LocationNumber guessNumber) {
        return this.number.equals(guessNumber.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LocationNumber that = (LocationNumber) o;
        boolean b = location == that.location;
        boolean equals = Objects.equals(number, that.number);
        return b && equals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, number);
    }

}
