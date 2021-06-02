package pe.cibertec.dawi.common;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractConverter<E, D> implements Converter<E, D> {

    @Override
    public D toDto(E entity) throws Exception {
        return entityToDto(entity);
    }

    @Override
    public E toEntity(D dto) throws Exception {
        return dtoToEntity(dto);
    }

    @Override
    public List<E> toListEntity(List<D> dtos) throws Exception {

        List<E> entities = new ArrayList<>();

        for (D dto : dtos) {
            E entity = dtoToEntity(dto);
            entities.add(entity);
        }
        return entities;
    }

    @Override
    public List<D> toListDto(List<E> entities) throws Exception {

        List<D> dtos = new ArrayList<>();

        for (E entity : entities) {
            D dto = entityToDto(entity);
            dtos.add(dto);
        }
        return dtos;
    }

    protected abstract D entityToDto(E entity) throws Exception;

    protected abstract E dtoToEntity(D dto) throws Exception;

}
