package data.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "lectures")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;
    private String name;
    private double credits;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @Transient
    private static int counter;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public static int getCounter() {
        return counter;
    }

    public Lecture(){
        counter++;
    }

    public Lecture(String name, double credits, Date date, Teacher teacher) {
        this.name = name;
        this.credits = credits;
        this.date = date;
        this.teacher = teacher;
        counter++;
    }

}