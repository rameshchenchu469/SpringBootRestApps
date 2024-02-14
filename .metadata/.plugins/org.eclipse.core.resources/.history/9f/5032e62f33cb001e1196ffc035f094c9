package com.nt.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

private Integer eno;
private String ename;
private Float sal;
private String[]favColors;
private List<String>studies;
private Set<Long> phNubers;
private Map<String,Object>idDetails;
private Company company;

@Override
public String toString() {
	return "Employee [eno=" + eno + ", ename=" + ename + ", sal=" + sal + ", favColors=" + Arrays.toString(favColors)
			+ ", studies=" + studies + ", phNubers=" + phNubers + ", idDetails=" + idDetails + ", company=" + company
			+ "]";
}

public Employee(Integer eno, String ename, Float sal, String[] favColors, List<String> studies, Set<Long> phNubers,
		Map<String, Object> idDetails, Company company) {
	super();
	this.eno = eno;
	this.ename = ename;
	this.sal = sal;
	this.favColors = favColors;
	this.studies = studies;
	this.phNubers = phNubers;
	this.idDetails = idDetails;
	this.company = company;
}

public Integer getEno() {
	return eno;
}
public void setEno(Integer eno) {
	this.eno = eno;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public Float getSal() {
	return sal;
}
public void setSal(Float sal) {
	this.sal = sal;
}
public String[] getFavColors() {
	return favColors;
}
public void setFavColors(String[] favColors) {
	this.favColors = favColors;
}
public List<String> getStudies() {
	return studies;
}
public void setStudies(List<String> studies) {
	this.studies = studies;
}
public Set<Long> getPhNubers() {
	return phNubers;
}
public void setPhNubers(Set<Long> phNubers) {
	this.phNubers = phNubers;
}
public Map<String, Object> getIdDetails() {
	return idDetails;
}
public void setIdDetails(Map<String, Object> idDetails) {
	this.idDetails = idDetails;
}
public Company getCompany() {
	return company;
}
public void setCompany(Company company) {
	this.company = company;
}

}
