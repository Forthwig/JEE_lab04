package junia.lab04.core.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import junia.lab04.core.dao.CustomerDAO;
import junia.lab04.core.entity.Customer;

@Service
@Transactional
public class CustomerService {

    private CustomerDAO customerDAO;


    public CustomerService(final CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }


    public void deleteAll() {
       customerDAO.deleteAll();
    }


    public void save(Customer customer) {
        customerDAO.save(customer);
    }


    public long countAll() {
       return customerDAO.count();
    }
}
