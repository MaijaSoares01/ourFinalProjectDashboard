package com.version1.finalprojectdashboard.FinalProjectDashboard;



import jakarta.persistence.*;

@Entity
public class TIA {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "tia_id")
    private int tiaId;

    //candidate id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="candidate_id")
    private Candidate candidate;

    @Column
    private float gia; //45%

    @Column
    private String ppa; //SC

    public TIA() {
    }
    public TIA(Candidate candidate, float gia, String ppa) {
        this.candidate = candidate;
        this.gia = gia;
        this.ppa = ppa;
    }

    public int getTiaId() {
        return tiaId;
    }

    public void setTiaId(int tiaId) {
        this.tiaId = tiaId;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getPpa() {
        return ppa;
    }

    public void setPpa(String ppa) {
        this.ppa = ppa;
    }

    @Override
    public String toString() {
        return "TIA{" +
                "tiaId=" + tiaId +
                ", candidate=" + candidate +
                ", gia=" + gia +
                ", ppa='" + ppa + '\'' +
                '}';
    }
}

