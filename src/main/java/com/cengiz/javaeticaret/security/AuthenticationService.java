package com.cengiz.javaeticaret.security;

import com.cengiz.javaeticaret.data.dto.KullaniciDto;
import com.cengiz.javaeticaret.data.dto.LoginKullaniciDto;
import com.cengiz.javaeticaret.data.entity.Kullanici;
import com.cengiz.javaeticaret.data.mapper.KullaniciMapper;
import com.cengiz.javaeticaret.repository.KullaniciRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-11-08 15:03
 */

@Service
public class AuthenticationService {

    private final KullaniciRepository kullaniciRepository;

    private final PasswordEncoder passwordEncoder;

    private final KullaniciMapper kullaniciMapper;

    public AuthenticationService(
            KullaniciRepository kullaniciRepository,
            PasswordEncoder passwordEncoder,
            KullaniciMapper kullaniciMapper
    ) {
        this.kullaniciRepository = kullaniciRepository;
        this.passwordEncoder = passwordEncoder;
        this.kullaniciMapper = kullaniciMapper;
    }

    public KullaniciDto signup(KullaniciDto kullaniciDto) {
        kullaniciDto.setUuid(UUID.randomUUID());
        Kullanici kullanici = kullaniciMapper.toEntity(kullaniciDto);
        kullanici.setPassword(passwordEncoder.encode(kullaniciDto.getPassword()));
        kullaniciRepository.save(kullanici);
        return kullaniciDto;
    }

    public KullaniciDto authenticate(LoginKullaniciDto loginKullaniciDto) {
        return kullaniciMapper.toDto(kullaniciRepository.findByEmail(loginKullaniciDto.getEmail())
                .orElseThrow());
    }
}
