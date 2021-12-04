package EA.HW.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import EA.HW.data.entities.User;
import EA.HW.data.repositories.UserRepository;

public class UserAuditor implements AuditorAware<User> {

    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<User> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            System.out.println("Null authentication");
            return null;
        }

        String username = (String) authentication.getPrincipal();
        System.out.println("username: " + username);
        return Optional.ofNullable(userRepository.findByUsername(username));
    }
}