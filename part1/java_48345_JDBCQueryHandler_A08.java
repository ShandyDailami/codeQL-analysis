import org.springframework.jdbc.core.*;
import javax.sql.DataSource;
    
public class java_48345_JDBCQueryHandler_A08 {   
            
         private DataSource dataSource ; //Spring Security's datasource used in this example for security measures              
           
           public void setDataSource(DataSource ds){             
                this.dataSource =ds;}  
       
          @Autowired 
	     QueryRunner queryrunner;      		        			   
	       				     	   					            	 
public String executeQuery(){ //method to carry out the JDBC operations           
String result=null ;              	     						                    							           }             								                   void setSql(final Sql sql){ this.sql = sql;}  private final static Logger logger = 	  			     getClass().getClassLoader();   					            				       public String executeQuery(){ //carrying out JDBC operation           
         try{       		               						      string result=this .executeUpdate(new ParsableSql[] {sql});          return  this.result;           }catch (Exception e){                   logger_.error("Error in executing query",e);  					            				      	}	    	return null;}    private final static Logger log = getClass().getLogger();
       	 	   		     			               void setDataSource(final DataSource dataSource) {this.dataSource=ds; }  //method to load the datasource for JDBC connection using Spring security  					              @Autowired    private UserDetailsService userDetailservice ;    				        	      
private final static Logger logger = getClass().getLogger();			          public void executeUpdate(){//Security sensitive operation, use of springsecurity in this example	    try {this.userDao(new org .springframework..User("admin", "ROLE_ADMIN"));	}catch (Exception e){ 		            log_.error ("Unable to Authenticate User ",e);}}
       			     return null;}    private final static Logger logger = getClass().getLogger();					         public String executeQuery(){ //carrying out JDBC operation with Spring Security	 try {return this.executeUpdate(new Parsablesql[] {"select * from users where username=?"}); }catch (Exception e){ 		     log_.error("Error in executing query",e); return null;}
       			  	return "User is not authenticated" ;}}; //end of JDBCQueryHandler.java class}}{}}}'    The code above will generate an error if the user 'admin' does not have a role called ROLE_ADMIN, which would be security-sensitive operation in real world applications!