package com.pale.view.model;

import javax.persistence.*;

@Entity
@Table(name = "t_score")
public class Score {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long studentId;
    private String studentName;
    private Long clazzId;
    private String subject;
    private Float score;
    private String testTime;
    private String extraInfo;

    public Score() {
    }

    public Score(Long id, Long studentId, String studentName, Long clazzId, String subject, Float score, String testTime, String extraInfo) {
        this.id = id;
        this.studentId = studentId;
        this.studentName = studentName;
        this.clazzId = clazzId;
        this.subject = subject;
        this.score = score;
        this.testTime = testTime;
        this.extraInfo = extraInfo;
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

    public Long getClazzId() {
        return clazzId;
    }

    public void setClazzId(Long clazzId) {
        this.clazzId = clazzId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getTestTime() {
        return testTime;
    }

    public void setTestTime(String testTime) {
        this.testTime = testTime;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", clazzId=" + clazzId +
                ", subject='" + subject + '\'' +
                ", score=" + score +
                ", testTime='" + testTime + '\'' +
                ", extraInfo='" + extraInfo + '\'' +
                '}';
    }
}
