package ejb.eeSample.jar.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Cedric Roeck (cedric.roeck@gmail.com) on 12.11.14.
 */
@Entity
@Table(name = "SHOP_ORDER")
public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "serial")
    private Long id;

    @Version
    private Long version;

    @Column(name = "ISSUE_DATE", columnDefinition = "timestamp", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date issueDate;

    @OneToMany
    @JoinTable(
            name="BEVERAGES",
            joinColumns = @JoinColumn( name="SHOP_ORDER_ID"),
            inverseJoinColumns = @JoinColumn( name="BEVERAGE_ID")
    )
    private List<BeverageEntity> orderedBeverages;

    @PrePersist
    protected void onCreate() {
        System.out.println("update TS");
        issueDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public List<BeverageEntity> getOrderedBeverages() {
        return orderedBeverages;
    }

    public void setOrderedBeverages(List<BeverageEntity> orderedBeverages) {
        this.orderedBeverages = orderedBeverages;
    }

}
