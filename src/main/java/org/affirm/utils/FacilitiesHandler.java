package org.affirm.utils;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.affirm.domain.Assignment;
import org.affirm.domain.Covenant;
import org.affirm.domain.Facility;
import org.affirm.domain.Loan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

        facilities.sort(Comparator.comparing(Facility::getInterestRate));

        loadCovenants(fileSize);
    }

    private void loadCovenants(String fileSize) {
        List<Covenant> covenants = new CovenantsHandler(fileSize).getCovenants();
        facilities.stream().forEach(facility -> {
            facility.setCovenants(covenants.stream().filter(covenant -> covenant.getFacilityId() == facility.getId()).collect(Collectors.toList()));
        });
    }

    public Assignment findFacility(Loan loan) {
        Assignment assignment = Assignment.builder().loanId(loan.getId()).build();
        for(Facility facility : getFacilities()){
            if(facility.getAmount().compareTo(loan.getAmount()) > 0){
                boolean allCovenantsMatched = true;
                for(Covenant covenant : facility.getCovenants()){
                    if(!covenant.match(loan)){
                        allCovenantsMatched = false;
                        break;
                    }
                }

                if(allCovenantsMatched){
                    facility.setAmount(facility.getAmount().subtract(loan.getAmount()));
                    assignment.setFacilityId(facility.getId());
                    assignment.setAmount(loan.getAmount());
                    assignment.setDefaultLikelihood(loan.getDefaultLikelihood());
                    assignment.setLoanInterestRate(loan.getInterestRate());
                    assignment.setFacilityInterestRate(facility.getInterestRate());
                    break;
                }
            }
        }

        return assignment;
    }
}
