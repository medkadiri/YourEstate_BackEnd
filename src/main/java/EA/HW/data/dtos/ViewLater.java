package EA.HW.data.dtos;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import EA.HW.data.entities.Property;

public class ViewLater implements Serializable {

    private List<Property> selectedProperties;

    public ViewLater() {

        selectedProperties = new LinkedList<Property>();

    }

    public void addProperty(Property p){
        selectedProperties.add(p);
    } 
    
    public void removeProperty(Property p){
        selectedProperties.remove(p);
    }

    public int getNumberOfProperties(){
        return selectedProperties.size();
    }

    public List<Property> getSelectedProperties(){
        return selectedProperties;
    }

    public void empty(){
        selectedProperties = new LinkedList<Property>();
    }
    
}
