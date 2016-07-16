package ir.bmi.entity;

import javax.persistence.*;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;

/**
 * Created by utab on 7/7/2016.
 */
@Entity(name = "PERSON")
@Table(name = "PERSON")
public class PersonTO implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Basic
    @Column(name = "NAME")
    private String name;
    @Basic
    @Column(name="FAMILY")
    private String family;

    public PersonTO(int i, String name, String family) {
        System.out.println("To....");
        this.name = name;
        this.family = family;
    }

    public PersonTO() {
        System.out.println("personTo....");
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}
