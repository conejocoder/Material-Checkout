package MTZ.Material_Program.dto;

import java.math.BigDecimal;

public record CalculationResult(

    BigDecimal approvedQuantity,
    BigDecimal issuedQuantity,
    BigDecimal usedQuantity,
    BigDecimal returnedQuantity,
    BigDecimal unaccountedQuantity,
    BigDecimal excessQuantity,
    BigDecimal estimatedLoss
) {
}
