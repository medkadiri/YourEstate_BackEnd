package EA.HW.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EA.HW.data.entities.FCMTokenMapping;
import EA.HW.data.repositories.FCMTokenMappingRepository;
import EA.HW.data.repositories.UserRepository;

@Service
public class FCMTokenMappingService {
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    FCMTokenMappingRepository _FCMTokenMappingRepository;

    public boolean create(long userId, String FCMToken){
        try{
            FCMTokenMapping _FcmTokenMapping = new FCMTokenMapping(FCMToken, userId);
            _FCMTokenMappingRepository.save(_FcmTokenMapping);
            return true;
        }catch(Error err){
            return false;
        }
    }
}
