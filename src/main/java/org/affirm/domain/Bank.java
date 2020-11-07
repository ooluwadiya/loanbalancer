package org.affirm.domain;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Bank {
    @CsvBindByName(column = "id")
    private int id;

    @CsvBindByName(column = "name")
    private String name;
}
