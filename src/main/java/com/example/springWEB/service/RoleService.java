package com.example.springWEB.service;

import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Role;
import com.example.springWEB.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role findRoleByName(String name) {
        return this.roleRepository.findByName(name).orElse(null);
    }

}
