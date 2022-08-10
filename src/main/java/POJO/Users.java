package POJO;
public class Users {
    public int user_id;
    public String fname;
    public String lname;
    public String empemail;
    public String emposition;
    private String emppass;
    public int monthsemployed;
    private boolean admincheck;


    public Users() {
    }

    public Users(String fname, String lname, String empemail, String emposition, String emppass, int monthsemployed, boolean admincheck) {
        this.fname = fname;
        this.lname = lname;
        this.empemail = empemail;
        this.emposition = emposition;
        this.emppass = emppass;
        this.monthsemployed = monthsemployed;
        this.admincheck = admincheck;
    }

    public Users(int user_id, String fname, String lname, String empemail, String emposition, String emppass, int monthsemployed, boolean admincheck) {
        this.user_id = user_id;
        this.fname = fname;
        this.lname = lname;
        this.empemail = empemail;
        this.emposition = emposition;
        this.emppass = emppass;
        this.monthsemployed = monthsemployed;
        this.admincheck = admincheck;

    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmpemail() {
        return empemail;
    }

    public void setEmpemail(String empemail) {
        this.empemail = empemail;
    }

    public String getEmppass() {
        return emppass;
    }

    public void setEmppass(String emppass) {
        this.emppass = emppass;
    }

    public String getEmposition() {
        return emposition;
    }

    public void setEmposition(String emposition) {
        this.emposition = emposition;
    }

    public int getMonthsemployed() {
        return monthsemployed;
    }

    public void setMonthsemployed(int monthsemployed) {
        this.monthsemployed = monthsemployed;
    }

    public boolean isAdmincheck() {
        return admincheck;
    }

    public void setAdmincheck(boolean admincheck) {
        this.admincheck = admincheck;
    }
}

