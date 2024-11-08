package com.cengiz.javaeticaret.data.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "siparis", schema = "base")
public class Siparis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "kullanici_id", referencedColumnName = "id")
    private Kullanici kullanici;

    @NotNull
    @Column(name = "toplam_fiyat", nullable = false)
    private Double toplamFiyat;

    @NotNull
    @Column(name = "durum", nullable = false)
    private String durum;

    @OneToMany(mappedBy = "siparis")
    private List<SiparisUrun> siparisUrunler;
}
