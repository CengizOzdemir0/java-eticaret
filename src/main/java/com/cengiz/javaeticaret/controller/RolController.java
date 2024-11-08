package com.cengiz.javaeticaret.controller;

import com.cengiz.javaeticaret.data.dto.RolDto;
import com.cengiz.javaeticaret.exceptions.CustomResponse;
import com.cengiz.javaeticaret.service.RolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rol")
public class RolController {

    private final RolService rolService;

    @PostMapping
    public CustomResponse<RolDto> save(@RequestBody RolDto rolDto) {
        return new CustomResponse("Rol kaydedildi.","OK",rolService.save(rolDto));
    }
}
