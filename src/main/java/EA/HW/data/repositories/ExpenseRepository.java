package EA.HW.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import EA.HW.data.entities.Expense;

public interface ExpenseRepository extends BaseRepository<Expense> {
    
    @Query(value = "select e from Expense e where e.property.id = %?1%", nativeQuery = true)
    List<Expense> findByProperty(long propertyId);

    @Query(value = "select e from Expense e where e.property.id = %?1% and e.type.id = %?2%", nativeQuery = true)
    List<Expense> findByPropertyAndType(long propertyId, long typeId);
    
    @Query(value = "select e from Expense e where e.creator.id = %?1%", nativeQuery = true)
    List<Expense> findByUser(long creatorId);

    @Query(value = "select e from Expense e where e.creator.id = %?1% and e.type.id = %?2%", nativeQuery = true)
    List<Expense> findByUserAndType(long creatorId, long typeId);

}