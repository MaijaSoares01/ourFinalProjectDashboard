package com.version1.finalprojectdashboard.FinalProjectDashboard;

import jakarta.persistence.*;

@Entity
public class Timesheet {

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name = "timesheet_id")
        private int timesheetId;

        //associate id
        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name="associate_id")
        private Associate associate;

        //2023
        @Column(name="jan_2023")
        private float january2023;

        @Column(name="feb_2023")
        private float february2023;

        @Column(name="mar_2023")
        private float march2023;

        @Column(name="apr_2023")
        private float april2023;

        @Column(name="may_2023")
        private float may2023;

        @Column(name="jun_2023")
        private float june2023;

        @Column(name="jul_2023")
        private float july2023;

        @Column(name="aug_2023")
        private float august2023;

        @Column(name="sep_2023")
        private float september2023;

        @Column(name="oct_2023")
        private float october2023;

        @Column(name="nov_2023")
        private float november2023;

        @Column(name="dec_2023")
        private float december2023;

        //2024
        @Column(name="jan_2024")
        private float january2024;

        @Column(name="feb_2024")
        private float february2024;

        @Column(name="mar_2024")
        private float march2024;

        @Column(name="apr_2024")
        private float april2024;

        @Column(name="may_2024")
        private float may2024;

        @Column(name="jun_2024")
        private float june2024;

        @Column(name="jul_2024")
        private float july2024;

        @Column(name="aug_2024")
        private float august2024;

        public Timesheet() {

        }

        public Timesheet(Associate associate, float january2023, float february2023, float march2023, float april2023, float may2023, float june2023, float july2023, float august2023, float september2023, float october2023, float november2023, float december2023, float january2024, float february2024, float march2024, float april2024, float may2024, float june2024, float july2024, float august2024) {
            this.associate = associate;
            this.january2023 = january2023;
            this.february2023 = february2023;
            this.march2023 = march2023;
            this.april2023 = april2023;
            this.may2023 = may2023;
            this.june2023 = june2023;
            this.july2023 = july2023;
            this.august2023 = august2023;
            this.september2023 = september2023;
            this.october2023 = october2023;
            this.november2023 = november2023;
            this.december2023 = december2023;
            this.january2024 = january2024;
            this.february2024 = february2024;
            this.march2024 = march2024;
            this.april2024 = april2024;
            this.may2024 = may2024;
            this.june2024 = june2024;
            this.july2024 = july2024;
            this.august2024 = august2024;
        }

        public int getTimesheetId() {
            return timesheetId;
        }

        public void setTimesheetId(int timesheetId) {
            this.timesheetId = timesheetId;
        }

        public Associate getAssociate() {
            return associate;
        }

        public void setAssociate(Associate associate) {
            this.associate = associate;
        }

        public float getJanuary2023() {
            return january2023;
        }

        public void setJanuary2023(float january2023) {
            this.january2023 = january2023;
        }

        public float getFebruary2023() {
            return february2023;
        }

        public void setFebruary2023(float february2023) {
            this.february2023 = february2023;
        }

        public float getMarch2023() {
            return march2023;
        }

        public void setMarch2023(float march2023) {
            this.march2023 = march2023;
        }

        public float getApril2023() {
            return april2023;
        }

        public void setApril2023(float april2023) {
            this.april2023 = april2023;
        }

        public float getMay2023() {
            return may2023;
        }

        public void setMay2023(float may2023) {
            this.may2023 = may2023;
        }

        public float getJune2023() {
            return june2023;
        }

        public void setJune2023(float june2023) {
            this.june2023 = june2023;
        }

        public float getJuly2023() {
            return july2023;
        }

        public void setJuly2023(float july2023) {
            this.july2023 = july2023;
        }

        public float getAugust2023() {
            return august2023;
        }

        public void setAugust2023(float august2023) {
            this.august2023 = august2023;
        }

        public float getSeptember2023() {
            return september2023;
        }

        public void setSeptember2023(float september2023) {
            this.september2023 = september2023;
        }

        public float getOctober2023() {
            return october2023;
        }

        public void setOctober2023(float october2023) {
            this.october2023 = october2023;
        }

        public float getNovember2023() {
            return november2023;
        }

        public void setNovember2023(float november2023) {
            this.november2023 = november2023;
        }

        public float getDecember2023() {
            return december2023;
        }

        public void setDecember2023(float december2023) {
            this.december2023 = december2023;
        }

        public float getJanuary2024() {
            return january2024;
        }

        public void setJanuary2024(float january2024) {
            this.january2024 = january2024;
        }

        public float getFebruary2024() {
            return february2024;
        }

        public void setFebruary2024(float february2024) {
            this.february2024 = february2024;
        }

        public float getMarch2024() {
            return march2024;
        }

        public void setMarch2024(float march2024) {
            this.march2024 = march2024;
        }

        public float getApril2024() {
            return april2024;
        }

        public void setApril2024(float april2024) {
            this.april2024 = april2024;
        }

        public float getMay2024() {
            return may2024;
        }

        public void setMay2024(float may2024) {
            this.may2024 = may2024;
        }

        public float getJune2024() {
            return june2024;
        }

        public void setJune2024(float june2024) {
            this.june2024 = june2024;
        }

        public float getJuly2024() {
            return july2024;
        }

        public void setJuly2024(float july2024) {
            this.july2024 = july2024;
        }

        public float getAugust2024() {
            return august2024;
        }

        public void setAugust2024(float august2024) {
            this.august2024 = august2024;
        }

        @Override
        public String toString() {
            return "Timesheet{" +
                    "timesheetId=" + timesheetId +
                    ", associate=" + associate +
                    ", january2023=" + january2023 +
                    ", february2023=" + february2023 +
                    ", march2023=" + march2023 +
                    ", april2023=" + april2023 +
                    ", may2023=" + may2023 +
                    ", june2023=" + june2023 +
                    ", july2023=" + july2023 +
                    ", august2023=" + august2023 +
                    ", september2023=" + september2023 +
                    ", october2023=" + october2023 +
                    ", november2023=" + november2023 +
                    ", december2023=" + december2023 +
                    ", january2024=" + january2024 +
                    ", february2024=" + february2024 +
                    ", march2024=" + march2024 +
                    ", april2024=" + april2024 +
                    ", may2024=" + may2024 +
                    ", june2024=" + june2024 +
                    ", july2024=" + july2024 +
                    ", august2024=" + august2024 +
                    '}';
        }
}
