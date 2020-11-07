package org.affirm.domain;

import com.opencsv.bean.CsvBindByName;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@Builder
public class Assignment {
    @CsvBindByName(column = "loan_id")
    private int loanId;

    @CsvBindByName(column = "facility_id")
    private int facilityId;

    private float defaultLikelihood;
    private float loanInterestRate;
    private BigDecimal amount;
    private float facilityInterestRate;
}
