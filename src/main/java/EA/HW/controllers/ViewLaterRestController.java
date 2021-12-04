package EA.HW.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

import EA.HW.data.dtos.Property;
import EA.HW.data.dtos.ViewLater;
import EA.HW.data.entities.User;
import EA.HW.data.repositories.UserRepository;
import EA.HW.services.ViewLaterService;

@RestController
@RequestMapping("/rest/viewLater")
@CrossOrigin(origins = "http://localhost:4200")
public class ViewLaterRestController {

    @Autowired
    private ViewLaterService viewLaterService;

    @Autowired
    private UserRepository userRepository;

    private User user;
    long userId;

    @GetMapping("/get")
    public ViewLater getViewLater(Authentication auth){
        //Retrieve userId from JWT-based security context
        if(auth == null){
            return null;
        }
        String userName = auth.getName();
        user = userRepository.findByUsername(userName);
        userId = user.getId();
        System.out.println(viewLaterService);
        return viewLaterService.getViewLater(userId);
    }

    @PatchMapping("/addProperty")
    public ViewLater addProperty(@RequestBody Property dto, Authentication auth){
        //Retrieve userId from JWT-based security context
        String userName = auth.getName();
        user = userRepository.findByUsername(userName);
        userId = user.getId();
        ViewLater viewLater = viewLaterService.getViewLater(userId);
        return viewLaterService.addProperty(viewLater, userId, dto.getPropertyId());
    }

    @PatchMapping("/removeProperty")
    public ViewLater removeProperty(@RequestBody Property dto, Authentication auth){
        //Retrieve userId from JWT-based security context
        String userName = auth.getName();
        user = userRepository.findByUsername(userName);
        userId = user.getId();
        ViewLater viewLater = viewLaterService.getViewLater(userId);
        return viewLaterService.removeProperty(viewLater, userId, dto.getPropertyId());
    }

    @PatchMapping("/empty")
    public ViewLater empty(@RequestBody ViewLater viewLater, Authentication auth){
        //Retrieve userId from JWT-based security context
        String userName = auth.getName();
        user = userRepository.findByUsername(userName);
        userId = user.getId();
        return viewLaterService.empty(viewLater, userId);
    }

}