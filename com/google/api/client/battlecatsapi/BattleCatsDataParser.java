package com.google.api.client.battlecatsapi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * TBC Modder 1.0 - Data Parser
 * Bu sınıf, Battle Cats paket listelerini (.list) okur ve 
 * içindeki dosyaların haritasını çıkarır.
 */
public class BattleCatsDataParser {

    private final File listFile;
    private List<String> fileNames = new ArrayList<>();

    public BattleCatsDataParser(File listFile) {
        this.listFile = listFile;
    }

    /**
     * .list dosyasını okur ve içindeki dosya isimlerini ayıklar.
     * Battle Cats paket yapısında ilk satır dosya sayısıdır.
     */
    public void parseListFile() throws Exception {
        if (!listFile.exists()) {
            throw new Exception("Hata: .list dosyası bulunamadı!");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(listFile))) {
            String line;
            int count = 0;
            
            // İlk satırı oku (Toplam dosya sayısı)
            String head = reader.readLine();
            if (head != null) {
                count = Integer.parseInt(head.trim());
            }

            // Dosya isimlerini listeye ekle
            while ((line = reader.readLine()) != null && fileNames.size() < count) {
                String[] parts = line.split("\\s+"); // Boşluklara göre ayır
                if (parts.length > 0) {
                    fileNames.add(parts[0]); // Dosya adını al (Örn: unit001.csv)
                }
            }
        }
    }

    public List<String> getFileNames() {
        return fileNames;
    }

    /**
     * Belirli bir dosyanın (örneğin 'unit.csv') listede olup olmadığını kontrol eder.
     */
    public boolean containsFile(String fileName) {
        return fileNames.contains(fileName);
    }
}
