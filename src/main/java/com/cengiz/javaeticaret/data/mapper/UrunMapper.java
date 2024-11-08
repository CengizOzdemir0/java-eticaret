package com.cengiz.javaeticaret.data.mapper;


import com.cengiz.javaeticaret.data.dto.UrunDto;
import com.cengiz.javaeticaret.data.entity.Urun;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UrunMapper {

    UrunDto toDto(Urun kullanici);

    Urun toEntity(UrunDto kullaniciDto);

    List<UrunDto> toDtoList(List<Urun> kullaniciList);

    List<Urun> toEntityList(List<UrunDto> kullaniciDtoList);


}
