package junia.lab04.core.dao;

import junia.lab04.core.entity.Ingenieur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngenieurDAO extends JpaRepository<Ingenieur,Long> {

    @Query("SELECT i FROM Ingenieur i WHERE i.login =: login" )
    Ingenieur findByLogin(@Param("login") String login);

}
