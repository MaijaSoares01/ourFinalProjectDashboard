package com.version1.finalprojectdashboard.FinalProjectDashboard;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//JobRole (SmartRecruiters table)
@Entity
public class JobRole {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "jobrole_id")
    private int jobRoleId;

    @Column(name = "jobrole_name")
    private String jobRoleName;

    @Column(name = "num_applications")
    private int numApplications;

    //Sources
    @Column(name = "source_paid")
    private int numSourcePaid;

    @Column(name = "source_crm")
    private int numSourceCRM;

    @Column(name = "source_referral")
    private int numSourceReferral;

    @Column(name = "source_organic")
    private int numSourceOrganic;

    @Column(name = "source_agency")
    private int numSourceAgency;

    @Column(name = "source_other")
    private int numSourceOther;

    //Number of applications
    @Column(name = "num_interviews")
    private int numInterviews;

    @Column(name = "num_rejected")
    private int numRejected;

    //Constructor
    public JobRole() {
    }

    public JobRole(String jobRoleName, int numApplications, int numSourcePaid, int numSourceCRM, int numSourceReferral, int numSourceOrganic, int numSourceAgency, int numSourceOther, int numInterviews, int numRejected) {
        this.jobRoleName = jobRoleName;
        this.numApplications = numApplications;
        this.numSourcePaid = numSourcePaid;
        this.numSourceCRM = numSourceCRM;
        this.numSourceReferral = numSourceReferral;
        this.numSourceOrganic = numSourceOrganic;
        this.numSourceAgency = numSourceAgency;
        this.numSourceOther = numSourceOther;
        this.numInterviews = numInterviews;
        this.numRejected = numRejected;
    }

    //getters and setters
    public int getJobRoleId() {
        return jobRoleId;
    }

    public void setJobRoleId(int jobRoleId) {
        this.jobRoleId = jobRoleId;
    }

    public String getJobRoleName() {
        return jobRoleName;
    }

    public void setJobRoleName(String jobRoleName) {
        this.jobRoleName = jobRoleName;
    }

    public int getNumApplications() {
        return numApplications;
    }

    public void setNumApplications(int numApplications) {
        this.numApplications = numApplications;
    }

    public int getNumSourcePaid() {
        return numSourcePaid;
    }

    public void setNumSourcePaid(int numSourcePaid) {
        this.numSourcePaid = numSourcePaid;
    }

    public int getNumSourceCRM() {
        return numSourceCRM;
    }

    public void setNumSourceCRM(int numSourceCRM) {
        this.numSourceCRM = numSourceCRM;
    }

    public int getNumSourceReferral() {
        return numSourceReferral;
    }

    public void setNumSourceReferral(int numSourceReferral) {
        this.numSourceReferral = numSourceReferral;
    }

    public int getNumSourceOrganic() {
        return numSourceOrganic;
    }

    public void setNumSourceOrganic(int numSourceOrganic) {
        this.numSourceOrganic = numSourceOrganic;
    }

    public int getNumSourceAgency() {
        return numSourceAgency;
    }

    public void setNumSourceAgency(int numSourceAgency) {
        this.numSourceAgency = numSourceAgency;
    }

    public int getNumSourceOther() {
        return numSourceOther;
    }

    public void setNumSourceOther(int numSourceOther) {
        this.numSourceOther = numSourceOther;
    }

    public int getNumInterviews() {
        return numInterviews;
    }

    public void setNumInterviews(int numInterviews) {
        this.numInterviews = numInterviews;
    }

    public int getNumRejected() {
        return numRejected;
    }

    public void setNumRejected(int numRejected) {
        this.numRejected = numRejected;
    }

    //toString() method
    @Override
    public String toString() {
        return "JobRole{" +
                "jobRoleId=" + jobRoleId +
                ", jobRoleName='" + jobRoleName + '\'' +
                ", numApplications=" + numApplications +
                ", numSourcePaid=" + numSourcePaid +
                ", numSourceCRM=" + numSourceCRM +
                ", numSourceReferral=" + numSourceReferral +
                ", numSourceOrganic=" + numSourceOrganic +
                ", numSourceAgency=" + numSourceAgency +
                ", numSourceOther=" + numSourceOther +
                ", numInterviews=" + numInterviews +
                ", numRejected=" + numRejected +
                '}';
    }
}