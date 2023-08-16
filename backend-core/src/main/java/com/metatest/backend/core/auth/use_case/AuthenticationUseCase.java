package com.metatest.backend.core.auth.use_case;

import com.metatest.backend.core.user.adapter.UserRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AuthenticationUseCase implements UserDetailsService {

    private final UserRepositoryAdapter userRepositoryAdapter;

    public UserDetails execute(String email) {
        return loadUserByUsername(email);
    }


    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {


        var user = userRepositoryAdapter.findUserByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("User not found",null);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }

}
