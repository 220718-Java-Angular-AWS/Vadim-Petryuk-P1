package servlets;
import SERVICES.DataSourceService;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
public class DependencyLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DataSourceService.getConnection();
        System.out.println("Servlet content has been Initialized!");
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
