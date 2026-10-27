package com.example.orderingsystem.config;

import com.example.orderingsystem.entity.Menu;
import com.example.orderingsystem.entity.Pelanggan;
import com.example.orderingsystem.repository.MenuRepository;
import com.example.orderingsystem.repository.PelangganRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final PelangganRepository pelangganRepository;
    private final MenuRepository menuRepository;

    @Override
    public void run(String... args) {
        if (pelangganRepository.count() == 0) {
            pelangganRepository.save(Pelanggan.builder()
                .idPelanggan("CUST-001").nama("Budi Santoso").email("budi@example.com")
                .nomorTelepon("08123456789").alamat("Jl. Sudirman No. 45, Jakarta").build());
        }
        if (menuRepository.count() == 0) {
            menuRepository.saveAll(List.of(
                Menu.builder().idMenu("MENU-01").namaMenu("Kopi Susu Gula Aren").harga(18000).stok(20).build(),
                Menu.builder().idMenu("MENU-02").namaMenu("Croissant Butter").harga(25000).stok(10).build()));
        }
    }
}