package com.cengiz.javaeticaret.data.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-11-08 15:03
 */

@Getter
@Setter
public class LoginKullaniciDto implements Serializable {

    private String email;

    private String password;
}
