package DAO;
import POJO.Users;
import SERVICES.DataSourceService;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UsersDAO implements DataSourceCRUD<Users>{
    Connection connection;

    public UsersDAO(){
        connection = DataSourceService.getConnection();
    }

    @Override
    public void create(Users users) {
        try {
            String sql = "INSERT INTO users (fname, lname, empemail, emposition, emppass, monthsemployed, admincheck) VALUES (?, ?, ?, ?, ?, ?, 'false')";
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, users.getFname());
            pstmt.setString(2, users.getLname());
            pstmt.setString(3, users.getEmpemail());
            pstmt.setString(4, users.getEmposition());
            pstmt.setString(5, users.getEmppass());
            pstmt.setInt(6, users.getMonthsemployed());
            pstmt.executeUpdate();
            ResultSet keys = pstmt.getGeneratedKeys();
            if(keys.next()) {
                Integer key = keys.getInt("user_id");
                System.out.println("Key=" + key);
            } else {
                System.out.println("unable to locate user_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Users read(int id) {
        Users users = new Users();
        try {
            String sql = "SELECT * FROM users WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet results = pstmt.executeQuery();

            if(results.next()) {
                users.setUser_id(results.getInt("user_id"));
                users.setFname(results.getString("fname"));
                users.setLname(results.getString("lname"));
                users.setEmpemail(results.getString("empemail"));
                users.setEmposition(results.getString("emposition"));
                users.setEmppass(results.getString("emppass"));
                users.setMonthsemployed(results.getInt("monthsemployed"));
                users.setAdmincheck(results.getBoolean("admincheck"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    @Override
    public List<Users> readAll() {
        List<Users> usersList = new LinkedList<>();
        try {
            String sql = "SELECT * FROM users";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet results = pstmt.executeQuery();

            while(results.next()) {
                Users users = new Users();

                users.setUser_id(results.getInt("user_id"));
                users.setFname(results.getString("fname"));
                users.setLname(results.getString("lname"));
                users.setEmpemail(results.getString("empemail"));
                users.setEmposition(results.getString("emposition"));
                users.setEmppass(results.getString("emppass"));
                users.setUser_id(results.getInt("monthsemployed"));
                users.setAdmincheck(results.getBoolean("admincheck"));
                usersList.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }
    @Override
    public void update(Users users) {

        try {
            String sql = "UPDATE users SET fname = ?, lname = ?, empemail = ?, emposition = ?, emppass = ?, monthsemployed = ?, WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, users.getFname());
            pstmt.setString(2, users.getLname());
            pstmt.setString(3, users.getEmpemail());
            pstmt.setString(4, users.getEmposition());
            pstmt.setString(5, users.getEmppass());
            pstmt.setInt(6, users.getMonthsemployed());
            pstmt.setBoolean(7, users.isAdmincheck());
            pstmt.setInt(8, users.getUser_id());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FROM users WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}