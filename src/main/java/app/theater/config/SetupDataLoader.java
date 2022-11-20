package app.theater.config;

import app.theater.model.Role;
import app.theater.model.User;
import app.theater.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(userRepository.findByEmail("a@a.pl") == null) {
            User user = new User(
                    "a@a.pl",
                    passwordEncoder.encode("a"),
                    Arrays.asList(new Role("ROLE_ADMIN")));
            userRepository.save(user);
        }
    }
}