package com.version1.finalprojectdashboard.FinalProjectDashboard;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.util.Date;

//Associate table
//Candidate Table
@Entity
public class Candidate {

  //Unique identifier
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name = "candidate_id")
  private int candidateId;

  //Relationship with JobRole_SmartRecruiters table
  @ManyToOne
  @JoinColumn(name = "jobrole_id")
  private JobRole roleApplied;

  @Column
  private String candidate_name;

  @Column
  private String location;

  @Column
  private String education;

  @Column
  private String degree;

  @Column
  private String grade; //num:num

  @Column
  private char gender;

  @Column(name = "visa_status")
  private String visaStatus;

  @Column
  private String profile; //Graduate, Changer, Returner

  @Column(name = "interview_score")
  private int interviewScore; //1-5: 1-2 = rejected 3 = maybe/hired   4-5 = hired

  @Column(name = "rejection_stage")
  private int rejectionStage; //1-6 //1. In Review  2.TIA 3. Interview 4.Assessment Day 5.Offered 6.Hired

  //Constructor generate
  public Candidate() {
  }

  public Candidate(String candidate_name, JobRole roleApplied, String location, String education, String degree, String grade, char gender, String visaStatus, String profile, int interviewScore, int rejectionStage) {
      this.candidate_name = candidate_name;
      this.roleApplied = roleApplied;
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

  //getters and setters
  public int getCandidateId() {
      return candidateId;
  }

  public void setCandidateId(int candidateId) {
      this.candidateId = candidateId;
  }

  public JobRole getRoleApplied() {
      return roleApplied;
  }

  public void setRoleApplied(JobRole roleApplied) {
      this.roleApplied = roleApplied;
  }

  public String getCandidate_name() {
      return candidate_name;
  }

  public void setCandidate_name(String candidate_name) {
      this.candidate_name = candidate_name;
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

  public char getGender() {
      return gender;
  }

  public void setGender(char gender) {
      this.gender = gender;
  }

  public String getVisaStatus() {
      return visaStatus;
  }

  public void setVisaStatus(String visaStatus) {
      this.visaStatus = visaStatus;
  }

  public String getProfile() {
      return profile;
  }

  public void setProfile(String profile) {
      this.profile = profile;
  }

  public int getInterviewScore() {
      return interviewScore;
  }

  public void setInterviewScore(int interviewScore) {
      this.interviewScore = interviewScore;
  }

  public int getRejectionStage() {
      return rejectionStage;
  }

  public void setRejectionStage(int rejectionStage) {
      this.rejectionStage = rejectionStage;
  }

  //toString() methd
  @Override
  public String toString() {
      return "Candidate{" +
              "candidateId=" + candidateId +
              ", location='" + location + '\'' +
              ", education='" + education + '\'' +
              ", degree='" + degree + '\'' +
              ", grade='" + grade + '\'' +
              ", gender=" + gender +
              ", visaStatus='" + visaStatus + '\'' +
              ", profile='" + profile + '\'' +
              ", interviewScore=" + interviewScore +
              ", rejectionStage=" + rejectionStage +
              '}';
  }
}