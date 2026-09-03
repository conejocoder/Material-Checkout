package MTZ.Material_Program.repository;

import MTZ.Material_Program.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {
    
}
