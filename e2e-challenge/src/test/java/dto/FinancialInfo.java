package dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class FinancialInfo {

    private ArrayList<Transaction> transactions;
    private String totalBalance;
    private String creditAvailable;

}
