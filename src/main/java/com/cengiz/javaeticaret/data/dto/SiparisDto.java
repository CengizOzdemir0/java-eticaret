package com.cengiz.javaeticaret.data.dto;

import com.cengiz.javaeticaret.data.entity.Kullanici;
import com.cengiz.javaeticaret.data.entity.SiparisUrun;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SiparisDto {


    private Integer id;
    private Kullanici kullanici;
    private Double toplamFiyat;
    private String durum;
    private List<SiparisUrun> siparisUrunler;
}
