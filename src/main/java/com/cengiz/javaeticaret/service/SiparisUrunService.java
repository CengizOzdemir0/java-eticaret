package com.cengiz.javaeticaret.service;


import com.cengiz.javaeticaret.data.dto.SiparisUrunDto;
import com.cengiz.javaeticaret.data.mapper.SiparisUrunMapper;
import com.cengiz.javaeticaret.repository.SiparisUrunRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SiparisUrunService {

    private final SiparisUrunRepository siparisUrunRepository;
    private final SiparisUrunMapper siparisUrunMapper;


    public SiparisUrunDto create(SiparisUrunDto siparisUrunDto) {
        return siparisUrunMapper.toDto(siparisUrunRepository.save(siparisUrunMapper.toEntity(siparisUrunDto)));
    }

    public SiparisUrunDto update(SiparisUrunDto siparisUrunDto) {
        return siparisUrunMapper.toDto(siparisUrunRepository.save(siparisUrunMapper.toEntity(siparisUrunDto)));
    }

    public SiparisUrunDto getById(Integer id) {
        return siparisUrunMapper.toDto(siparisUrunRepository.findById(id).orElse(null));
    }

    public List<SiparisUrunDto> getAll() {
        return siparisUrunMapper.toDtoList(siparisUrunRepository.findAll());
    }

    public void delete(Integer id) {
        siparisUrunRepository.deleteById(id);
    }


}
