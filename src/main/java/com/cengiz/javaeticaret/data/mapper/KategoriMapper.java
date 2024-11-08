package com.cengiz.javaeticaret.data.mapper;


import com.cengiz.javaeticaret.data.dto.KategoriDto;
import com.cengiz.javaeticaret.data.entity.Kategori;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KategoriMapper {

    KategoriDto toDto(Kategori kullanici);

    Kategori toEntity(KategoriDto kullaniciDto);

}
