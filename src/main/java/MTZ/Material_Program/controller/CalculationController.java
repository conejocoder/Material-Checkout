package MTZ.Material_Program.controller;

import MTZ.Material_Program.dto.CalculationRequest;
import MTZ.Material_Program.dto.CalculationResult;
import MTZ.Material_Program.service.CalculationService;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/api/calculations")
public class CalculationController {

    private final CalculationService calculationService;

    public CalculationController(CalculationService calculationService){
        this.calculationService = calculationService;
    }

    @PostMapping
    public CalculationResult calculate(@RequestBody CalculationRequest request) {
        
        
        return calculationService.calculate(request);
    }
}
