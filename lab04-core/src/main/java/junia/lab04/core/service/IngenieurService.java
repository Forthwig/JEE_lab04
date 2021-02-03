package junia.lab04.core.service;

import junia.lab04.core.dao.IngenieurDAO;
import junia.lab04.core.entity.Ingenieur;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IngenieurService {

    private IngenieurDAO ingenieurDAO;

    public IngenieurService(IngenieurDAO ingenieurDAO) {
        this.ingenieurDAO = ingenieurDAO;
    }

    public void deleteAll() {
        ingenieurDAO.deleteAll();
    }

    public void save(final Ingenieur ingenieur) {
        ingenieurDAO.save(ingenieur);
    }

    public List<Ingenieur> list() {
        return ingenieurDAO.findAll();
    }

    public long countAll() {
        return ingenieurDAO.count();
    }

    public Boolean contains(Ingenieur ingenieur){return !ingenieurDAO.findIngenieurBy(ingenieur.getLogin(),ingenieur.getPassword()).isEmpty();}


    public Ingenieur findByUsername(String username) {
        return new Ingenieur();
    }
}
