package org.affirm.domain;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Data
@ToString
public class Facility {
    @CsvBindByName(column = "amount")
    private BigDecimal amount;

    @CsvBindByName(column = "interest_rate")
    private float interestRate;

    @CsvBindByName(column = "id")
    private int id;

    @CsvBindByName(column = "bank_id")
    private int bankId;

    private List<Covenant> covenants;
}
