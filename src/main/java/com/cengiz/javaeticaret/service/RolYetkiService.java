package com.cengiz.javaeticaret.service;


import com.cengiz.javaeticaret.data.dto.RolYetkiDto;
import com.cengiz.javaeticaret.data.entity.RolYetki;
import com.cengiz.javaeticaret.data.mapper.RolYetkiMapper;
import com.cengiz.javaeticaret.repository.RolYetkiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolYetkiService {

    private final RolYetkiRepository rolYetkiRepository;
    private final RolYetkiMapper rolYetkiMapper;

    public RolYetkiDto save(RolYetkiDto rolYetkiDto) {
        return rolYetkiMapper.toDto(rolYetkiRepository.save(rolYetkiMapper.toEntity(rolYetkiDto)));
    }

    public List<RolYetki> findByFkRolId(Integer rolId) {
        return rolYetkiRepository.findByFkRolId(rolId);
    }



}
