package com.cengiz.javaeticaret.controller;


import com.cengiz.javaeticaret.data.dto.YetkiDto;
import com.cengiz.javaeticaret.exceptions.CustomResponse;
import com.cengiz.javaeticaret.service.YetkiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/yetki")
@RequiredArgsConstructor
public class YetkiController {

    private final YetkiService yetkiService;

    @PostMapping
    //TODO yetki tanimlanacak
    public CustomResponse<YetkiDto> save(@RequestBody YetkiDto yetkiDto) {
        return new CustomResponse("Yetki tanimlandi","YTK1",yetkiService.save(yetkiDto));
    }

    @PostMapping("/find/{id}")
    public CustomResponse<YetkiDto> findById(@PathVariable Integer id) {
        return new CustomResponse("Sorgu basarili","OK",yetkiService.findById(id));
    }


}
