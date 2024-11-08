package com.cengiz.javaeticaret.data.mapper;


import com.cengiz.javaeticaret.data.dto.SiparisDto;
import com.cengiz.javaeticaret.data.entity.Siparis;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SiparisMapper {


    SiparisDto toDto(Siparis kullanici);

    Siparis toEntity(SiparisDto kullaniciDto);


}


