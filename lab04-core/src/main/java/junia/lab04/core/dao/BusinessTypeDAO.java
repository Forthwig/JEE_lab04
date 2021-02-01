package junia.lab04.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import junia.lab04.core.entity.BusinessType;

public interface BusinessTypeDAO extends JpaRepository<BusinessType, Long> {

}
