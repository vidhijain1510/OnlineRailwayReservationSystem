package com.railway.admin_service.service;

import com.railway.admin_service.model.Admin;
import com.railway.admin_service.repository.AdminRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public boolean login(String username, String password){
        Admin admin = adminRepository.findByUsername(username);
        //return admin != null && admin.getPassword().equals(password);//without logger

        if (admin == null) {
            log.warn("Login failed: No admin found with username '{}'", username);
            return false;
        }
        if (admin.getPassword().equals(password)) {
            log.info("Login successful for username: {}", username);
            return true;
        } else {
            return false;
        }
    }
}
