package com.version1.finalprojectdashboard.FinalProjectDashboard;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.util.Date;

import com.version1.finalprojectdashboard.FinalProjectDashboard.enums.Gender;
import com.version1.finalprojectdashboard.FinalProjectDashboard.enums.Profile;
import com.version1.finalprojectdashboard.FinalProjectDashboard.enums.RejectionStage;
import com.version1.finalprojectdashboard.FinalProjectDashboard.enums.VisaStatus;


//Candidate Table
@Entity
public class Candidate {

	// Unique identifier
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "candidate_id")
	private Integer candidateId;

	// Relationship with JobRole_SmartRecruiters table
	@ManyToOne
	@JoinColumn(name = "jobrole_id", nullable = false)
	private JobRole roleApplied;

	@Column(name = "candidate_name", nullable = false)
	private String candidateName;

	@Column(name = "location")
	private String location;

	@Column(name = "education")
	private String education;

	@Column(name = "degree")
	private String degree;

	@Column(name = "grade")
	private String grade; // Consider using a numeric type if appropriate

	//@Enumerated(EnumType.STRING)
	@Column(name = "gender", nullable = false)
	private String gender;

	//@Enumerated(EnumType.STRING)
	@Column(name = "visa_status")
	private String visaStatus;

	//@Enumerated(EnumType.STRING)
	@Column(name = "profile", nullable = false)
	private Profile profile; // Graduate, Changer, Returner

	@Column(name = "interview_score")
	private int interviewScore; // 1-5: 1-2 = rejected, 3 = maybe/hired, 4-5 = hired

	//@Enumerated(EnumType.STRING)
	@Column(name = "rejection_stage", nullable = false)
	private String rejectionStage; // Mapped to enum

	//Constructor generate


	public Candidate() {
	}

	public Candidate(JobRole roleApplied, String candidateName, String location, String education, String degree, String grade, String gender, String visaStatus, Profile profile, int interviewScore, String rejectionStage) {
		//this.candidateId = candidateId;
		this.roleApplied = roleApplied;
		this.candidateName = candidateName;
		this.location = location;
		this.education = education;
		this.degree = degree;
		this.grade = grade;
		this.gender = gender;
		this.visaStatus = visaStatus;
		this.profile = profile;
		this.interviewScore = interviewScore;
		this.rejectionStage = rejectionStage;
	}

	//Getters and Setters

	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}

	public JobRole getRoleApplied() {
		return roleApplied;
	}

	public void setRoleApplied(JobRole roleApplied) {
		this.roleApplied = roleApplied;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getVisaStatus() {
		return visaStatus;
	}

	public void setVisaStatus(String visaStatus) {
		this.visaStatus = visaStatus;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public int getInterviewScore() {
		return interviewScore;
	}

	public void setInterviewScore(int interviewScore) {
		this.interviewScore = interviewScore;
	}

	public String getRejectionStage() {
		return rejectionStage;
	}

	public void setRejectionStage(String rejectionStage) {
		this.rejectionStage = rejectionStage;
	}

// toString() method

	@Override
	public String toString() {
		return "Candidate{" +
				"candidateId=" + candidateId +
				", roleApplied=" + roleApplied +
				", candidateName='" + candidateName + '\'' +
				", location='" + location + '\'' +
				", education='" + education + '\'' +
				", degree='" + degree + '\'' +
				", grade='" + grade + '\'' +
				", gender=" + gender +
				", visaStatus=" + visaStatus +
				", profile=" + profile +
				", interviewScore=" + interviewScore +
				", rejectionStage=" + rejectionStage +
				'}';
	}
}