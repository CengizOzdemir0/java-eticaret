package com.cengiz.javaeticaret.data.mapper;

import com.cengiz.javaeticaret.data.dto.KullaniciDto;
import com.cengiz.javaeticaret.data.entity.Kullanici;
import org.mapstruct.Mapper;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-11-08 15:03
 */

@Mapper(componentModel = "spring")
public interface KullaniciMapper {

    KullaniciDto toDto(Kullanici kullanici);

    Kullanici toEntity(KullaniciDto kullaniciDto);

}
