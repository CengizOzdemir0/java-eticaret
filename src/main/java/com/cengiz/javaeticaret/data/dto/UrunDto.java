package com.cengiz.javaeticaret.data.dto;

import com.cengiz.javaeticaret.data.entity.Kategori;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrunDto {

    private Integer id;
    private String isim;
    private String aciklama;
    private Double fiyat;
    private Integer stokMiktari;
    private Kategori kategori;
}
