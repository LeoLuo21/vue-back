package com.pale.view.model;

import javax.persistence.*;

@Entity
@Table(name = "t_clazz_schedule")
public class ClazzSchedule {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Long clazzId;

    private Long teacherId;

    private String subject;

    private String classroom;

    private String time;

    private String term;

    public ClazzSchedule() {
    }

    public ClazzSchedule(Long id, Long clazzId, Long teacherId, String subject, String classroom, String time, String term) {
        this.id = id;
        this.clazzId = clazzId;
        this.teacherId = teacherId;
        this.subject = subject;
        this.classroom = classroom;
        this.time = time;
        this.term = term;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "ClazzSchedule{" +
                "id=" + id +
                ", clazzId=" + clazzId +
                ", teacherId=" + teacherId +
                ", subject='" + subject + '\'' +
                ", classroom='" + classroom + '\'' +
                ", time='" + time + '\'' +
                ", term='" + term + '\'' +
                '}';
    }
}
