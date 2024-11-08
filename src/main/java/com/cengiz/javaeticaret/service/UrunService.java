package com.cengiz.javaeticaret.service;


import com.cengiz.javaeticaret.data.dto.UrunDto;
import com.cengiz.javaeticaret.data.mapper.UrunMapper;
import com.cengiz.javaeticaret.repository.UrunRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UrunService {


    private final UrunRepository urunRepository;
    private final UrunMapper urunMapper;

    public UrunDto create(UrunDto urunDto) {
        return urunMapper.toDto(urunRepository.save(urunMapper.toEntity(urunDto)));
    }

    public UrunDto update(UrunDto urunDto) {
        return urunMapper.toDto(urunRepository.save(urunMapper.toEntity(urunDto)));
    }

    public List<UrunDto> findAll() {
        return urunMapper.toDtoList(urunRepository.findAll());
    }

    public UrunDto findById(Integer id) {
        return urunMapper.toDto(urunRepository.findById(id).orElse(null));
    }

    public void delete(Integer id) {
        urunRepository.deleteById(id);
    }

}
