package com.cengiz.javaeticaret.data.mapper;


import com.cengiz.javaeticaret.data.dto.SiparisUrunDto;
import com.cengiz.javaeticaret.data.entity.SiparisUrun;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SiparisUrunMapper {

    SiparisUrunDto toDto(SiparisUrun kullanici);

    SiparisUrun toEntity(SiparisUrunDto kullaniciDto);
    List<SiparisUrun> toEntityList(List<SiparisUrunDto> kullaniciDtoList);
    List<SiparisUrunDto> toDtoList(List<SiparisUrun> kullaniciDtoList);


}
