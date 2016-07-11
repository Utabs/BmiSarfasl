package ir.bmi.repository;

import java.util.List;

/**
 * Created by utab on 7/8/2016.
 */
public interface BaseDao<T> {

    public T create(T t)throws Exception;

    public T update(T t)throws Exception;

    public int delete(Long id)throws Exception;

    public T find(Long id)throws Exception;

    public List<T> findAll()throws Exception;

}