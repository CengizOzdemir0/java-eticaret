package com.cengiz.javaeticaret.controller;

import com.cengiz.javaeticaret.data.dto.OdemeDto;
import com.cengiz.javaeticaret.exceptions.CustomResponse;
import com.cengiz.javaeticaret.service.OdemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/odeme")
public class OdemeController {
    private final OdemeService odemeService;

    @GetMapping("/find/{id}")
    @PreAuthorize("hasAuthority('SORGU')")
    public CustomResponse<OdemeDto> getOdeme(@PathVariable Integer id) {
        return new CustomResponse<>("Sorgu basarili", "OK", odemeService.findById(id));
    }

    @GetMapping("/findAll")
    @PreAuthorize("hasAuthority('SORGU')")
    public CustomResponse<OdemeDto> getAllOdeme() {
        return new CustomResponse("Sorgu basarili", "OK", odemeService.findAll());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ISLEM')")
    public CustomResponse<OdemeDto> create(@RequestBody OdemeDto odemeDto) {
        return new CustomResponse("Islem basarili", "OK", odemeService.create(odemeDto));
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('ISLEM')")
    public CustomResponse<OdemeDto> update(@RequestBody OdemeDto odemeDto) {
        return new CustomResponse("Islem basarili", "OK", odemeService.update(odemeDto));
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ISLEM')")
    public void delete(@PathVariable Integer id) {
        odemeService.deleteById(id);
    }

}
