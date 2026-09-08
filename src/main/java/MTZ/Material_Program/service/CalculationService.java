package MTZ.Material_Program.service;

import MTZ.Material_Program.dto.CalculationRequest;
import MTZ.Material_Program.dto.CalculationResult;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculationService {

    public CalculationResult calculate (CalculationRequest request){

        BigDecimal approvedQuantity = 
                    request.squareFootage()
                    .multiply(request.materialRate());

        BigDecimal unaccountedQuantity = 
                    request.issuedQuantity()
                    .subtract(request.usedQuantity())
                    .subtract(request.returnedQuantity());

        BigDecimal excessQuantity = 
                    request.issuedQuantity()
                    .subtract(approvedQuantity);

        BigDecimal estimatedLoss = 
                    unaccountedQuantity.multiply(request.unitCost());

        return new CalculationResult(
            approvedQuantity,
            request.issuedQuantity(),
            request.usedQuantity(),
            request.returnedQuantity(),
            unaccountedQuantity,
            excessQuantity,
            estimatedLoss
        );
    } 
}
