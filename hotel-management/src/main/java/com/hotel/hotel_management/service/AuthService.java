package com.hotelmanagement.service;

import com.hotelmanagement.common.session.SessionManager;
import com.hotelmanagement.domain.entity.User;
import com.hotelmanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepo;

    public AuthService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User login(String username, String passwordPlain) {
        // demo: so sánh “giả lập”
        User u = userRepo.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Sai username"));

        if (!u.getPasswordHash().equals(passwordPlain)) {
            throw new IllegalArgumentException("Sai mật khẩu");
        }

        SessionManager.getInstance().setCurrentUser(u);
        return u;
    }

    public void logout() {
        SessionManager.getInstance().clear();
    }
}
