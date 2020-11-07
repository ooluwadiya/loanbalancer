package org.affirm.domain;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

@Data
@ToString
public class Covenant {
    @CsvBindByName(column = "facility_id")
    private int facilityId;

    @CsvBindByName(column = "max_default_likelihood")
    private float maxDefaultLikelihood;

    @CsvBindByName(column = "bank_id")
    private int bankId;

    @CsvBindByName(column = "banned_state")
    private String bannedState;

    public boolean match(Loan loan) {
        if(this.maxDefaultLikelihood > 0 && loan.getDefaultLikelihood() > this.maxDefaultLikelihood){
            return false;
        }

        if(!StringUtils.isEmpty(this.getBannedState()) && this.getBannedState().equalsIgnoreCase(loan.getState())){
            return false;
        }
        return true;
    }
}
