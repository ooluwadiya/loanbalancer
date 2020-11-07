package org.affirm.utils;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.affirm.domain.Covenant;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Data
@AllArgsConstructor
public class CovenantsHandler {
    private List<Covenant> covenants;

    public CovenantsHandler(String fileSize){
        String path = fileSize+"/covenants.csv";
        BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(path)));
        covenants = new CsvToBeanBuilder<Covenant>(reader)
                .withType(Covenant.class)
                .build().parse();
    }
}
