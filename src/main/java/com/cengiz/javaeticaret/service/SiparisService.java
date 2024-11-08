package com.cengiz.javaeticaret.service;


import com.cengiz.javaeticaret.data.dto.SiparisDto;
import com.cengiz.javaeticaret.data.mapper.SiparisMapper;
import com.cengiz.javaeticaret.repository.SiparisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SiparisService {

    private final SiparisRepository siparisRepository;
    private final SiparisMapper siparisMapper;


    public SiparisDto createSiparis(SiparisDto siparisDto) {
        return siparisMapper.toDto(siparisRepository.save(siparisMapper.toEntity(siparisDto)));
    }

    public List<SiparisDto> getAllSiparis() {
        return siparisMapper.toDtoList(siparisRepository.findAll());
    }

    public SiparisDto getSiparisById(Integer id) {
        return siparisMapper.toDto(siparisRepository.findById(id).orElse(null));
    }

    public SiparisDto updateSiparis(SiparisDto siparisDto) {
        return siparisMapper.toDto(siparisRepository.save(siparisMapper.toEntity(siparisDto)));
    }

    public void deleteSiparisById(Integer id) {
        siparisRepository.deleteById(id);
    }

}
