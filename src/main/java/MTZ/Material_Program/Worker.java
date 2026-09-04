package MTZ.Material_Program;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity 
@Table(name = "workers")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String employeeId;

    public Worker() {

    }

    public Worker(String name, String employeeId){
        this.name = name;
        this.employeeId = employeeId;
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

    public String getEmployeeId(){
        return employeeId;
    }

    public void setEmployeeId(String employeeId){
        this.employeeId = employeeId;
    }


    
}
