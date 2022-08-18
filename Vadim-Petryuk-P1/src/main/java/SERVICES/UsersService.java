package SERVICES;
import DAO.UsersDAO;
import POJO.Users;
import java.util.List;
public class UsersService {
    private UsersDAO dao;

    public UsersService() {
        this.dao = new UsersDAO();
    }

    public void saveUsers(Users users) {
        dao.create(users);
    }
    public Users getUsers(int id) {
        return dao.read(id);
    }

    public List<Users> getAllUsers() {
        return dao.readAll();
    }

    public void updateUsers(Users users, Integer userId) {
       System.out.println("this is the service method" + userId);
        dao.update(users, userId);
    }

    public void deleteUsers(int id) {
        dao.delete(id);
    }
    public Users logIn(String empemail, String emppass) {
        return dao.logInUsername(empemail, emppass);
    }
}