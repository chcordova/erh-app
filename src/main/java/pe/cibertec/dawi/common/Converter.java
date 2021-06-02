package pe.cibertec.dawi.common;

import java.util.List;

public interface Converter<E,D> {

    D toDto(E entity) throws Exception;
    E toEntity(D dto) throws Exception;
    List<E> toListEntity(List<D> dtos) throws Exception;
    List<D> toListDto(List<E> entities) throws Exception;

}
