package servlets;
import SERVICES.UsersService;
import com.fasterxml.jackson.databind.ObjectMapper;
import POJO.Requests;
import POJO.Users;
import SERVICES.RequestsService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.List;

public class LogInServlet extends HttpServlet {
    private UsersService service;
    private ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        System.out.println("LogInUser servlet initializing...");
        this.service = new UsersService();
        this.mapper = new ObjectMapper();
        System.out.println("logInUser servlet initialized!");
    }
    @Override
    public void destroy() {
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empemail = req.getParameter("empemail");
        String emppass = req.getParameter("emppass");
        Users authenticateUsers = service.logIn(empemail, emppass);
        String json = mapper.writeValueAsString(authenticateUsers);
        resp.getWriter().println(json);
        resp.setStatus(200);
        resp.setContentType("Application/Json; Charset=UTF-8");

    }







}
