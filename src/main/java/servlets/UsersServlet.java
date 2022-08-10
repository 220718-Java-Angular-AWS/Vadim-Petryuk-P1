package servlets;
import POJO.Users;
import SERVICES.UsersService;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class UsersServlet extends HttpServlet {
    UsersService service;
    ObjectMapper mapper;


    @Override
    public void init() throws ServletException {
        System.out.println("User servlet initializing...");
        this.service = new UsersService();
        this.mapper = new ObjectMapper();
        System.out.println("User servlet initialized!");
    }

    @Override
    public void destroy() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("user-id");
        if(param == null) {
            //Return all
            List<Users> userList = service.getAllUsers();
            String json = mapper.writeValueAsString(userList);
            resp.getWriter().println(json);
        } else {
            Integer userId = Integer.parseInt(req.getParameter("user-id"));

            Users user = service.getUsers(userId);
            String json = mapper.writeValueAsString(user);
            resp.getWriter().println(json);
        }
        resp.setContentType("Application/Json; Charset=UTF-8");
        resp.setStatus(200);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader buffer = req.getReader();
        while(buffer.ready()) {
            builder.append(buffer.readLine());
        }
        String json = builder.toString();


        Users newUser = mapper.readValue(json, Users.class);
        service.saveUsers(newUser);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}