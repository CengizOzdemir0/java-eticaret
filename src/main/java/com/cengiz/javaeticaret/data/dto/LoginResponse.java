package com.cengiz.javaeticaret.data.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-11-08 15:03
 */

@Getter
@Setter
public class LoginResponse {

    private String token;

    private long expiresIn;

}
