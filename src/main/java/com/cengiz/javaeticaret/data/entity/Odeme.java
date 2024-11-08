package com.cengiz.javaeticaret.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "odeme", schema = "base")
public class Odeme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "siparis_id", referencedColumnName = "id")
    private Siparis siparis;

    @NotNull
    @Column(name = "odeme_tutari", nullable = false)
    private Double odemeTutari;

    @NotNull
    @Column(name = "odeme_durumu", nullable = false)
    private String odemeDurumu;
}