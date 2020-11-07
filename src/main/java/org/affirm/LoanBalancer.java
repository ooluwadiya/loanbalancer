package org.affirm;

import org.affirm.domain.Assignment;
import org.affirm.domain.Yield;
import org.affirm.utils.AssignmentHandler;
import org.affirm.utils.FacilitiesHandler;
import org.affirm.utils.LoansHandler;
import org.affirm.utils.YieldHandler;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LoanBalancer {

    public static void main(String[] args){
        String fileSize = "small";
        FacilitiesHandler facilitiesHandler = new FacilitiesHandler(fileSize);
        LoansHandler loansHandler = new LoansHandler(fileSize);


        List<Assignment> assignments = loansHandler.getLoans().stream().map(loan -> facilitiesHandler.findFacility(loan)).collect(Collectors.toList());
        AssignmentHandler.writeAssignment(assignments);
        System.out.println("Assignments written to /tmp/assignments.csv");

        Map<Integer, List<Assignment>> facilityAssignmentMap = assignments.stream().collect(Collectors.groupingBy(Assignment::getFacilityId));
        List<Yield> yields = facilityAssignmentMap.entrySet().stream().map(facility -> {
            BigDecimal yield = calculateFacilityYield(facility.getValue());
            yield = yield.setScale(0, RoundingMode.UP);
            return Yield.builder().facilityId(facility.getKey()).expectedYield(yield.intValue()).build();
        }).collect(Collectors.toList());
        YieldHandler.writeYields(yields);
        System.out.println("Yields written to /tmp/yields.csv");
    }

    private static BigDecimal calculateFacilityYield(List<Assignment> assignments) {
        BigDecimal totalYield = BigDecimal.ZERO;
        for(Assignment assignment : assignments){
            totalYield = totalYield.add(calculateAssignmentYield(assignment));
        }

        return totalYield;
    }

    private static BigDecimal calculateAssignmentYield(Assignment assignment) {

        return new BigDecimal((1 - assignment.getDefaultLikelihood()) * assignment.getLoanInterestRate()
                * assignment.getAmount().floatValue()
                - (assignment.getDefaultLikelihood() * assignment.getAmount().floatValue())
                - (assignment.getFacilityInterestRate() * assignment.getAmount().floatValue()));
    }
}