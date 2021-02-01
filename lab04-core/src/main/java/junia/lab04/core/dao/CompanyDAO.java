package junia.lab04.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import junia.lab04.core.entity.Company;

import java.util.List;

public interface CompanyDAO extends JpaRepository<Company, Long> {

    @Query("SELECT DISTINCT c FROM Company c LEFT JOIN FETCH c.projects")
    List<Company> findAllWithProjects();
}
