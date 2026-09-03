package MTZ.Material_Program;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "materials")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String unit;

    private BigDecimal unitCost;

    private BigDecimal materialRate;

    public Material(){

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

    public String getUnit(){
        return unit;
    }

    public void setUnit(String unit){
        this.unit = unit;
    }

    public BigDecimal getUnitCost(){
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost){
        this.unitCost = unitCost;
    }

    public BigDecimal getMaterialRate(){
        return materialRate;
    }

    public void setMaterialRate(BigDecimal materialRate){
        this.materialRate = materialRate;
    }





    
}
