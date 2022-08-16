package DAO;
import POJO.Requests;
import SERVICES.DataSourceService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class RequestsDAO implements DataSourceCRUD<Requests>{
    Connection connection;

    public RequestsDAO(){
        connection = DataSourceService.getConnection();
    }

    @Override
    public void create(Requests requests) {
        try {
            String sql = "INSERT INTO requests (rqstcateg, empemail, essay, reimsum, statusreq, user_id) VALUES (?, ?, ?, ?,'false', ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            System.out.println("Connection to Request Table made");

            pstmt.setString(1, requests.getRqstcateg());
            pstmt.setString(2, requests.getEmpemail());
            pstmt.setString(3, requests.getEssay());
            pstmt.setInt(4, requests.getReimsum());
            pstmt.setInt(5, requests.getUser_id());
            pstmt.executeUpdate();
            System.out.println("Request Creation Done in Table");
            ResultSet keys = pstmt.getGeneratedKeys();
            if(keys.next()) {
                Integer key = keys.getInt("request_id");
                System.out.println("Key=" + key);
            } else {
                System.out.println("unable to locate request_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Requests read(int id) {
        Requests requests = new Requests();
        try {
            String sql = "SELECT * FROM requests WHERE request_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);

            ResultSet results = pstmt.executeQuery();

            if(results.next()) {
                requests.setRequest_id(results.getInt("request_id"));
                requests.setRqstcateg(results.getString("rqstcateg"));
                requests.setEmpemail(results.getString("empemail"));
                requests.setEssay(results.getString("essay"));
                requests.setReimsum(results.getInt("reimsum"));
                requests.setStatusreq(results.getBoolean("statusreq"));
                requests.setUser_id(results.getInt("user_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }
    @Override
    public List<Requests> readAll() {
        List<Requests> requestsList = new LinkedList<>();
        try {
            String sql = "SELECT * FROM requests";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            ResultSet results = pstmt.executeQuery();

            while(results.next()) {
                Requests requests = new Requests();
                requests.setRequest_id(results.getInt("request_id"));
                requests.setRqstcateg(results.getString("rqstcateg"));
                requests.setEmpemail(results.getString("empemail"));
                requests.setEssay(results.getString("essay"));
                requests.setReimsum(results.getInt("reimsum"));
                requests.setStatusreq(results.getBoolean("statusreq"));
                requests.setUser_id(results.getInt("user_id"));
                requestsList.add(requests);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requestsList;
    }
    @Override
    public void update(Requests requests) {
        try {
            String sql = "UPDATE requests SET rqstcateg = ?, empemail = ?, essay = ?, reimsum = ?, statusreq = ?, WHERE request_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, requests.getRqstcateg());
            pstmt.setString(2, requests.getEmpemail());
            pstmt.setString(3, requests.getEssay());
            pstmt.setInt(4, requests.getReimsum());
            pstmt.setBoolean(5, requests.isStatusreq());
            pstmt.setInt(6, requests.getRequest_id());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM Requests WHERE request_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, id);

            pstmt.executeUpdate();

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
