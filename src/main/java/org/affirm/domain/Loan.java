package org.affirm.domain;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Loan {
    @CsvBindByName(column = "interest_rate")
    private double interestRate;

    @CsvBindByName(column = "amount")
    private Integer amount;

    @CsvBindByName(column = "id")
    private int id;

    @CsvBindByName(column = "default_likelihood")
    private double defaultLikelihood;

    @CsvBindByName(column = "state")
    private String state;
}
