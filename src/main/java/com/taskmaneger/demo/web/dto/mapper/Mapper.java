package com.taskmaneger.demo.web.dto.mapper;

public interface Mapper<D, M> {
    D modelToDto(M model);

    M DtoToModel(D dto);
}
