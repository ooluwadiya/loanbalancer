package org.affirm;

import org.affirm.utils.BankHandler;
import org.affirm.utils.CovenantsHandler;
import org.affirm.utils.FacilitiesHandler;
import org.affirm.utils.LoansHandler;

public class LoanBalancer {

    public static void main(String[] args){
        BankHandler bankHandler = new BankHandler("small");
        CovenantsHandler covenantsHandler = new CovenantsHandler("small");
        FacilitiesHandler facilitiesHandler = new FacilitiesHandler("small");
        LoansHandler loansHandler = new LoansHandler("small");

        bankHandler.getBanks().stream().forEach(System.out::println);
        covenantsHandler.getCovenants().stream().forEach(System.out::println);
        facilitiesHandler.getFacilities().stream().forEach(System.out::println);
        loansHandler.getLoans().stream().forEach(System.out::println);
    }
}