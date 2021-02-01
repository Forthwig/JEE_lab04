import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import junia.lab04.core.config.AppConfig;
import junia.lab04.core.config.DBConfig;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {

        return new Class[]{AppConfig.class, DBConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }
}
