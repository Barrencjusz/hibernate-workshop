package org.perform.hibernate.model;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class Contract {

	private Integer salary;

	@Temporal(TemporalType.DATE)
	private Date beginDate;
	
	@Temporal(TemporalType.DATE)
	private Date endDate;

	public Contract() {

	}

	public Contract(Integer salary, Date beginDate, Date endDate) {
		this.salary = salary;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
