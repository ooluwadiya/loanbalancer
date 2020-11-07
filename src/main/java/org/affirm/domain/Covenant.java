package org.affirm.domain;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Covenant {
    @CsvBindByName(column = "facility_id")
    private int facilityId;

    @CsvBindByName(column = "max_default_likelihood")
    private double maxDefaultLikelihood;

    @CsvBindByName(column = "bank_id")
    private int bankId;

    @CsvBindByName(column = "banned_state")
    private String bannedState;
}
