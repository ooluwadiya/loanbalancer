package org.affirm.utils;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.affirm.domain.Bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Data
@AllArgsConstructor
public class BankHandler {
    private List<Bank> banks;

    public BankHandler(String fileSize){
        String path = fileSize+"/banks.csv";
        BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(path)));
        banks = new CsvToBeanBuilder<Bank>(reader)
                .withType(Bank.class)
                .build().parse();


    }
}
