package ejb.eeSample.war.beans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import ejb.eeSample.jar.beans.VisitorEJB;
import ejb.eeSample.jar.entities.Visitor;

//@ManagedBean
@RequestScoped
@Named
public class VisitorBackingBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	public VisitorBackingBean() {

	}

	@Inject
	private VisitorEJB visitorEJB;
	private Visitor visitor = new Visitor();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String welcomeVisitor() {

		visitorEJB.createUser(visitor);

		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "USER created",
						"The User " + visitor.getName()
								+ " has been created with id= "
								+ visitor.getId()));

		return "welcome.xhtml";
	}

	public VisitorEJB getUserEJB() {
		return visitorEJB;
	}

	public void setUserEJB(VisitorEJB userEJB) {
		this.visitorEJB = userEJB;
	}

	public Visitor getVisitor() {
		return visitor;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
