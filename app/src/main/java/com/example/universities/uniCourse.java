package com.example.universities;

public class uniCourse {

    private String courseName;
    private String courseDuration;
    private String fee;
    private String UNentry;
    private String otherEntry;
    private String facultyWebsite;
    private String url;
    private String admissionDeadline;

    public uniCourse(String courseName, String courseDuration, String fee, String UNentry, String otherEntry, String facultyWebsite, String url, String admissionDeadline) {
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        this.fee = fee;
        this.UNentry = UNentry;
        this.otherEntry = otherEntry;
        this.facultyWebsite = facultyWebsite;
        this.url = url;
        this.admissionDeadline = admissionDeadline;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getUNentry() {
        return UNentry;
    }

    public void setUNentry(String UNentry) {
        this.UNentry = UNentry;
    }

    public String getOtherEntry() {
        return otherEntry;
    }

    public void setOtherEntry(String otherEntry) {
        this.otherEntry = otherEntry;
    }

    public String getFacultyWebsite() {
        return facultyWebsite;
    }

    public void setFacultyWebsite(String facultyWebsite) {
        this.facultyWebsite = facultyWebsite;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAdmissionDeadline() {
        return admissionDeadline;
    }

    public void setAdmissionDeadline(String admissionDeadline) {
        this.admissionDeadline = admissionDeadline;
    }
}
