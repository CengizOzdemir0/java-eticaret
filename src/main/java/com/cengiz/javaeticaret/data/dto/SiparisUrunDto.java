package com.cengiz.javaeticaret.data.dto;


import com.cengiz.javaeticaret.data.entity.Siparis;
import com.cengiz.javaeticaret.data.entity.Urun;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SiparisUrunDto {


    private Siparis siparis;

    private Urun urun;

    private Integer miktar;
}
