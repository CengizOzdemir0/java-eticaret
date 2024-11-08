package com.cengiz.javaeticaret.data.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "urun", schema = "base")
public class Urun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "isim", nullable = false)
    private String isim;

    @Column(name = "aciklama")
    private String aciklama;

    @NotNull
    @Column(name = "fiyat", nullable = false)
    private Double fiyat;

    @NotNull
    @Column(name = "stok_miktari", nullable = false)
    private Integer stokMiktari;

    @ManyToOne
    @JoinColumn(name = "kategori_id", referencedColumnName = "id")
    private Kategori kategori;
}