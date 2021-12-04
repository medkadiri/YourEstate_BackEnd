package EA.HW.data.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Authority")
public class Authority extends BaseEntity {

    //private static final long serialVersionUID = 1L;

    @Column(name = "username")
    @NotNull
    private String username;

    @Column(name = "authority")
    @NotNull
    private String authority;

    protected Authority(){ }

    public Authority(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}