package parameters;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Distance {

    MORE_THAN_THIRTY    (  300.0),
    LESS_THAN_THIRTY    (  200.0),
    LESS_THAN_TEN       (  100.0),
    LESS_THAN_TWO       (  50.0);

    @Getter
    private final Double distCost;

}
