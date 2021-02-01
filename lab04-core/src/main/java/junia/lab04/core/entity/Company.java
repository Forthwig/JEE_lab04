package junia.lab04.core.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Company extends GenericEntity{


    private String name;

    @OneToMany(mappedBy = "company")
    private List<Project> projects;


    public Company() {
    }





    public String getName() {
        return name;
    }


    public void setName(final String nameValue) {
        name = nameValue;
    }


    public List<Project> getProjects() {
        return projects;
    }


    public void setProjects(final List<Project> projectsValue) {
        projects = projectsValue;
    }


}
