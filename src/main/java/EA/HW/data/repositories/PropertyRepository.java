package EA.HW.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import EA.HW.data.entities.Property;

@RepositoryRestResource
public interface PropertyRepository extends BaseRepository<Property> {

        @Query(value = "select p from Property p where p.id = ?1", nativeQuery = true)
        Property findByPropertyId(long id);

        @Query(value = "select p from Property p where p.owner.id = ?1", nativeQuery = true)
        List<Property> findByName(long userId);

        @Query(value = "select p from Property p where p.name like ?1", nativeQuery = true)
        List<Property> findByOwner(String name);

        @Query(value = "select p from Property p where p.name like %?1% and p.price between ?2 and ?3", nativeQuery = true)
        List<Property> findByNameAndPrice(String name, float min, float max);

        @Query(value = "select p from Property p where p.category.id = ?1", nativeQuery = true)
        List<Property> findByCategory(long categoryId);

        @Query(value = "select p from Property p where p.category.id = ?1 and p.price between ?2 and ?3", nativeQuery = true)
        List<Property> findByCategoryAndPrice(long categoryId, float min, float max);

        @Query(value = "select p from Property p where p.propertyType.id = ?1", nativeQuery = true)
        List<Property> findByPropertyType(long PropertyTypeId);

        @Query(value = "select p from Property p where p.propertyType.id = ?1 and p.price between ?2 and ?3", nativeQuery = true)
        List<Property> findByPropertyTypeAndPrice(long PropertyTypeId, float min, float max);

        @Query(value = "select p from Property p where p.location like %?1%", nativeQuery = true)
        List<Property> findByLocation(String location);
}