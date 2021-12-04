package EA.HW.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.web.bind.annotation.CrossOrigin;

import EA.HW.data.entities.BaseEntity;

@CrossOrigin(origins = "http://localhost:4200")
@NoRepositoryBean
public interface BaseRepository<E extends BaseEntity> extends CrudRepository<E, Long> {
    
}