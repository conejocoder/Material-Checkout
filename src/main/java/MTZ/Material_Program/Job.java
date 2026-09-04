package MTZ.Material_Program;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobNumber;
    private String name;
    private String address;
    private Double squareFootage;

    
    public Job(){

    }



    public Long getId(){
        return id;
    }

    public String getJobNumber(){
        return jobNumber;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public Double getSquareFootage(){
        return squareFootage;
    }


    

    public void setJobNumber(String jobNumber){
        this.jobNumber = jobNumber;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setSquareFootage(double squareFootage){
        this.squareFootage = squareFootage;
    }

}
