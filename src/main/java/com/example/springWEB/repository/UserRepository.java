package com.example.springWEB.repository;

import com.example.springWEB.domain.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KhanhDzai - https://www.facebook.com/khanhdepzai.pro/
 */
@Repository
public interface UserRepository extends BaseRepository<User, Integer> {
    public User findByEmail(String email);

    public Page<User> findAll(Pageable pageable);
}
