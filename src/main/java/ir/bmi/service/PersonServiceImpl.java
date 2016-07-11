package ir.bmi.service;

import ir.bmi.entity.PersonTO;
import ir.bmi.repository.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by utab on 7/7/2016.
 */

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;


    @Override
    public PersonTO create(PersonTO personTO) throws Exception {
        System.out.println("in service..");
        return personDao.create(personTO);
    }

    @Override
    public List<PersonTO> select() throws Exception {
        return null;
    }


    @Override
    public PersonTO find(Long Id) {
        return null;
    }
}
