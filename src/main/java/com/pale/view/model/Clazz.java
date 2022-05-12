package com.pale.view.model;

import javax.persistence.*;

@Entity
@Table(name = "t_clazz")
public class Clazz {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String classroomNo;
	private String headMaster;
	private Long grade;

	public Clazz() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassroomNo() {
		return classroomNo;
	}

	public void setClassroomNo(String classroomNo) {
		this.classroomNo = classroomNo;
	}

	public String getHeadMaster() {
		return headMaster;
	}

	public void setHeadMaster(String headMaster) {
		this.headMaster = headMaster;
	}

	public Long getGrade() {
		return grade;
	}

	public void setGrade(Long grade) {
		this.grade = grade;
	}

	public Long getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(Long totalNumber) {
		this.totalNumber = totalNumber;
	}

	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

	private Long totalNumber;
	private String extraInfo;

	@Override
	public String toString() {
		return "Clazz{" +
				"id=" + id +
				", classroomNo='" + classroomNo + '\'' +
				", headMaster='" + headMaster + '\'' +
				", grade=" + grade +
				", totalNumber=" + totalNumber +
				", extraInfo='" + extraInfo + '\'' +
				'}';
	}
}
