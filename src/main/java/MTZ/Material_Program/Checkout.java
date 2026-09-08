
package MTZ.Material_Program;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Checkout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long workerId;
    private Long jobId;
    private Long materialId;
    private BigDecimal quantity;
    private BigDecimal usedQuantity = BigDecimal.ZERO;
    private BigDecimal returnedQuantity = BigDecimal.ZERO;
    private Instant issuedAt;
}