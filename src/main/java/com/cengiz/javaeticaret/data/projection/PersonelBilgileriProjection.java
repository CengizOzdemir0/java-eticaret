package com.cengiz.javaeticaret.data.projection;

import java.time.LocalDate;

/**
 * @author Cengiz ÖZDEMİR
 * @date 2024-11-08 15:03
 */

public interface PersonelBilgileriProjection {

    Integer getPersonelId();
    String getAd();
    String getSoyad();
    Integer getYas();
    String getMeslekKodu();
    String getMeslekAdi();
    LocalDate getMeslekGirisTarihi();

}
