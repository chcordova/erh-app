package pe.cibertec.dawi.service;

import java.util.List;

public interface CRUDService<T> {

    List<T> listAll();

    T getById(Long id);

    T saveOrUpdate(T entity);

    void delete(Long id);

}
