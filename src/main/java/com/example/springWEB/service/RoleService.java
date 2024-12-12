package com.example.springWEB.service;

import org.springframework.stereotype.Service;

import com.example.springWEB.domain.Role;
import com.example.springWEB.repository.RoleRepository;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findRoleByName(String name) {
        return this.roleRepository.findByName(name);
    }

}
