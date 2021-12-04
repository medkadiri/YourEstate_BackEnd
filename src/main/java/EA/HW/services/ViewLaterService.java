package EA.HW.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import EA.HW.data.dtos.ViewLater;
import EA.HW.data.entities.Property;
import EA.HW.data.repositories.PropertyRepository;

@Service
public class ViewLaterService {
    
    @Autowired
    private PropertyRepository propertyRepository;

    @Cacheable(value = "ViewLater")
    public ViewLater getViewLater(long userId){
        return new ViewLater();
    }

    @CachePut(value = "ViewLater", key = "#userId")
    public ViewLater addProperty(ViewLater viewLater, long userId, long propertyId){
        Property property = propertyRepository.findById(propertyId).get();
        viewLater.addProperty(property);
        return viewLater;
    }

    @CachePut(value = "ViewLater", key = "#userId")
    public ViewLater removeProperty(ViewLater viewLater, long userId, long propertyId){
        Property property = propertyRepository.findById(propertyId).get();
        viewLater.removeProperty(property);
        return viewLater;
    }

    @CachePut(value = "ViewLater", key = "#userId")
    public ViewLater empty(ViewLater viewLater, long userId){
        viewLater.empty();
        return viewLater;
    }

}
