package com.example.springWEB.repository;

import com.example.springWEB.domain.User;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KhanhDzai - https://www.facebook.com/khanhdepzai.pro/
 */
@Repository
public interface UserRepository extends BaseRepository<User, Integer> {

    public Optional<User> findByEmail(String email);
}
