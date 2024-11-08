package com.cengiz.javaeticaret.data.mapper;


import com.cengiz.javaeticaret.data.dto.OdemeDto;
import com.cengiz.javaeticaret.data.entity.Odeme;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OdemeMapper {

    OdemeDto toDto(Odeme kullanici);

    Odeme toEntity(OdemeDto kullaniciDto);


}
