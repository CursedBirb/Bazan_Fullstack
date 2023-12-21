package controllers.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data //Adnotacja @Data wystarczy aby Lombok wygenerował getery, setery, toString, equals i inne 
@Entity
@Table(name = "TRANSFERS")
public class Transfer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    
    @Column(name = "clientname")    
    private String clientname;
    
    @Column(name = "date")
    String date;
    
    @Column(name = "description")    
    private String description;
        
    @Column(name = "amount")    
    private double amount;
            
    
    public Transfer() {       
        this.clientname = "brak";
        this.date = "brak";
        this.description = "brak";
        this.amount = 0.0;
    }

    public Transfer(String clientname,String date,String description,double amount) {
        this.clientname = clientname;
        this.date = date;
        this.description = description;
        this.amount = amount;                
    }

    
}
