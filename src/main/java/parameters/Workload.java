package parameters;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Workload {

    EXTREMELY   (   1.6),
    HIGH        (   1.4),
    PRE_HIGH    (   1.2),
    OTHER       (   1.0);

    @Getter
    private final Double workloadCost;

}
