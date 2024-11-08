-- Ürün Tablosu
CREATE TABLE base.urun (
                           id SERIAL PRIMARY KEY,
                           isim VARCHAR(255) NOT NULL,
                           aciklama TEXT,
                           fiyat DECIMAL(10, 2) NOT NULL,
                           stok_miktari INTEGER NOT NULL,
                           kategori_id INTEGER REFERENCES base.kategori(id)
);

-- Kategori Tablosu
CREATE TABLE base.kategori (
                               id SERIAL PRIMARY KEY,
                               isim VARCHAR(255) UNIQUE NOT NULL
);

-- Sipariş Tablosu
CREATE TABLE base.siparis (
                              id SERIAL PRIMARY KEY,
                              kullanici_id INTEGER REFERENCES base.kullanici(id),
                              toplam_fiyat DECIMAL(10, 2) NOT NULL,
                              siparis_tarihi TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                              durum VARCHAR(50) NOT NULL
);

-- Sipariş-Ürün İlişkisi
CREATE TABLE base.siparis_urun (
                                   siparis_id INTEGER REFERENCES base.siparis(id),
                                   urun_id INTEGER REFERENCES base.urun(id),
                                   miktar INTEGER NOT NULL,
                                   PRIMARY KEY (siparis_id, urun_id)
);

-- Ödeme Tablosu
CREATE TABLE base.odeme (
                            id SERIAL PRIMARY KEY,
                            siparis_id INTEGER REFERENCES base.siparis(id),
                            odeme_tutari DECIMAL(10, 2) NOT NULL,
                            odeme_tarihi TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            odeme_durumu VARCHAR(50) NOT NULL
);