package com.cengiz.javaeticaret.data.mapper;

import com.cengiz.javaeticaret.data.dto.KullaniciRolDto;
import com.cengiz.javaeticaret.data.entity.KullaniciRol;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KullaniciRolMapper {

    KullaniciRolDto toDto(KullaniciRol kullaniciRol);

    KullaniciRol toEntity(KullaniciRolDto kullaniciYetkiDto);

}
