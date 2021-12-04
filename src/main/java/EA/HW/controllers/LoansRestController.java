package EA.HW.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

import EA.HW.data.dtos.Expenses;
import EA.HW.data.dtos.Loan;
import EA.HW.data.entities.User;
import EA.HW.data.repositories.UserRepository;
import EA.HW.services.LoansService;

@RestController
@RequestMapping("/rest/Loan")
@CrossOrigin(origins = "http://localhost:4200")
public class LoansRestController {

    @Autowired
    private LoansService loansService;

    @Autowired
    private UserRepository userRepository;

    private User user;
    private long userId;

    @GetMapping("/get")
    public Expenses getLoan(Authentication auth){
        //Retrieve userId from JWT-based security context
        String userName = auth.getName();
        user = userRepository.findByUsername(userName);
        userId = user.getId();
        System.out.println(loansService);
        return loansService.getLoans(userId);
    }

    @PatchMapping("/addLoan")
    public Expenses addLoan(@RequestBody Loan dto, Authentication auth){
        //Retrieve userId from JWT-based security context
        String userName = auth.getName();
        user = userRepository.findByUsername(userName);
        userId = user.getId();
        Expenses Expenses = loansService.getLoans(userId);
        return loansService.addLoan(Expenses, userId, dto);
    }

    @PatchMapping("/removeLoan")
    public Expenses removeLoan(@RequestBody Loan dto, Authentication auth){
        //Retrieve userId from JWT-based security context
        String userName = auth.getName();
        user = userRepository.findByUsername(userName);
        userId = user.getId();
        Expenses expenses = loansService.getLoans(userId);
        return loansService.removeLoan(expenses, userId, dto);
    }

    @PatchMapping("/empty")
    public Expenses empty(@RequestBody Expenses expenses, Authentication auth){
        //Retrieve userId from JWT-based security context
        String userName = auth.getName();
        user = userRepository.findByUsername(userName);
        userId = user.getId();
        return loansService.empty(expenses, userId);
    }

    @PatchMapping("/saveLoans")
    public boolean saveLoans(@RequestBody Expenses expenses, Authentication auth){
        //Retrieve userId from JWT-based security context
        String userName = auth.getName();
        user = userRepository.findByUsername(userName);
        userId = user.getId();
        return loansService.saveExpenses(expenses, userId);
    }
}
