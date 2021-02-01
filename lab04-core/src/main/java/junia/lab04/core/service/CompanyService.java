package junia.lab04.core.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import junia.lab04.core.dao.CompanyDAO;
import junia.lab04.core.entity.Company;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
@Transactional
public class CompanyService {

    private CompanyDAO companyDAO;


    public CompanyService(final CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    public Company get(int id){return companyDAO.getOne((long) id);}

    public void deleteAll() {
        companyDAO.deleteAll();
    }


    public void save(final Company company) {
        companyDAO.save(company);
    }


    public long countAll() {
        return companyDAO.count();
    }


    public Map<String, Integer> getAllWithProjectCount() {
        Map<String,Integer> projectCount = new TreeMap<>();
        final List<Company> companies = companyDAO.findAllWithProjects();
        for(Company company:companies){
            projectCount.put(company.getName(),company.getProjects().size());
        }
        return projectCount;
    }

    public List<Company> findAllWithProjects(){
        return companyDAO.findAllWithProjects();
    }


    public void deleteById(final long id) {
        companyDAO.deleteById(id);
    }
}
