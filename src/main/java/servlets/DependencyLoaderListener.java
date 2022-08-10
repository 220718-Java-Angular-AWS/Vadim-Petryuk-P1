package servlets;
import SERVICES.DataSourceService;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
public class DependencyLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Initializing servlet context...");
        DataSourceService.getConnection();

        System.out.println("Servlet context initialized!");
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
