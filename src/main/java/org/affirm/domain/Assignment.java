package org.affirm.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Assignment {
    private int loanId;
    private int facilityId;
}
