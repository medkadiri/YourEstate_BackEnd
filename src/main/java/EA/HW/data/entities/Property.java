package EA.HW.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "Property")
public class Property extends BaseEntity {
    
    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "image")
    @NotNull
    private String image;

    @Column(name = "location")
    @NotNull
    private String location;

    @Column(name = "area")
    @NotNull
    private String area;

    @Column(name = "price")
    @NotNull
    private double price;

    //@Column(name = "category")
    @ManyToOne
    @NotNull
    private Category category;

    //@Column(name = "propertyType")
    @ManyToOne
    @NotNull
    private PropertyType propertyType;

    //@Column(name = "owner")
    @ManyToOne
    @NotNull
    private User owner;

    // no seperation with loan because loan inherits all those attributes // polymorphism
    @Column(name = "expenses")
    @OneToMany(mappedBy = "property", fetch = FetchType.LAZY)
    @OrderBy("name asc")
    private List<Expense> expenses;

    public Property() {
    }

    public Property(@NotNull String name, @NotNull String description, @NotNull String image, @NotNull String location,
            @NotNull String area, @NotNull User owner) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.location = location;
        this.area = area;
        this.owner = owner;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}
