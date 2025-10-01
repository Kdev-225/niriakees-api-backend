package com.niriakees.niriakees_api.service;

import com.niriakees.niriakees_api.modele.AdminUser;
import com.niriakees.niriakees_api.repository.AdminUserRepository;
import com.niriakees.niriakees_api.security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminUserService {

    private final AdminUserRepository adminUserRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final JwtUtil jwtUtil;

    public AdminUserService(AdminUserRepository adminUserRepository, JwtUtil jwtUtil) {
        this.adminUserRepository = adminUserRepository;
        this.jwtUtil = jwtUtil;
    }

    public Optional<String> login(String username, String password) {
        try {
            Optional<AdminUser> userOpt = adminUserRepository.findByUsername(username);
            if (userOpt.isPresent() && passwordEncoder.matches(password, userOpt.get().getPasswordHash())) {
                String token = jwtUtil.generateToken(username);
                return Optional.of(token);
            }
            return Optional.empty();
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
