package parameters;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Fragile {

    YES (   300.0),
    NO (    0.0);

    @Getter
    private final Double fragCost;

}
