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
@Table(name = "PropertyType")
public class PropertyType extends BaseEntity {
    
    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "properties")
    @OneToMany(mappedBy = "propertyType", fetch = FetchType.LAZY)
    @OrderBy("name asc")
    private List<Property> properties;

    protected PropertyType() {
    }

    public PropertyType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
