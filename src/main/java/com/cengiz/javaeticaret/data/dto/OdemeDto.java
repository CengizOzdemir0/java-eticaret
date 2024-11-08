package com.cengiz.javaeticaret.data.dto;


import com.cengiz.javaeticaret.data.entity.Siparis;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OdemeDto {


    private Integer id;
    private Siparis siparis;
    private Double odemeTutari;
    private String odemeDurumu;

}
