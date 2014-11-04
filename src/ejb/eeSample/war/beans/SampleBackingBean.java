package ejb.eeSample.war.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import ejb.eeSample.jar.beans.SampleEJB;
import ejb.eeSample.jar.entities.Visitor;

@ManagedBean
@SessionScoped
@Named
public class SampleBackingBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	public SampleBackingBean() {

	}

	@Inject
	private SampleEJB userEJB;
	private Visitor user = new Visitor();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String createNewUser() {

		userEJB.createUser(user);
		//
		// FacesContext.getCurrentInstance()
		// .addMessage(
		// null,
		// new FacesMessage(FacesMessage.SEVERITY_INFO,
		// "USER created", "The User " + user.getName()
		// + " has been created with id= "
		// + user.getId()));

		return "welcome.xhtml";
	}

	// public SampleEJB getUserEJB() {
	// return userEJB;
	// }
	//
	// public void setUserEJB(SampleEJB userEJB) {
	// this.userEJB = userEJB;
	// }
	//
	// public User getUser() {
	// return user;
	// }
	//
	// public void setUser(User user) {
	// this.user = user;
	// }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
