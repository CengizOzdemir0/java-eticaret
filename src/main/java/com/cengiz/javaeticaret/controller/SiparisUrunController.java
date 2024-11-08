package com.cengiz.javaeticaret.controller;


import com.cengiz.javaeticaret.data.dto.SiparisUrunDto;
import com.cengiz.javaeticaret.exceptions.CustomResponse;
import com.cengiz.javaeticaret.service.SiparisUrunService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/siparis-urun")
public class SiparisUrunController {

    private final SiparisUrunService siparisUrunService;

    @GetMapping("/find/{id}")
    @PreAuthorize("hasAuthority('SORGU')")
    public CustomResponse<SiparisUrunDto> get(@PathVariable Integer id) {
        return new CustomResponse<>("Sorgu basarili", "OK", siparisUrunService.getById(id));
    }


    @GetMapping("/findAll")
    @PreAuthorize("hasAuthority('SORGU')")
    public CustomResponse<SiparisUrunDto> getAll() {
        return new CustomResponse("Sorgu basarili", "OK", siparisUrunService.getAll());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ISLEM')")
    public CustomResponse<SiparisUrunDto> create(@RequestBody SiparisUrunDto SiparisDto) {
        return new CustomResponse("Islem basarili", "OK", siparisUrunService.create(SiparisDto));
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('ISLEM')")
    public CustomResponse<SiparisUrunDto> update(@RequestBody SiparisUrunDto SiparisDto) {
        return new CustomResponse("Islem basarili", "OK", siparisUrunService.update(SiparisDto));
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ISLEM')")
    public void delete(@PathVariable Integer id) {
        siparisUrunService.delete(id);
    }
}
