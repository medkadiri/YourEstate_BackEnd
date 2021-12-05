package EA.HW.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "FCMTokenMapping")
public class FCMTokenMapping extends BaseEntity {
    
    @Column(name = "userId")
    @NotNull
    private long userId;
    
    @Column(name = "FCMtoken")
    @NotNull
    private String FCMtoken;
    
    public FCMTokenMapping(String fCMtoken, long userId) {
        this.FCMtoken = fCMtoken;
        this.userId = userId;
    }

    public String getFCMtoken() {
        return FCMtoken;
    }

    public void setFCMtoken(String fCMtoken) {
        FCMtoken = fCMtoken;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

}
