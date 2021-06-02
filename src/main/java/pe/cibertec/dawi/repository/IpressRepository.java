package pe.cibertec.dawi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.dawi.model.entity.IpressEntity;

@Repository
public interface IpressRepository extends CrudRepository<IpressEntity, Long> { }
