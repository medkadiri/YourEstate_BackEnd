package EA.HW.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import EA.HW.data.entities.Category;

@RepositoryRestResource
public interface CategoryRepository extends BaseRepository<Category> {

    @Query(value = "select * from Category", nativeQuery = true)
    List<Category> findAllCategories();

}