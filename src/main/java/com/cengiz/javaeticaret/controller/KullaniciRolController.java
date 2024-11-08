package com.cengiz.javaeticaret.controller;


import com.cengiz.javaeticaret.data.dto.KullaniciRolDto;
import com.cengiz.javaeticaret.data.entity.KullaniciRol;
import com.cengiz.javaeticaret.exceptions.CustomResponse;
import com.cengiz.javaeticaret.service.KullaniciRolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kullanici-rol")
@RequiredArgsConstructor
public class KullaniciRolController {

    private final KullaniciRolService kullaniciYetkiService;

    @PostMapping
    public CustomResponse<KullaniciRol> save(@RequestBody KullaniciRolDto kullaniciYetkiDto) {
        KullaniciRolDto kullaniciYetkiDto1 = kullaniciYetkiService.save(kullaniciYetkiDto);
        return new CustomResponse("Kullanici Rol tanimlamasi yapildi....","KYS1",kullaniciYetkiDto1);
    }


}
