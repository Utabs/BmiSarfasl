package ir.bmi.service;

import ir.bmi.entity.PersonTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by utab on 7/7/2016.
 */
@Service
public interface PersonService {
    public PersonTO inserted(PersonTO personTO)throws Exception;
    public List<PersonTO> select()throws Exception;
    public PersonTO find(Long Id)throws Exception;
}
