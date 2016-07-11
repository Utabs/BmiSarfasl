package ir.bmi.repository;

import ir.bmi.entity.PersonTO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by utab on 7/7/2016.
 */
@Repository
public interface PersonDao extends BaseDao<PersonTO> {
 }



