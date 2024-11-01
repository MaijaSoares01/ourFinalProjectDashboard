package com.version1.finalprojectdashboard.FinalProjectDashboard;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Associate {
    //Attributes
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "associate_id")
    private int associateId;

    //Relationship with Candidate Table
    @OneToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @Column
    private char gender;

    @Column
    private Date dob;

    @Column
    private String nationality;

    @Column
    private String visa;

    @Column
    private String portfolio;

    @Column
    private String division;

    @Column
    private String department;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "line_manager")
    private String lineManager;

    @Column(name = "cpd_level")
    private int cpdLevel;

    @Column(name = "cpd_stage")
    private String cpdStage; //early, mid, late

    @Column
    private String academy;

    @Column(name = "six_month_uplift")
    private Date sixMonthUplift;

    @Column(name = "twelve_month_uplift")
    private Date twelveMonthUplift;

    @Column(name = "eighteen_month_uplift")
    private Date eighteenMonthUplift;

    @Column(name = "greenline_ratings")
    private char greenlineRatings; //made it char because there's a C value: 2-5, C

    @Column(name = "leaving_reason")
    private String leavingReason;

    //timesheet id
    //@OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name="timesheet_id")
    //private Timesheet timesheet;

    public Associate() {
    }

    public Associate(Candidate candidate, char gender, Date dob, String nationality, String visa, String portfolio, String division, String department, String jobTitle, String lineManager, int cpdLevel, String cpdStage, String academy, Date sixMonthUplift, Date twelveMonthUplift, Date eighteenMonthUplift, char greenlineRatings, String leavingReason) {
        //this.candidate = candidate;
        this.gender = gender;
        this.dob = dob;
        this.nationality = nationality;
        this.visa = visa;
        this.portfolio = portfolio;
        this.division = division;
        this.department = department;
        this.jobTitle = jobTitle;
        this.lineManager = lineManager;
        this.cpdLevel = cpdLevel;
        this.cpdStage = cpdStage;
        this.academy = academy;
        this.sixMonthUplift = sixMonthUplift;
        this.twelveMonthUplift = twelveMonthUplift;
        this.eighteenMonthUplift = eighteenMonthUplift;
        this.greenlineRatings = greenlineRatings;
        this.leavingReason = leavingReason;
    }

    public int getAssociateId() {
        return associateId;
    }

    public void setAssociateId(int associateId) {
        this.associateId = associateId;
    }

    //public Candidate getCandidate() {
       // return candidate;
    //}

    //public void setCandidate(Candidate candidate) {
        //this.candidate = candidate;
    //}

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getVisa() {
        return visa;
    }

    public void setVisa(String visa) {
        this.visa = visa;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLineManager() {
        return lineManager;
    }

    public void setLineManager(String lineManager) {
        this.lineManager = lineManager;
    }

    public int getCpdLevel() {
        return cpdLevel;
    }

    public void setCpdLevel(int cpdLevel) {
        this.cpdLevel = cpdLevel;
    }

    public String getCpdStage() {
        return cpdStage;
    }

    public void setCpdStage(String cpdStage) {
        this.cpdStage = cpdStage;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public Date getSixMonthUplift() {
        return sixMonthUplift;
    }

    public void setSixMonthUplift(Date sixMonthUplift) {
        this.sixMonthUplift = sixMonthUplift;
    }

    public Date getTwelveMonthUplift() {
        return twelveMonthUplift;
    }

    public void setTwelveMonthUplift(Date twelveMonthUplift) {
        this.twelveMonthUplift = twelveMonthUplift;
    }

    public Date getEighteenMonthUplift() {
        return eighteenMonthUplift;
    }

    public void setEighteenMonthUplift(Date eighteenMonthUplift) {
        this.eighteenMonthUplift = eighteenMonthUplift;
    }

    public char getGreenlineRatings() {
        return greenlineRatings;
    }

    public void setGreenlineRatings(char greenlineRatings) {
        this.greenlineRatings = greenlineRatings;
    }

    public String getLeavingReason() {
        return leavingReason;
    }

    public void setLeavingReason(String leavingReason) {
        this.leavingReason = leavingReason;
    }

    @Override
    public String toString() {
        return "Associate{" +
                "associateId=" + associateId +
                ", associateId='" + associateId + '\'' +
                ", gender=" + gender +
                ", dob=" + dob +
                ", nationality='" + nationality + '\'' +
                ", visa='" + visa + '\'' +
                ", portfolio='" + portfolio + '\'' +
                ", division='" + division + '\'' +
                ", department='" + department + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", lineManager='" + lineManager + '\'' +
                ", cpdLevel=" + cpdLevel +
                ", cpdStage='" + cpdStage + '\'' +
                ", academy='" + academy + '\'' +
                ", sixMonthUplift=" + sixMonthUplift +
                ", twelveMonthUplift=" + twelveMonthUplift +
                ", eighteenMonthUplift=" + eighteenMonthUplift +
                ", greenlineRatings=" + greenlineRatings +
                ", leavingReason='" + leavingReason + '\'' +
                '}';
    }


}
