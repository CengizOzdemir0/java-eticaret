package com.cengiz.javaeticaret.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class RolDto  implements Serializable {

    private Integer id;
    private String adi;
    private String aciklama;
}
