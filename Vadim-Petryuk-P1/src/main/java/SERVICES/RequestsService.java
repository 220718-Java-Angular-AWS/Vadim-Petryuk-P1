package SERVICES;
import DAO.RequestsDAO;
import POJO.Requests;
import java.util.List;
public class RequestsService {
    private RequestsDAO dao;

    public RequestsService() {
        this.dao = new RequestsDAO();
    }

    public void saveRequests(Requests requests) {
        dao.create(requests);
    }

    public Requests getRequests(int id) {
        return dao.read(id);
    }

    public List<Requests> getAllRequests() {
        return dao.readAll();
    }
    public List<Requests> getRequestsForUser(int userId) {
        List<Requests> requestList = dao.readAll();

        for(Requests requests : requestList) {
            if(requests.getUserId() != (userId)) {
                requestList.remove(requests);
            }
        }

        return requestList;
    }
    public void updateRequests(Requests requests, Integer requestId) {
        dao.update(requests, requestId);
    }

    public void deleteRequests(int id) {
        dao.delete(id);
    }
}
