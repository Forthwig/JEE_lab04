package junia.lab04.core.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

@MappedSuperclass
public class GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    public Date creationDate;

    public Date updateDate;


    public long getId() {
        return id;
    }


    @PrePersist
    public void addCreateDate() {
        creationDate = new Date();
    }


    @PreUpdate
    public void addUpdateDate() {
        updateDate = new Date();
    }
}
