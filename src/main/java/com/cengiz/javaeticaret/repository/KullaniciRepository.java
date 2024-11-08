package com.cengiz.javaeticaret.repository;

import com.cengiz.javaeticaret.data.entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-11-08 15:03
 */

public interface KullaniciRepository extends JpaRepository<Kullanici, Integer> {
    Optional<Kullanici> findByEmail(String email);
}
