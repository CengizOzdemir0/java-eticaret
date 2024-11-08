package com.cengiz.javaeticaret.data.mapper;


import com.cengiz.javaeticaret.data.dto.OdemeDto;
import com.cengiz.javaeticaret.data.entity.Odeme;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OdemeMapper {

    OdemeDto toDto(Odeme kullanici);

    Odeme toEntity(OdemeDto kullaniciDto);

    List<OdemeDto> toDtoList(List<Odeme> kullaniciList);
    List<Odeme> toEntityList(List<OdemeDto> kullaniciDtoList);


}
