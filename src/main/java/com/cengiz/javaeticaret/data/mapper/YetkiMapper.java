package com.cengiz.javaeticaret.data.mapper;

import com.cengiz.javaeticaret.data.dto.YetkiDto;
import com.cengiz.javaeticaret.data.entity.Yetki;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface YetkiMapper {


    YetkiDto toDto(Yetki yetki);

    Yetki toEntity(YetkiDto yetkiDto);
}
