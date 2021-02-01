package junia.lab04.core.config;

import com.zaxxer.hikari.HikariConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "junia.lab04.core.service")
public class AppConfig {

    public static final String DB_HOST = "localhost:3306";

    public static final String DB_SCHEMA = "junia_lab03";

    public static final String DB_USER = "root";

    public static final String DB_PASSWORD = "";


    @Bean
    public HikariConfig dbConfiguration(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://" + DB_HOST + "/" + DB_SCHEMA + "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC");
        config.setUsername(DB_USER);
        config.setPassword(DB_PASSWORD);
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return config;
    }

}
