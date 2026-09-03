package MTZ.Material_Program.service;


import MTZ.Material_Program.Checkout;
import MTZ.Material_Program.dto.CalculationRequest;
import MTZ.Material_Program.dto.CalculationResult;
import MTZ.Material_Program.repository.CheckoutRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import MTZ.Material_Program.Material;
import MTZ.Material_Program.repository.MaterialRepository;
import java.util.List;
import java.util.Optional;





@Service
public class MaterialService {

    private final CheckoutRepository checkoutRepository;
    private final MaterialRepository materialRepository;

    public MaterialService(CheckoutRepository checkoutRepository, MaterialRepository materialRepository){
        this.checkoutRepository = checkoutRepository;
        this.materialRepository = materialRepository;
    }

    public Checkout saveCheckout(Checkout checkout){
      return this.checkoutRepository.save(checkout);
    }

    public List<Checkout> getCheckoutsByWorker(Long workerId) {
        return checkoutRepository.findByWorkerId(workerId);
    }

    public List<Checkout> getCheckoutsByJob(Long jobId){
        return checkoutRepository.findByJobId(jobId);
    }

    public List<Checkout> getCheckoutsByWorkerAndJob(Long workerId, Long jobId){
        return checkoutRepository.findByWorkerAndJobId(workerId, jobId);
    }
    public List<Checkout> getAllCheckouts() {
        return checkoutRepository.findAll();
    }

    public Material saveMaterial(Material material) {
        return materialRepository.save(material);
    }

    public List<Material> getAllMaterials(){
        return materialRepository.findAll();
    }

    public Optional<Material> getMaterialById(long id) {
        return materialRepository.findById(id);
    }




    public CalculationResult calculate(CalculationRequest request){

        BigDecimal approvedQuantity = request.squareFootage()
            .multiply(request.materialRate())
            .setScale(2, RoundingMode.HALF_UP);


        BigDecimal unaccountedQuantity = request.issuedQuantity()
            .subtract(request.usedQuanity())
            .subtract(request.returnedQuantity())
            .max(BigDecimal.ZERO);

        BigDecimal excessQuantity = request.issuedQuantity()
            .subtract(approvedQuantity)
            .max(BigDecimal.ZERO);

        BigDecimal estimatedLoss = unaccountedQuantity
            .multiply(request.unitCost())
            .setScale(2, RoundingMode.HALF_UP);

        return new CalculationResult(
            approvedQuantity,
            request.issuedQuantity(),
            request.usedQuanity(),
            request.returnedQuantity(),
            unaccountedQuantity,
            excessQuantity,
            estimatedLoss
        );
    }  
}
