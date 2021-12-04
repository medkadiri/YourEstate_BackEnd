package EA.HW.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import EA.HW.data.entities.Type;

@RepositoryRestResource
public interface TypeRepository extends BaseRepository<Type> {
    
    @Query(value = "select * from Type", nativeQuery = true)
    List<Type> findAllTypes();

}