package com.cengiz.javaeticaret.service;


import com.cengiz.javaeticaret.data.dto.KullaniciDto;
import com.cengiz.javaeticaret.data.dto.KullaniciRolDto;
import com.cengiz.javaeticaret.data.entity.KullaniciRol;
import com.cengiz.javaeticaret.data.entity.Rol;
import com.cengiz.javaeticaret.data.mapper.KullaniciRolMapper;
import com.cengiz.javaeticaret.repository.KullaniciRolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KullaniciRolService {

    private final KullaniciRolRepository kullaniciRolRepository;
    private final KullaniciRolMapper kullaniciRolMapper;
    private final KullaniciService kullaniciService;
    private final RolService rolService;

    public KullaniciRolService(KullaniciRolRepository kullaniciRolRepository, KullaniciRolMapper kullaniciYetkiMapper, KullaniciService kullaniciService, RolService rolService) {
        this.kullaniciRolRepository = kullaniciRolRepository;
        this.kullaniciRolMapper = kullaniciYetkiMapper;
        this.kullaniciService = kullaniciService;
        this.rolService = rolService;
    }


    public KullaniciRolDto save(KullaniciRolDto kullaniciYetkiDto) {
        Optional<KullaniciRol> kullaniciYetki = kullaniciRolRepository.findByFkKullaniciIdAndAndFkRolId(kullaniciYetkiDto.getFkKullaniciId(), kullaniciYetkiDto.getFkRolId());
        if(kullaniciYetki.isPresent()) {
            throw new RuntimeException("Kullanici Yetki iliskisi mevcut");
        }
        KullaniciDto kullaniciById = kullaniciService.getKullaniciById(kullaniciYetkiDto.getFkKullaniciId());
        if(kullaniciById == null) {
            throw new RuntimeException("Kullanici kayitli degil");
        }
        Optional<Rol> byId = rolService.findById(kullaniciYetkiDto.getFkRolId());
        if(byId.isEmpty()) {
            throw new RuntimeException("Rol tanimli degil");
        }

        return kullaniciRolMapper.toDto(kullaniciRolRepository.save(kullaniciRolMapper.toEntity(kullaniciYetkiDto)));
    }

    public List<KullaniciRol> findAllKullaniciYetkiList(Integer fkKullaniciId) {
      return kullaniciRolRepository.findAllByFkKullaniciId(fkKullaniciId);
    }



}
