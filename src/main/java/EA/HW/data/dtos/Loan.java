package EA.HW.data.dtos;

public class Loan extends Expense {

    private String startDate;

    private int periodMonths;

    private float percentage;

    private double monthlyPayment;

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

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

}
