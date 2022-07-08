package parameters;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Size {

    BIG (   200.0),
    SMALL ( 100.0);

    @Getter
    private final Double sizeCost;

}
