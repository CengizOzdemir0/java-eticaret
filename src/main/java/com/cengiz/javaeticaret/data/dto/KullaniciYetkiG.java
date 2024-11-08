package com.cengiz.javaeticaret.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-11-08 15:03
 */

public class KullaniciYetkiG implements GrantedAuthority {

    private String yetki;

    public KullaniciYetkiG() {
    }

    public KullaniciYetkiG(String yetki) {
        this.yetki = yetki;
    }

    @Override
    @JsonIgnore
    public String getAuthority() {
        return this.yetki;
    }

    public String getYetki() {
        return yetki;
    }

    public void setYetki(String yetki) {
        this.yetki = yetki;
    }
}
