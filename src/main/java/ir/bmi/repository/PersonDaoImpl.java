package ir.bmi.repository;

import ir.bmi.entity.PersonTO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by utab on 7/7/2016.
 */
@Repository

public class PersonDaoImpl extends BaseDaoImpl<PersonTO> implements PersonDao {


    @Override
    @Transactional
    public PersonTO create(PersonTO personTO) {
        System.out.println("In personDaoImpl ..");
        return super.create(personTO);
    }

    @Override
    public PersonTO update(PersonTO personTO) {
        return null;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public PersonTO find(Long id) {
        return null;
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public List<PersonTO> findAll() {

        return null;
    }

    //@Override
//    public List<PersonTO> createPerson() {
//        System.out.println("In Dao .. ");
//        PersonTO personTO = new PersonTO();
//        personTO.setFamily("refiee");
//        personTO.setName("amin");
//        System.out.println("Created Repository!");
//        return personTO;
//
//      return   entityManager.createQuery("SELECT i FROM Person i").getResultList();
//    }

}
