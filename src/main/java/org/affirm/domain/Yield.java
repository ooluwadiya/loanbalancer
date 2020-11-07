package org.affirm.domain;

import com.opencsv.bean.CsvBindByName;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Yield {
    @CsvBindByName(column = "facility_id")
    private int facilityId;

    @CsvBindByName(column = "expected_yield")
    private int expectedYield;
}
