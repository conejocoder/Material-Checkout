package MTZ.Material_Program.dto;

import java.math.BigDecimal;

public record CalculationRequest(
    BigDecimal squareFootage,
    BigDecimal materialRate,
    BigDecimal issuedQuantity,
    BigDecimal usedQuantity,
    BigDecimal returnedQuantity,
    BigDecimal unitCost
) {
}
