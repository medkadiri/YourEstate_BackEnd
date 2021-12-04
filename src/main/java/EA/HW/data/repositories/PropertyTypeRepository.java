package EA.HW.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import EA.HW.data.entities.PropertyType;

@RepositoryRestResource
public interface PropertyTypeRepository extends BaseRepository<PropertyType> {
    
    @Query(value = "select * from PropertyType", nativeQuery = true)
    List<PropertyType> findAllPropertyTypes();

}