package com.cengiz.javaeticaret.controller;


import com.cengiz.javaeticaret.data.dto.*;
import com.cengiz.javaeticaret.data.entity.Yetki;
import com.cengiz.javaeticaret.exceptions.CustomResponse;
import com.cengiz.javaeticaret.security.AuthenticationService;
import com.cengiz.javaeticaret.security.JwtService;
import com.cengiz.javaeticaret.service.KullaniciRolService;
import com.cengiz.javaeticaret.service.KullaniciService;
import com.cengiz.javaeticaret.service.YetkiService;
import com.cengiz.javaeticaret.RedisConfig.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-11-08 15:03
 */

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    private final RedisService redisService;

    private final KullaniciRolService kullaniciRolService;
    private final KullaniciService kullaniciService;
    private final YetkiService yetkiService;


    @PostMapping("/signup")
    public CustomResponse<KullaniciDto> register(@RequestBody KullaniciDto kullaniciDto) {
        KullaniciDto registeredKullanici = authenticationService.signup(kullaniciDto);
        return new CustomResponse<>("Kullanıcı başarıyla oluşturuldu.", "SCSS_200", registeredKullanici);
    }

    @PostMapping("/login")
    public CustomResponse<LoginResponse> authenticate(@RequestBody LoginKullaniciDto loginKullaniciDto) {
        // TODO mail pass kontrol edilecek
        KullaniciDto kullaniciByEmail = kullaniciService.getKullaniciByEmail(loginKullaniciDto.getEmail());
        List<Yetki> allYetkiListWFkKullaniciId = yetkiService.findAllYetkiListWFkKullaniciId(kullaniciByEmail.getId());
         if(allYetkiListWFkKullaniciId.isEmpty()) {
            throw new RuntimeException("Kullaninin Yetki tanimlamasi yoktur !");
        }

        KullaniciDto authenticatedUser = authenticationService.authenticate(loginKullaniciDto);
        TokenDto tokenDto = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(tokenDto.getToken());
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        RedisKullaniciDto redisKullaniciDto =  new RedisKullaniciDto();
        redisKullaniciDto.setKullaniciDto(authenticatedUser);
        redisKullaniciDto.setSubUuid(tokenDto.getSubUuid());


        List<KullaniciYetkiG> list = new ArrayList<>();
        allYetkiListWFkKullaniciId.forEach(yetki -> list.add(new KullaniciYetkiG(yetki.getAdi())));
        //list.add(new KullaniciYetkiG("USER"));
        //list.add(new KullaniciYetkiG("ADMIN"));

        redisKullaniciDto.setYetkiList(list);

        redisService.saveValue(tokenDto.getUuid(), redisKullaniciDto);
        return new CustomResponse<>("Kullanıcı login işlemi başarıyla yapıldı.","LGN_200",loginResponse);
    }

}

