package org.affirm;

import org.affirm.utils.FacilitiesHandler;
import org.affirm.utils.LoansHandler;

public class LoanBalancer {

    public static void main(String[] args){
        String fileSize = "small";
        FacilitiesHandler facilitiesHandler = new FacilitiesHandler(fileSize);
        LoansHandler loansHandler = new LoansHandler(fileSize);


        loansHandler.getLoans().stream().map(loan -> facilitiesHandler.findFacility(loan)).forEach(System.out::println);
    }
}