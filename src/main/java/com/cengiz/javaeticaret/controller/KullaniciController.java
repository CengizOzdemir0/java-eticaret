package com.cengiz.javaeticaret.controller;

import com.cengiz.javaeticaret.data.dto.KullaniciDto;
import com.cengiz.javaeticaret.data.entity.Kullanici;
import com.cengiz.javaeticaret.exceptions.CustomResponse;
import com.cengiz.javaeticaret.service.KullaniciService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-11-08 15:03
 */

@RestController
@RequestMapping("/kullanici")
@RequiredArgsConstructor
public class KullaniciController {

    private final KullaniciService kullaniciService;

    @GetMapping()
    @PreAuthorize("hasAuthority('SORGU')")
    public CustomResponse<List<Kullanici>> allUsers() {
        List<Kullanici> users = kullaniciService.allUsers();
        return new CustomResponse<>("Kullanıcı listesi başarıyla çekildi.","SPR_201",users);
    }


    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ISLEM')")
    public CustomResponse<KullaniciDto> save(@RequestBody KullaniciDto kullanici) {
        KullaniciDto user = kullaniciService.createKullanici(kullanici);
        return new CustomResponse<>("Kullanıcı listesi başarıyla kaydedildi.","SPR_202",user);
    }


}
