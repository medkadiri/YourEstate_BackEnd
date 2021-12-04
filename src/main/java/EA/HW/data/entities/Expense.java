package EA.HW.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Expense")
public class Expense extends BaseEntity {

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "date")
    @NotNull
    private String date;

    @Column(name = "cost")
    @NotNull
    private float cost;

    //@Column(name = "property")
    @ManyToOne
    @NotNull
    private Property property;

    //@Column(name = "creator")
    @ManyToOne
    @NotNull
    private User creator;

    //@Column(name = "type")
    @ManyToOne
    @NotNull
    private Type type;

    public Expense() {
    }

    public Expense(@NotNull String name, @NotNull String description, @NotNull String date, @NotNull Float cost,
            @NotNull Property property, @NotNull User creator, @NotNull Type type) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.cost = cost;
        this.property = property;
        this.creator = creator;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    
}
