package com.cengiz.javaeticaret.service;


import com.cengiz.javaeticaret.RedisConfig.RedisService;
import com.cengiz.javaeticaret.data.dto.YetkiDto;
import com.cengiz.javaeticaret.data.entity.KullaniciRol;
import com.cengiz.javaeticaret.data.entity.RolYetki;
import com.cengiz.javaeticaret.data.entity.Yetki;
import com.cengiz.javaeticaret.data.mapper.YetkiMapper;
import com.cengiz.javaeticaret.repository.YetkiRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class YetkiService {

    private final YetkiRepository yetkiRepository;
    private final YetkiMapper yetkiMapper;
    private final RedisService redisService;
    private final KullaniciRolService kullaniciRolService;
    private final RolYetkiService rolYetkiService;



    public YetkiService(YetkiRepository yetkiRepository, YetkiMapper yetkiMapper, RedisService redisService, @Lazy KullaniciRolService kullaniciRolService, RolYetkiService rolYetkiService) {
        this.yetkiRepository = yetkiRepository;
        this.yetkiMapper = yetkiMapper;
        this.redisService = redisService;
        this.kullaniciRolService = kullaniciRolService;
        this.rolYetkiService = rolYetkiService;

    }


    public YetkiDto save(YetkiDto yetkiDto) {
        Optional<Yetki> byAd = yetkiRepository.findByAdi(yetkiDto.getAdi());
        if (byAd.isPresent()) {
            throw new RuntimeException("Yetki kayitli !");
        }

        YetkiDto yetki = yetkiMapper.toDto(yetkiRepository.save(yetkiMapper.toEntity(yetkiDto)));
        redisService.saveValue(String.valueOf(yetki.getId()), yetki);
        return yetki;
    }

    @Cacheable(value = "yetki", key = "#id")
    public Optional<Yetki> findById(Integer id) {
        return yetkiRepository.findById(Long.valueOf(id));
    }


    public Yetki findByYetki(Integer yetkiId) {
        return yetkiRepository.findById(yetkiId);
    }


    public List<Yetki> findAllYetkiListWFkKullaniciId(Integer fkKullaniciId) {
        List<KullaniciRol> allKullaniciRol = kullaniciRolService.findAllKullaniciYetkiList(fkKullaniciId);

        List<Integer> rolList = allKullaniciRol.stream()
                .map(KullaniciRol::getFkRolId)
                .toList();
        List<Integer> yetkiIdList = new ArrayList<>();
        for (Integer rol : rolList) {
            List<RolYetki> yetkiList = rolYetkiService.findByFkRolId(rol);
            if (yetkiList != null) {
                yetkiList.forEach(yetki -> yetkiIdList.add(yetki.getFkYetkiId()));
            }
        }

        List<Yetki> yetkiList = new ArrayList<>();
        for (Integer yetkiId : yetkiIdList) {
            yetkiList.add(findByYetki(yetkiId));
        }
         return yetkiList;
    }




}
