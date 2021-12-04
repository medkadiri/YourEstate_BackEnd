package EA.HW.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import EA.HW.data.entities.Loan;

public interface LoanRepository extends BaseRepository<Loan> {
    
    @Query(value = "select l from Loan l where l.property.id = %?1%", nativeQuery = true)
    List<Loan> findByProperty(long propertyId);

    @Query(value = "select l from Loan l where l.property.id = %?1% and e.type.id = %?2%", nativeQuery = true)
    List<Loan> findByPropertyAndType(long propertyId, long typeId);
    
    @Query(value = "select l from Loan l where l.creator.id = %?1%", nativeQuery = true)
    List<Loan> findByUser(long creatorId);

    @Query(value = "select l from Loan l where l.creator.id = %?1% and e.type.id = %?2%", nativeQuery = true)
    List<Loan> findByUserAndType(long creatorId, long typeId);

}