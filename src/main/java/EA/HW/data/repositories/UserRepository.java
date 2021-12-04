package EA.HW.data.repositories;

import EA.HW.data.entities.User;

public interface UserRepository extends BaseRepository<User>{
    
    User findByUsername(String username);

}