package com.pale.view.config;

import com.pale.view.model.User;
import com.pale.view.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static org.springframework.security.core.userdetails.User.withUsername;

@Configuration
public class ApplicationConfiguration {
    @Autowired
    private UserRepository userRepository;
    @Bean
    public UserDetailsService userDetailsService() {
        /*
         * username actually represent the id of user, the login account is by their id
         * */

        return (username) -> {
            Long id = Long.valueOf(username);
            Optional<User> optional = userRepository.findById(id);
            if (optional.isEmpty())
                throw new UsernameNotFoundException("account not found");
            User user = optional.get();
            return withUsername(username).password(user.getPassword()).authorities(user.getType()).build();
        };
    }
}
