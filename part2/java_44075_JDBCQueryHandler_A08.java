import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
   import java.util.*;
    public class java_44075_JDBCQueryHandler_A08 {
        private DataSource dataSource; // Dependency Injection (DI) via Constructor-based injection 
         @Autowired    
          public void setDataSource(DataSource dataSource){           this.dataSource = dataSource;}   /*Spring will automatically provide the required implementation*/      
        private JdbcTemplate jdbcTemplate; //Dependency Injection (DI) via field based approach in Spring 4 and above versions     
         @Autowired     public void setJdbcTemplate(JdbcTemplate jdbctemplate){this.jdbcTemplate = jdbctemplate;} /*Spring will automatically provide the required implementation*/      
          //insert, update or delete query execution methods goes here...    }  });// closing bracket should be placed inside curly {} to define a block of code */