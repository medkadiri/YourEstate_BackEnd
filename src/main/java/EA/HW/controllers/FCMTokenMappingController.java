package EA.HW.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EA.HW.data.entities.User;
import EA.HW.data.repositories.UserRepository;
import EA.HW.services.FCMTokenMappingService;


@RestController
@RequestMapping("/rest/FCMTokenMapping")
@CrossOrigin(origins = "http://localhost:4200")
public class FCMTokenMappingController {

    @Autowired
    private FCMTokenMappingService _FcmTokenMappingService;

    @Autowired
    private UserRepository userRepository;

    private User user;
    long userId;

    @PostMapping("/registerToken")
    public Boolean registerToken(@RequestBody String _FcmToken, Authentication auth) {
        System.out.println("\n\nare you here\n\n");
        if(auth == null){
            return false;
        }
        String userName = auth.getName();
        user = userRepository.findByUsername(userName);
        userId = user.getId();
        System.out.println("\nUSER ID: " + userId + "\n");
        return _FcmTokenMappingService.create(userId, _FcmToken);
    }
}