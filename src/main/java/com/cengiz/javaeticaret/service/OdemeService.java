package com.cengiz.javaeticaret.service;


import com.cengiz.javaeticaret.data.dto.OdemeDto;
import com.cengiz.javaeticaret.data.mapper.OdemeMapper;
import com.cengiz.javaeticaret.repository.OdemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OdemeService {

    private final OdemeRepository odemeRepository;
    private final OdemeMapper odemeMapper;


    public OdemeDto create(OdemeDto odemeDto) {
        return odemeMapper.toDto(odemeRepository.save(odemeMapper.toEntity(odemeDto)));
    }

    public OdemeDto update(OdemeDto odemeDto) {
        return odemeMapper.toDto(odemeRepository.save(odemeMapper.toEntity(odemeDto)));
    }

    public OdemeDto findById(Integer id) {
        return odemeMapper.toDto(odemeRepository.findById(id).orElse(null));
    }

    public List<OdemeDto> findAll() {
        return odemeMapper.toDtoList(odemeRepository.findAll());
    }

    public void deleteById(Integer id) {
        odemeRepository.deleteById(id);
    }

}
