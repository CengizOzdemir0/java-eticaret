package com.cengiz.javaeticaret.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-11-08 15:03
 */

@Getter
@AllArgsConstructor
public class TokenDto {

    private String token;

    private String uuid;

    private String subUuid;
}
