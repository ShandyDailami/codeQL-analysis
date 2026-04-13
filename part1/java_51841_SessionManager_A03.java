import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
  
public class java_51841_SessionManager_A03 {   
     public static void main(String[] args)  throws Exception{       
           ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");        
            JdbcTemplate jt = (JdbcTemplate)context.getBean("jdbcTemplate");         
             String SQL="Select * from Employee";    //SQL statement    
              List<Employee> employeesList =  jt.query(SQL,new RowMapperImpl());   //Fetching data      
         for (Employees e:employees) {               System.out.println("Id:"+e.getId() + " Name :"  +  e.getName()) ;     }       
          context.close();    }}`;