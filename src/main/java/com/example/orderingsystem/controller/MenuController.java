package com.example.orderingsystem.controller;

import com.example.orderingsystem.dto.response.ApiResponse;
import com.example.orderingsystem.entity.Menu;
import com.example.orderingsystem.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/menu")
@RequiredArgsConstructor
public class MenuController {
    private final MenuRepository menuRepository;

    @GetMapping
    public ApiResponse<List<Menu>> daftarMenu() {
        return ApiResponse.success("Daftar menu", menuRepository.findAll(Sort.by("idMenu")));
    }
}