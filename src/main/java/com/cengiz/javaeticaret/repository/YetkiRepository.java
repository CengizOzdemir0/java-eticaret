package com.cengiz.javaeticaret.repository;

import com.cengiz.javaeticaret.data.entity.Yetki;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface YetkiRepository extends JpaRepository<Yetki, Long> {

    Optional<Yetki> findByAdi(String ad);
    Yetki findById(Integer id);

}
