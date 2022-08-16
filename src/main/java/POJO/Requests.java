package POJO;
public class Requests {
    public int request_id;
    public String rqstcateg;
    public String empemail;
    public String essay;
    public int reimsum;
    public int user_id;
    public boolean statusreq;

    public Requests() {
    }

    public Requests(String rqstcateg, String empemail, String essay, int reimsum, boolean statusreq) {
        this.rqstcateg = rqstcateg;
        this.empemail = empemail;
        this.essay = essay;
        this.reimsum = reimsum;
        this.statusreq = statusreq;
    }
    public Requests(int request_id, String rqstcateg, String empemail, String essay, int reimsum,boolean statusreq, int user_id) {
        this.request_id = request_id;
        this.rqstcateg = rqstcateg;
        this.empemail = empemail;
        this.essay = essay;
        this.reimsum = reimsum;
        this.statusreq = statusreq;
        this.user_id = user_id;
    }
    public Requests(int request_id, String rqstcateg, String empemail, String essay, int reimsum, int user_id) {
        this.request_id = request_id;
        this.rqstcateg = rqstcateg;
        this.empemail = empemail;
        this.essay = essay;
        this.reimsum = reimsum;
        this.user_id = user_id;
    }
    public int getRequest_id() {

        return request_id;
    }
    public void setRequest_id(int request_id) {

        this.request_id = request_id;
    }
    public String getRqstcateg() {

        return rqstcateg;
    }

    public void setRqstcateg(String rqstcateg) {

        this.rqstcateg = rqstcateg;
    }

    public String getEssay() {

        return essay;
    }

    public void setEssay(String essay) {

        this.essay = essay;
    }

    public String getEmpemail() {

        return empemail;
    }

    public void setEmpemail(String empemail) {

        this.empemail = empemail;
    }

    public int getReimsum() {

        return reimsum;
    }

    public void setReimsum(int reimsum) {

        this.reimsum = reimsum;
    }
    public int getUser_id() {

        return user_id;
    }

    public void setUser_id(int user_id) {

        this.user_id = user_id;
    }

    public boolean isStatusreq() {

        return statusreq;
    }

    public void setStatusreq(boolean statusreq) {

        this.statusreq = statusreq;
    }
}
