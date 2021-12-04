package EA.HW.data.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Type")
public class Type extends BaseEntity {

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "type")
    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
    @OrderBy("name asc")
    private List<Expense> expenses;

    protected Type() {
    }

    public Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}
