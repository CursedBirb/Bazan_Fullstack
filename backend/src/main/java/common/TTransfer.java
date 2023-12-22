package common;

import controllers.models.Transfer;
import lombok.Data;

@Data //Adnotacja @Data wystarczy aby Lombok wygenerował getery, setery, toString, equals i inne
public class TTransfer {
        
    private int id;
    private String clientname;
    private String date;
    private String description;
    private double amount;

    public TTransfer(int id, String clientname, String date, String description, double amount) {
        this.id = id;
        this.clientname = clientname;
        this.date = date;
        this.description = description;
        this.amount = amount;
    }
    
    public TTransfer(Transfer transfer) {
        this.id = transfer.getId();
        this.clientname = transfer.getClientname();
        this.date = transfer.getDate();
        this.description = transfer.getDescription();
        this.amount = transfer.getAmount();
    }
    
    public TTransfer(String errorText) {
        this.id = -1;
        this.clientname = errorText;
        this.date = "";
        this.description = "";
        this.amount = 0.0;
    }

    public TTransfer() {
        this.id = -1;
        this.clientname = "brak";
        this.date = "brak";
        this.description = "brak";
        this.amount = 0.0;
    }
    
}
