package com.cengiz.javaeticaret.service;


import com.cengiz.javaeticaret.data.dto.KategoriDto;
import com.cengiz.javaeticaret.data.mapper.KategoriMapper;
import com.cengiz.javaeticaret.repository.KategoriRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KategoriService {

    private final KategoriRepository kategoriRepository;
    private final KategoriMapper kategoriMapper;


    public KategoriDto create(KategoriDto dto) {
        return kategoriMapper.toDto(kategoriRepository.save(kategoriMapper.toEntity(dto)));
    }
    public List<KategoriDto> findAll() {
        return kategoriMapper.toDtoList(kategoriRepository.findAll());
    }
    public KategoriDto findById(Integer id) {
        return kategoriMapper.toDto(kategoriRepository.findById(id).orElse(null));
    }
    public KategoriDto update(KategoriDto dto) {
        return kategoriMapper.toDto(kategoriRepository.save(kategoriMapper.toEntity(dto)));
    }
    public void delete(Integer id) {
        kategoriRepository.deleteById(id);
    }



}
