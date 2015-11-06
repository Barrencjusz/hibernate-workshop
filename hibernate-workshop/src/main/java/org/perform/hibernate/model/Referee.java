package org.perform.hibernate.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Referee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	private String name;

	@Embedded
	private Contract firstContract;
	
	/*@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "salary", column = @Column(name = "SC_SALARY") ),
			@AttributeOverride(name = "beginDate", column = @Column(name = "SC_BEGIN_DATE") ),
			@AttributeOverride(name = "endDate", column = @Column(name = "SC_END_DATE") ), })
	private Contract secondContract;
*/
	public Contract getFirstContract() {
		return firstContract;
	}

	public void setFirstContract(Contract firstContract) {
		this.firstContract = firstContract;
	}

	/*public Contract getSecondContract() {
		return secondContract;
	}

	public void setSecondContract(Contract secondContract) {
		this.secondContract = secondContract;
	}*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
