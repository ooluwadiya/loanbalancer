package org.affirm.utils;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.affirm.domain.Facility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Data
@AllArgsConstructor
public class FacilitiesHandler {
    private List<Facility> facilities;

    public FacilitiesHandler(String fileSize){
        String path = fileSize+"/facilities.csv";
        BufferedReader reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream(path)));
        facilities = new CsvToBeanBuilder<Facility>(reader)
                .withType(Facility.class)
                .build().parse();
    }
}
