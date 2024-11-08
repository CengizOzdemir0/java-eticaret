package com.cengiz.javaeticaret.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-11-08 15:03
 */

@Getter
@Setter
public class RedisKullaniciDto implements Serializable {

    private KullaniciDto kullaniciDto;

    private String subUuid;

    private List<KullaniciYetkiG> yetkiList;
}
