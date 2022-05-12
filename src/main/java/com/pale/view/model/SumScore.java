package com.pale.view.model;

import javax.persistence.*;

@Entity
@Table(name = "t_sum_score")
public class SumScore {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long studentId;
    private String studentName;
    private String testTime;
    private Long classId;
    private Float sumScore;

    public SumScore() {
    }

    public SumScore(Long id, Long studentId, String studentName, String testTime, Long classId, Float sumScore) {
        this.id = id;
        this.studentId = studentId;
        this.studentName = studentName;
        this.testTime = testTime;
        this.classId = classId;
        this.sumScore = sumScore;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getTestTime() {
        return testTime;
    }

    public void setTestTime(String testTime) {
        this.testTime = testTime;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Float getSumScore() {
        return sumScore;
    }

    public void setSumScore(Float sumScore) {
        this.sumScore = sumScore;
    }

    @Override
    public String toString() {
        return "SumScore{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", testTime='" + testTime + '\'' +
                ", classId=" + classId +
                ", sumScore=" + sumScore +
                '}';
    }
}
