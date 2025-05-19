package br.senai.lab364.futurodev.reciclaville.controllers;

import br.senai.lab364.futurodev.reciclaville.services.dashboards.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {
    private final DashboardService dashboardService;

    @GetMapping
    public ResponseEntity<String> Dashboard() {
        String result = dashboardService.resultDashboard();
        return ResponseEntity.ok(result);
    }

}
