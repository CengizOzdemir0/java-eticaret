package com.cengiz.javaeticaret.controller;


import com.cengiz.javaeticaret.data.dto.UrunDto;
import com.cengiz.javaeticaret.exceptions.CustomResponse;
import com.cengiz.javaeticaret.service.UrunService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/urun")
public class UrunController {

    private final UrunService urunService;


    @GetMapping("/find/{id}")
    @PreAuthorize("hasAuthority('SORGU')")
    public CustomResponse<UrunDto> get(@PathVariable Integer id) {
        return new CustomResponse<>("Sorgu basarili", "OK", urunService.findById(id));
    }

    @GetMapping("/findAll")
    @PreAuthorize("hasAuthority('SORGU')")
    public CustomResponse<UrunDto> getAll() {
        return new CustomResponse("Sorgu basarili", "OK", urunService.findAll());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ISLEM')")
    public CustomResponse<UrunDto> create(@RequestBody UrunDto dto) {
        return new CustomResponse("Islem basarili", "OK", urunService.create(dto));
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('ISLEM')")
    public CustomResponse<UrunDto> update(@RequestBody UrunDto dto) {
        return new CustomResponse("Islem basarili", "OK", urunService.update(dto));
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ISLEM')")
    public void delete(@PathVariable Integer id) {
        urunService.delete(id);
    }
}
