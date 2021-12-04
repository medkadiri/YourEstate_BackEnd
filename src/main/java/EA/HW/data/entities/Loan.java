package EA.HW.data.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Loan extends Expense {

    // attributes inheritted from Expense + 
    @Column(name = "startDate")
    @NotNull
    private String startDate;

    @Column(name = "periodMonths")
    @NotNull
    private int periodMonths;

    @Column(name = "percentages")
    @NotNull
    private float percentage;

    public Loan() {
    }

    public Loan(@NotNull String name, @NotNull String description, @NotNull String date, @NotNull Float cost,
            @NotNull Property property, @NotNull User creator, @NotNull Type type, @NotNull String startDate, @NotNull int periodMonths,
            @NotNull Float percentage) {
        super(name, description, date, cost, property, creator, type);
        this.startDate = startDate;
        this.periodMonths = periodMonths;
        this.percentage = percentage;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getPeriodMonths() {
        return periodMonths;
    }

    public void setPeriodMonths(int periodMonths) {
        this.periodMonths = periodMonths;
    }

    public Float getPercentage() {
        return percentage;
    }

    public void setPercentage(Float percentage) {
        this.percentage = percentage;
    }

    

}
