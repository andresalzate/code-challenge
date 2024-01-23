package dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Transaction {

    private String status;
    private String date;
    private String description;
    private String category;
    private String amount;
}
