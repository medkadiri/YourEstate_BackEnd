package EA.HW.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import EA.HW.data.dtos.Expense;
import EA.HW.data.dtos.Expenses;
import EA.HW.data.dtos.Loan;
import EA.HW.data.entities.Property;
import EA.HW.data.entities.User;
import EA.HW.data.repositories.LoanRepository;
import EA.HW.data.repositories.PropertyRepository;
import EA.HW.data.repositories.UserRepository;

@Service
public class LoansService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private UserRepository userRepository;

    @Cacheable(value = "Loans")
    public Expenses getLoans(long userId){
        return new Expenses();
    }

    @CachePut(value = "Loans", key = "#userId")
    public Expenses addLoan(Expenses loans, long userId, Loan loan){
        loans.addExpense(loan);
        return loans;
    }

    @CachePut(value = "Loans", key = "#userId")
    public Expenses removeLoan(Expenses loans, long userId, Loan loan){
        loans.removeExpense(loan);
        return loans;
    }

    @CachePut(value = "Loans", key = "#userId")
    public Expenses empty(Expenses loans, long userId){
        loans.empty();
        return loans;
    }

    public boolean saveExpenses(Expenses loans, long userId){
        List<Expense> list = loans.getcreatedExpenses();
        User u = userRepository.findById(userId).get();
        EA.HW.data.entities.Loan loan;
        Expense dto;
        Loan _dto;
        int i;
        Property p;
        for(i = 0; i < list.size(); i++){
            dto = list.get(i);
            if(dto.getType().getName().equals("Loan")){
                _dto = (Loan) dto;
                p = propertyRepository.findByPropertyId(dto.getPropertyId());
                loan = new EA.HW.data.entities.Loan(_dto.getName(), _dto.getDescription(), _dto.getDate(), _dto.getCost(), p, u, _dto.getType(), _dto.getStartDate(), _dto.getPeriodMonths(), _dto.getPercentage());
                loanRepository.save(loan);
            }
        }
        return true;
    }

}
