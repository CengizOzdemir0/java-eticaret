package com.cengiz.javaeticaret.data.mapper;


import com.cengiz.javaeticaret.data.dto.RolYetkiDto;
import com.cengiz.javaeticaret.data.entity.RolYetki;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolYetkiMapper {


    RolYetkiDto toDto(RolYetki rolYetki);

    RolYetki toEntity(RolYetkiDto rolYetkiDto);


}
