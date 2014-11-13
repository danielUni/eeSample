package ejb.eeSample.jar.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Cedric Roeck (cedric.roeck@gmail.com) on 12.11.14.
 */
@Entity
@Table(name = "BEVERAGE")
public class BeverageEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "serial")
    private Long id;

    @Version
    private Long version;

    @Column(name="BEVERAGE_NAME")
    private String name;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="MANUFACTURER_ID")
    private ManufacturerEntity manufacture;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="INCENTIVE_ID")
    private IncentiveEntity incentive;

    @Column(name="PRICE")
    private BigDecimal price;

    @Column(name="QUANTITY")
    private BigDecimal quantity;

    public Long getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ManufacturerEntity getManufacture() {
        return manufacture;
    }

    public void setManufacture(ManufacturerEntity manufacture) {
        this.manufacture = manufacture;
    }

    public IncentiveEntity getIncentive() {
        return incentive;
    }

    public void setIncentive(IncentiveEntity incentive) {
        this.incentive = incentive;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

}
