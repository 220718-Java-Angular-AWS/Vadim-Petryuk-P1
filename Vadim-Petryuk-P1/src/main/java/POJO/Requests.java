package POJO;
public class Requests {
    public int requestId;
    public String rqstcateg;
    public String empemail;
    public String essay;
    public int reimsum;
    public int userId;
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
    public Requests(int requestId, String rqstcateg, String empemail, String essay, int reimsum, boolean statusreq, int userId) {
        this.requestId = requestId;
        this.rqstcateg = rqstcateg;
        this.empemail = empemail;
        this.essay = essay;
        this.reimsum = reimsum;
        this.statusreq = statusreq;
        this.userId = userId;
    }
    public Requests(int requestId, String rqstcateg, String empemail, String essay, int reimsum, int userId) {
        this.requestId = requestId;
        this.rqstcateg = rqstcateg;
        this.empemail = empemail;
        this.essay = essay;
        this.reimsum = reimsum;
        this.userId = userId;
    }
    public int getRequestId() {

        return requestId;
    }
    public void setRequestId(int requestId) {

        this.requestId = requestId;
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
    public int getUserId() {

        return userId;
    }

    public void setUserId(int userId) {

        this.userId = userId;
    }

    public boolean isStatusreq() {

        return statusreq;
    }

    public void setStatusreq(boolean statusreq) {

        this.statusreq = statusreq;
    }
}
