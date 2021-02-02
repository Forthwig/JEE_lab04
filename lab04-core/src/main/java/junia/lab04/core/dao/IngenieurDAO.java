package junia.lab04.core.dao;

import junia.lab04.core.entity.Ingenieur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IngenieurDAO extends JpaRepository<Ingenieur,Long> {

    @Query("SELECT i FROM Ingenieur i where i.login = :login and i.password =:password")
    List<Ingenieur> findIngenieurBy(@Param("login") String login, @Param("password") String password);

}
