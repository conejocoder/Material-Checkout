package MTZ.Material_Program;

import jakarta.persistence.*;

@Entity
@Table(name = "Trade")
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Column(nullable = false, unique = true)
     private String name;
     private String description;

     public Trade(){

     }

     public Long getId(){
        return id;
     }

     public String getName(){
        return name;
     }

     public void setName(String name){
        this.name = name;
     }

     public String getDescription(){
        return description;
     }

     public void setDescription(String description){
        this.description = description;
     }

    



    
}
