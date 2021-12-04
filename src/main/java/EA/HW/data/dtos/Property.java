package EA.HW.data.dtos;

import java.io.Serializable;

public class Property implements Serializable {

    private long propertyId;
    private long ownerId;

    protected Property() {
    }

    public long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(long propertyId) {
        this.propertyId = propertyId;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

}
