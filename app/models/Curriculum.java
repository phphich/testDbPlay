package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 13/6/2561.
 */
@Entity
@Table(name="tbCurriculum")
public class Curriculum extends Model{
    @Id
    @Column(length=13)
    private String cuId;
    //@Constraints.Required
    //@Lob
    private String nameTh, nameEn, shortName, status;
    private int year;
    private String director;
    private Date academicApprove, councilApprove, high_eduApprove;
    private String department, faculty, university;
    private String place;

    public Curriculum() {
    }

    public Curriculum(String cuId, String nameTh, String nameEn, String shortName, String status, int year, String director, Date academicApprove, Date councilApprove, Date high_eduApprove, String department, String faculty, String university, String place) {
        this.cuId = cuId;
        this.nameTh = nameTh;
        this.nameEn = nameEn;
        this.shortName = shortName;
        this.status = status;
        this.year = year;
        this.director=director;
        this.academicApprove = academicApprove;
        this.councilApprove = councilApprove;
        this.high_eduApprove = high_eduApprove;
        this.department = department;
        this.faculty = faculty;
        this.university = university;
        this.place=place;
    }

    public String getCuId() {
        return cuId;
    }

    public void setCuId(String cuId) {
        this.cuId = cuId;
    }

    public String getNameTh() {
        return nameTh;
    }

    public void setNameTh(String nameTh) {
        this.nameTh = nameTh;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Date getAcademicApprove() {
        return academicApprove;
    }

    public void setAcademicApprove(Date academicApprove) {
        this.academicApprove = academicApprove;
    }

    public Date getCouncilApprove() {
        return councilApprove;
    }

    public void setCouncilApprove(Date councilApprove) {
        this.councilApprove = councilApprove;
    }

    public Date getHigh_eduApprove() {
        return high_eduApprove;
    }

    public void setHigh_eduApprove(Date high_eduApprove) {
        this.high_eduApprove = high_eduApprove;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    // Curriculum DB Management
    public static void create(Curriculum curriculum){
        Random rand = new Random();
        String newCuId;
        Curriculum duplicate=null;
        do {
            newCuId = Integer.toString(rand.nextInt(100) + 1);
            duplicate= Curriculum.find.byId(newCuId);
        }
        while(duplicate!=null);
        curriculum.setCuId(newCuId);
        curriculum.save();
    }
    public static void update(Curriculum curriculum){
        curriculum.update();
    }

    public static void delete(Curriculum curriculum){
        curriculum.delete();
    }

    // Curriculum DB Find
    public static Finder<String, Curriculum> find= new Finder<String, Curriculum>(String.class, Curriculum.class);
    public static List<Curriculum> list() {
        return find.all();
    }
}
