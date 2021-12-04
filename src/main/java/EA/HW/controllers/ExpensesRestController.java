package EA.HW.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

import EA.HW.data.dtos.Expense;
import EA.HW.data.dtos.Expenses;
import EA.HW.data.entities.User;
import EA.HW.data.repositories.UserRepository;
import EA.HW.services.ExpensesService;

@RestController
@RequestMapping("/rest/Expense")
@CrossOrigin(origins = "http://localhost:4200")
public class ExpensesRestController {

    @Autowired
    private ExpensesService expensesService;

    @Autowired
    private UserRepository userRepository;

    private User user;
    private long userId;

    @GetMapping("/get")
    public Expenses getExpense(Authentication auth){
        //Retrieve userId from JWT-based security context
        String userName = auth.getName();
        user = userRepository.findByUsername(userName);
        userId = user.getId();
        System.out.println(expensesService);
        return expensesService.getExpenses(userId);
    }

    @PatchMapping("/addExpense")
    public Expenses addExpense(@RequestBody Expense dto, Authentication auth){
        //Retrieve userId from JWT-based security context
        String userName = auth.getName();
        user = userRepository.findByUsername(userName);
        userId = user.getId();
        Expenses Expenses = expensesService.getExpenses(userId);
        return expensesService.addExpense(Expenses, userId, dto);
    }

    @PatchMapping("/removeExpense")
    public Expenses removeExpense(@RequestBody Expense dto, Authentication auth){
        //Retrieve userId from JWT-based security context
        String userName = auth.getName();
        user = userRepository.findByUsername(userName);
        userId = user.getId();
        Expenses expenses = expensesService.getExpenses(userId);
        return expensesService.removeExpense(expenses, userId, dto);
    }

    @PatchMapping("/empty")
    public Expenses empty(@RequestBody Expenses expenses, Authentication auth){
        //Retrieve userId from JWT-based security context
        String userName = auth.getName();
        user = userRepository.findByUsername(userName);
        userId = user.getId();
        return expensesService.empty(expenses, userId);
    }

    @PatchMapping("/saveExpenses")
    public boolean saveExpenses(@RequestBody Expenses expenses, Authentication auth){
        //Retrieve userId from JWT-based security context
        String userName = auth.getName();
        user = userRepository.findByUsername(userName);
        userId = user.getId();
        return expensesService.saveExpenses(expenses, userId);
    }
}
