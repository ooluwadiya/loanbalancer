package org.affirm.domain;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class Loan {
    @CsvBindByName(column = "interest_rate")
    private float interestRate;

    @CsvBindByName(column = "amount")
    private BigDecimal amount;

    @CsvBindByName(column = "id")
    private int id;

    @CsvBindByName(column = "default_likelihood")
    private float defaultLikelihood;

    @CsvBindByName(column = "state")
    private String state;
}
