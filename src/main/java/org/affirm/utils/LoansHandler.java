package org.affirm.utils;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.affirm.domain.Loan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Data
@AllArgsConstructor
public class LoansHandler {
    private List<Loan> loans;

    public LoansHandler(String fileSize){
        String path = fileSize+"/loans.csv";
        BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(path)));
        loans = new CsvToBeanBuilder<Loan>(reader)
                .withType(Loan.class)
                .build().parse();
    }
}
