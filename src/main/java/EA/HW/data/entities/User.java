package EA.HW.data.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "\"user\"")
public class User extends BaseEntity {

    //private static final long serialVersionUID = -2323571384056059081L;

    @Column(name = "username")
    @NotNull
    protected String username;

    @Column(name = "password")
    @NotNull
    protected String password;

    @Column(name = "firstName")
    @NotNull
    protected String firstName;

    @Column(name = "lastName")
    @NotNull
    protected String lastName;

    @Column(name = "emailAddress")
    @NotNull
    protected String emailAddress;

    @Column(name = "address")
    @NotNull
    protected String address;

    @Column(name = "properties")
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    @OrderBy("name asc")
    private List<Property> properties;

    @Column(name = "loans")
    @OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
    @OrderBy("name asc")
    private List<Loan> loans;

    @Column(name = "expenses")
    @OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
    @OrderBy("name asc")
    private List<Expense> expenses;

    protected User() {
    }

    public User(String username, String password, String firstName, String lastName, String emailAddress,
            String address) {
        this.username = username;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLopans(List<Loan> loans) {
        this.loans = loans;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}