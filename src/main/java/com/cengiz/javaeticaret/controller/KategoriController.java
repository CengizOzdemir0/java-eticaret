package com.cengiz.javaeticaret.controller;


import com.cengiz.javaeticaret.data.dto.KategoriDto;
import com.cengiz.javaeticaret.exceptions.CustomResponse;
import com.cengiz.javaeticaret.service.KategoriService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kategori")
public class KategoriController {
    private final KategoriService kategoriService;

    @GetMapping("/find/{id}")
    @PreAuthorize("hasAuthority('SORGU')")
    public CustomResponse<KategoriDto> getKategori(@PathVariable Integer id) {
        return new CustomResponse<>("Sorgu basarili", "OK", kategoriService.findById(id));
    }

    @GetMapping("/findAll")
    @PreAuthorize("hasAuthority('SORGU')")
    public CustomResponse<KategoriDto> getAllKategori() {
        return new CustomResponse("Sorgu basarili", "OK", kategoriService.findAll());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ISLEM')")
    public CustomResponse<KategoriDto> create(@RequestBody KategoriDto kategoriDto) {
        return new CustomResponse("Islem basarili", "OK", kategoriService.create(kategoriDto));
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('ISLEM')")
    public CustomResponse<KategoriDto> update(@RequestBody KategoriDto kategoriDto) {
        return new CustomResponse("Islem basarili", "OK", kategoriService.update(kategoriDto));
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ISLEM')")
    public void delete(@PathVariable Integer id) {
        kategoriService.delete(id);
    }


}
