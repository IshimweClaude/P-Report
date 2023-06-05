package com.report.entity;

import java.util.Date;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="report")
public class Report {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column
	private long report_id;
	@Column
	private String owner_id;
	@Column
	private Date date;
	
		
	public Report() {
	
	}


	public Report(long report_id, String owner_id, Date date) {
		super();
		this.report_id = report_id;
		this.owner_id = owner_id;
		this.date = date;
	}


	public long getReport_id() {
		return report_id;
	}


	public void setReport_id(long report_id) {
		this.report_id = report_id;
	}


	public String getOwner_id() {
		return owner_id;
	}


	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}	
	
}


