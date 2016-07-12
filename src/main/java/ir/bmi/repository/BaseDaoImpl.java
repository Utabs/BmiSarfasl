package ir.bmi.repository;



import ir.bmi.entity.PersonTO;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by utab on 7/8/2016.
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
    private Class<T> type;
    @PersistenceContext
    private EntityManager entityManager;


    public BaseDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    @Transactional
     public T create(final T t) {

      //  entityManager.getTransaction().begin();
        System.out.println("In BaseDaoImpl ...");
        PersonTO personTO= (PersonTO) t;
        System.out.println(((PersonTO) t).getFamily());
        entityManager.persist(t);
//        entityManager.getTransaction().commit();
  //      entityManager.close();
        System.out.println("In BaseDaoImpl after ...");
        return t;
    }

    @Override
    public T update(T t) {
        return null;
    }

    @Override
    public int delete(Long id) {
        return Integer.parseInt(null);
    }

    @Override
    public T find(Long id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }
}
