package EA.HW.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import EA.HW.data.entities.Authority;
import EA.HW.data.entities.User;
import EA.HW.data.repositories.AuthorityRepository;
import EA.HW.data.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    // Create admin account
    public boolean createSuperAdmin(String username, String password, String firstName, String lastName,
            String emailAddress, String address) {

        if (!authorityRepository.findByAuthority("ROLE_SUPERADMIN").isEmpty())
            return false;

        String[] authorities = { "ROLE_SUPERADMIN" };
        create(username, password, firstName, lastName, emailAddress, address, authorities);
        return true;
    }

    // Create back staff office account
    public void createAdmin(String username, String password, String firstName, String lastName, String emailAddress,
            String address) {

        String[] authorities = { "ROLE_ADMIN", "ROLE_USER" };
        create(username, password, firstName, lastName, emailAddress, address, authorities);
    }

    // Create regular user account
    public void createUser(String username, String password, String firstName, String lastName, String emailAddress,
            String address) {

        String[] authorities = { "ROLE_USER" };
        create(username, password, firstName, lastName, emailAddress, address, authorities);
    }

    // Generic create method
    private void create(String username, String password, String firstName, String lastName, String emailAddress,
            String address, String[] authorities) {

        User user = new User(username, password, firstName, lastName, emailAddress, address);
        userRepository.save(user);
        for (String auth : authorities) {
            Authority authority = new Authority(username, auth);
            authorityRepository.save(authority);
        }
    }

    // Generic update method
    public void update(long userId, String password, String newPassword, String firstName, String lastName,
            String emailAddress, String address) {
        User user = userRepository.findById(userId).get();
        if (password != null && (newPassword == null
                || !(new BCryptPasswordEncoder().encode(password).equals(user.getPassword())))) {
            return;
        }

        if (newPassword != null)
            user.setPassword(new BCryptPasswordEncoder().encode(newPassword));
        if (firstName != null)
            user.setFirstName(firstName);
        if (lastName != null)
            user.setLastName(lastName);
        if (emailAddress != null)
            user.setEmailAddress(emailAddress);
        if (address != null)
            user.setAddress(address);

        userRepository.save(user);
    }
}
