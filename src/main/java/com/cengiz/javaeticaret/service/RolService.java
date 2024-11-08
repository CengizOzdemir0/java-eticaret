package com.cengiz.javaeticaret.service;


import com.cengiz.javaeticaret.data.dto.RolDto;
import com.cengiz.javaeticaret.data.entity.Rol;
import com.cengiz.javaeticaret.data.mapper.RolMapper;
import com.cengiz.javaeticaret.repository.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RolService {

    private final RolRepository rolRepository;
    private final RolMapper rolMapper;

    public RolDto save(RolDto rolDto) {
        return rolMapper.toDto(rolRepository.save(rolMapper.toEntity(rolDto)));
    }

    public Optional<Rol> findById(Integer id) {
        return rolRepository.findById(id);
    }



}
