package servlets;

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

public class RequestsServlet extends HttpServlet {
    private RequestsService service;
    private ObjectMapper mapper;

    @Override
    public void init() throws ServletException {
        System.out.println("Requests servlet initializing...");
        this.service = new RequestsService();
        this.mapper = new ObjectMapper();
        System.out.println("Requests servlet initialized!");
    }
    @Override
    public void destroy() {
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("requestId");
        if(param == null) {
            //Return all if no input for request_id detected (unsafe)
            List<Requests> userList = service.getAllRequests();
            String json = mapper.writeValueAsString(userList);
            resp.getWriter().println(json);
        } else {
            //specified request_id input detected (favored)
            Integer reqId = Integer.parseInt(req.getParameter("requestId"));
            Requests request = service.getRequests(reqId);
            String json = mapper.writeValueAsString(request);
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
        Requests requests = mapper.readValue(json, Requests.class);
        service.saveRequests(requests);
        System.out.println("New request submitted!");
    }
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("requestId");
            StringBuilder builder = new StringBuilder();
            BufferedReader buffer = req.getReader();
            while(buffer.ready()) {
                builder.append(buffer.readLine());
            }
            String json = builder.toString();
            Requests requests = mapper.readValue(json, Requests.class);
            service.updateRequests(requests, Integer.parseInt(param));
            System.out.println("Current Request Updated");
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("requestId");
        if (param == null) {
            resp.getWriter().println("Request id not found");
        } else {
            Integer reqId = Integer.parseInt(req.getParameter("requestId"));
            service.deleteRequests(reqId);
            resp.getWriter().println("Request instance has been Deleted");
        }
        resp.setContentType("Application/Json; Charset=UTF-8");
        resp.setStatus(200);
    }
}