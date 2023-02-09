package models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String updatedUser;
	
	@Transient
	public abstract Long getId();
	
	@Column(name = "USER_UPDATED_USER", nullable = false)
	public String getUpdatedUser() {
		return updatedUser;
	}
	
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}
}
