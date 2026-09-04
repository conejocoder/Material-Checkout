package MTZ.Material_Program.repository;

import MTZ.Material_Program.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long>{
    
}
