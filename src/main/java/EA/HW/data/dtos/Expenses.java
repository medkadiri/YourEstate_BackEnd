package EA.HW.data.dtos;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Expenses implements Serializable{

    private List<Expense> createdExpenses;
    
    public Expenses() {
        createdExpenses = new LinkedList<Expense>();
    }

    public void addExpense(Expense e){
        createdExpenses.add(e);
    } 
    
    public void removeExpense(Expense e){
        createdExpenses.remove(e);
    }

    public int getNumberOfExpenses(){
        return createdExpenses.size();
    }

    public List<Expense> getcreatedExpenses(){
        return createdExpenses;
    }

    public void empty(){
        createdExpenses = new LinkedList<Expense>();
    }
    
}
