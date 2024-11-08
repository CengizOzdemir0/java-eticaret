package com.cengiz.javaeticaret.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "siparis_urun", schema = "base")
public class SiparisUrun {

    @Id
    @ManyToOne
    @JoinColumn(name = "siparis_id", referencedColumnName = "id")
    private Siparis siparis;

    @Id
    @ManyToOne
    @JoinColumn(name = "urun_id", referencedColumnName = "id")
    private Urun urun;

    @NotNull
    @Column(name = "miktar", nullable = false)
    private Integer miktar;
}