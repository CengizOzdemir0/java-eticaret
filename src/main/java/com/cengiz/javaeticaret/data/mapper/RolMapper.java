package com.cengiz.javaeticaret.data.mapper;


import com.cengiz.javaeticaret.data.dto.RolDto;
import com.cengiz.javaeticaret.data.entity.Rol;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolMapper {


    RolDto toDto(Rol rol);

    Rol toEntity(RolDto rolDto);


}
