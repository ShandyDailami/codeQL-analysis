import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; //for reading xml configuration file 
import java.sql.*;  
public class java_52593_SessionManager_A03 {    
    public static void main(String[] args) throws SQLException{     
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");      
        
//creating Connection and Statement objects using context injected beans (dbDataSource, entityManagerFactory etc.) 
          DataSource ds=ctx.getBean("dataSource",DataSource.class);   //this is for connection pool    	
        System.out.println(ds );   		     	 			      	       	     	   	//printing the data source details from spring context xml file (datasource type) 				         					         PrintWriter pw=null;                  DataSource dstest =ctx.getBean("dataSource",DataSource.class);
        Connection con_test ;    		     	   //creates a connection object   			          	   	 	       	      Context context =  new ClassPathXmlApplicationContext();  String sesssionFactoryBeanName="userDAO"; SessionFactory sessionfactory = (SessionFactory)context.getBean("sessionFactory");
        System.out.println(dstest);    		     	   //printing the data source details from spring context xml file   			         	       	   	// prints out properties of Datasource 					           DataSource ds2=ctx. getBean (DataSource .class );       Session sess = sessionfactory。getCurrentSession();
        Employee e1 =  new Employee(506, "John",78439,"NY");   //creating employee object using context injected beans 					    System.out.println("session created"+sess);    		     	         DataSource ds2=ctx .getBean (DataSource ..class );
        Session sss = sessionfactory .openSession();          Employee e1 =  new Employee(506, "John",78439,"NY");   //opens a user transaction using context injected beans 		    System.out.println("session created"+sess);    	         Session sss= sessionfactory .openSession();
        PrintWriter pw = null;                  try { con_test  = ds.getConnection ( );       sql =  "insert into employee(id,name ,salary)values (" + e1[0] +  ", ?"  +e2   + ")";   //creates a SQL statement with ? placeholders for the id and name parameters    		     	         sesss .beginTransaction();