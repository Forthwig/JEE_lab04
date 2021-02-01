package junia.lab04.core.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Project extends GenericEntity {

    private String name;

    @ManyToOne
    private Company company;

    @ManyToOne
    private Customer customer;


    public Project() {
    }


    public String getName() {
        return name;
    }


    public void setName(final String nameValue) {
        name = nameValue;
    }


    public Company getCompany() {
        return company;
    }


    public void setCompany(final Company companyValue) {
        company = companyValue;
    }


    public Customer getCustomer() {
        return customer;
    }


    public void setCustomer(final Customer customerValue) {
        customer = customerValue;
    }
}
