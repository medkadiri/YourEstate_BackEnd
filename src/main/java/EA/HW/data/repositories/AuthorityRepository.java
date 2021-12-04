package EA.HW.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import EA.HW.data.entities.Authority;

public interface AuthorityRepository extends BaseRepository<Authority> {
    
    @Query(value = "select a from Authority a where a.authority like %?1%", nativeQuery = true)
    List<Authority> findByAuthority(String authority);
    
}