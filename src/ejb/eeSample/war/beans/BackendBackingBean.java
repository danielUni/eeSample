package ejb.eeSample.war.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ejb.eeSample.jar.beans.BackendEJB;
import ejb.eeSample.jar.entities.BeverageEntity;
import ejb.eeSample.jar.entities.GiftIncentiveEntity;
import ejb.eeSample.jar.entities.ManufacturerEntity;
import ejb.eeSample.jar.entities.TrialIncentiveEntity;

@RequestScoped
@Named
public class BackendBackingBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	public BackendBackingBean() {

	}

	@Inject
	private BackendEJB backendEJB;

	// business objects
	private BeverageEntity beverage = new BeverageEntity();
	private List<BeverageEntity> beverages;
	private ManufacturerEntity manufacturer = new ManufacturerEntity();
	// TODO: Check if it's possible to avoid this overhead
	private GiftIncentiveEntity giftIncentive = new GiftIncentiveEntity();
	private TrialIncentiveEntity trailIncentive = new TrialIncentiveEntity();

	// incentive properties
	private String incentiveName;
	private String incentiveType;

	// manufacturer properties
	private String manufacturerName;
	private List<ManufacturerEntity> manufactures;

	// beverage properties

	// initBean
	@PostConstruct
	public void init() {
		this.manufactures = backendEJB.getManufactures();
		this.beverages = backendEJB.queryBeverages();
	}

	// navigation logic
	// TODO: Second Model?
	public String showBeverageForm() {
		return "newBeverage.xhtml";
	}

	public String showManufacturerForm() {
		return "newManufacturer.xhtml";
	}

	public String showIncentiveForm() {
		return "newIncentive.xhtml";
	}

	public String showDashboard() {
		return "welcome.xhtml";
	}

	public String showBeverageOverwiew() {
		return "beverageOverview.xhtml";
	}

	// business logic
	// TODO:NOT POSSIBLE TO ADD BEVERAGE WITHOUT INCENTIVE
	public void addBeverage() {
		backendEJB.addBeverage(beverage);
	}

	public void addIncentive() {
		if (this.incentiveType.equals("Gift")) {
			this.giftIncentive.setName(incentiveName);
			backendEJB.addIncentive(giftIncentive);
		} else {
			this.trailIncentive.setName(incentiveName);
			backendEJB.addIncentive(trailIncentive);
		}
	}

	// Getter and Setter
	// TODO: Provide reasonable setter
	public void addManufacturer() {
		backendEJB.addManufacturer(manufacturer);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BackendEJB getBackendEJB() {
		return backendEJB;
	}

	public void setBackendEJB(BackendEJB backendEJB) {
		this.backendEJB = backendEJB;
	}

	public BeverageEntity getBeverage() {
		return beverage;
	}

	public void setBeverage(BeverageEntity beverage) {
		this.beverage = beverage;
	}

	public ManufacturerEntity getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(ManufacturerEntity manufacturer) {
		this.manufacturer = manufacturer;
	}

	public GiftIncentiveEntity getGiftIncentive() {
		return giftIncentive;
	}

	public void setGiftIncentive(GiftIncentiveEntity giftIncentive) {
		this.giftIncentive = giftIncentive;
	}

	public TrialIncentiveEntity getTrailIncentive() {
		return trailIncentive;
	}

	public void setTrailIncentive(TrialIncentiveEntity trailIncentive) {
		this.trailIncentive = trailIncentive;
	}

	public String getIncentiveName() {
		return incentiveName;
	}

	public void setIncentiveName(String incentiveName) {
		this.incentiveName = incentiveName;
	}

	public String getIncentiveType() {
		return incentiveType;
	}

	public void setIncentiveType(String incentiveType) {
		this.incentiveType = incentiveType;
	}

	// TODO: Implement CONVERTOR for manufacturer
	// TODO: Provide functionality for adding an manufacturer
	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public List<ManufacturerEntity> getManufactures() {
		return manufactures;
	}

	public void setManufactures(List<ManufacturerEntity> manufactures) {
		this.manufactures = manufactures;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<BeverageEntity> getBeverages() {
		return beverages;
	}

	public void setBeverages(List<BeverageEntity> beverages) {
		this.beverages = beverages;
	}
}
