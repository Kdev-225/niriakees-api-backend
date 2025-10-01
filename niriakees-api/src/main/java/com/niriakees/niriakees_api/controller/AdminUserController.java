package com.niriakees.niriakees_api.controller;

import com.niriakees.niriakees_api.service.AdminUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminUserController {

    private final AdminUserService adminUserService;

    public AdminUserController(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> body) {
        Map<String, Object> response = new HashMap<>();
        try {
            String username = body.get("username");
            String password = body.get("password");

            Optional<String> tokenOpt = adminUserService.login(username, password);

            if (tokenOpt.isPresent()) {
                response.put("status", "success");
                response.put("token", tokenOpt.get());
                response.put("message", "Connexion réussie !");
                return ResponseEntity.ok(response);
            } else {
                response.put("status", "error");
                response.put("message", "Identifiants incorrects");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.put("status", "error");
            response.put("message", "Erreur serveur : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
