package MTZ.Material_Program.repository;

import MTZ.Material_Program.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CheckoutRepository extends JpaRepository<Checkout, Long> {

    List<Checkout> findByWorkerId(Long workerId);
    List<Checkout> findByJobId(Long jobId);
    List<Checkout> findByWorkerAndJobId(Long workerId, Long jobId);
}
