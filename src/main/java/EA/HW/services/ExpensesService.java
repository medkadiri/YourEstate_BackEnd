package EA.HW.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import EA.HW.data.dtos.Expenses;
import EA.HW.data.entities.Property;
import EA.HW.data.entities.User;
import EA.HW.data.dtos.Expense;
import EA.HW.data.repositories.ExpenseRepository;
import EA.HW.data.repositories.PropertyRepository;
import EA.HW.data.repositories.UserRepository;


@Service
public class ExpensesService {
    
    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private UserRepository userRepository;

    @Cacheable(value = "Expenses")
    public Expenses getExpenses(long userId){
        return new Expenses();
    }

    @CachePut(value = "Expenses", key = "#userId")
    public Expenses addExpense(Expenses expenses, long userId, Expense expense){;
        expenses.addExpense(expense);
        return expenses;
    }

    @CachePut(value = "Expenses", key = "#userId")
    public Expenses removeExpense(Expenses expenses, long userId, Expense expense){
        expenses.removeExpense(expense);
        return expenses;
    }

    @CachePut(value = "Expenses", key = "#userId")
    public Expenses empty(Expenses expenses, long userId){
        expenses.empty();
        return expenses;
    }

    public boolean saveExpenses(Expenses expenses, long userId){
        List<Expense> list = expenses.getcreatedExpenses();
        User u = userRepository.findById(userId).get();
        EA.HW.data.entities.Expense expense;
        Expense dto;
        int i;
        Property p;
        for(i = 0; i < list.size(); i++){
            dto = list.get(i);
            if(dto.getType().getName().equals("Expense")){
                p = propertyRepository.findByPropertyId(dto.getPropertyId());
                expense = new EA.HW.data.entities.Expense(dto.getName(), dto.getDescription(), dto.getDate(), dto.getCost(), p, u, dto.getType());
                expenseRepository.save(expense);
            }
        }
        return true;
    }

}
