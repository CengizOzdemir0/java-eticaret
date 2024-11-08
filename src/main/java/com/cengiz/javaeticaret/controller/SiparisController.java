package com.cengiz.javaeticaret.controller;


import com.cengiz.javaeticaret.data.dto.SiparisDto;
import com.cengiz.javaeticaret.exceptions.CustomResponse;
import com.cengiz.javaeticaret.service.SiparisService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/siparis")
public class SiparisController {
    private final SiparisService siparisService;

    @GetMapping("/find/{id}")
    @PreAuthorize("hasAuthority('SORGU')")
    public CustomResponse<SiparisDto> get(@PathVariable Integer id) {
        return new CustomResponse<>("Sorgu basarili", "OK", siparisService.getSiparisById(id));
    }

    @GetMapping("/findAll")
    @PreAuthorize("hasAuthority('SORGU')")
    public CustomResponse<SiparisDto> getAll() {
        return new CustomResponse("Sorgu basarili", "OK", siparisService.getAllSiparis());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ISLEM')")
    public CustomResponse<SiparisDto> create(@RequestBody SiparisDto SiparisDto) {
        return new CustomResponse("Islem basarili", "OK", siparisService.createSiparis(SiparisDto));
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('ISLEM')")
    public CustomResponse<SiparisDto> update(@RequestBody SiparisDto SiparisDto) {
        return new CustomResponse("Islem basarili", "OK", siparisService.updateSiparis(SiparisDto));
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ISLEM')")
    public void delete(@PathVariable Integer id) {
        siparisService.deleteSiparisById(id);
    }


}
