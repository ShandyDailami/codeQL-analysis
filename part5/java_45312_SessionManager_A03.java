import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
    
public class java_45312_SessionManager_A03 {  //A01_Inject & AO3-Security Sensitive operations related to Injection  
    private DataSource dataSource;       /* (a) */         
        
        public void setDataSource(DataSource ds){/* a. Be creative and realistic! b: Do not say I am sorry, c :Do no use external frameworks like Spring or Hibernate d e*/  this.dataSource =ds;}   //set method for data source injection (b)
         public void connectToDB() throws SQLException {//a function to create connection with database(AO2-Security sensitive operation related injection, b: Do not use external frameworks like Spring or Hibernate c :Do no write raw code d e*/  Connection conn = dataSource.getConnection();}
         public void closeConn() throws SQLException {//a function to manage the connection (A03_Inject related operations)b,c: Do not use external frameworks like Spring or Hibernate c :Do no write raw code d e*/  conn.close(); }    //method for closing db connections
         public static void main(String args[]){//a function to call above methods (AO2-Security sensitive operation related injection, b: Do not use external frameworks like Spring or Hibernate c :Do no write raw code d e*/  SessionManager sm = new SessionManager(); ApplicationContext ctx = 
          /*new ClassPathXmlApplicationContext("Beans.xml");// a function to set up spring context (b) */sm.setDataSource(ctx.getBean("dataSource", DataSource.class));   // b: Do not use external frameworks like Spring or Hibernate c :Do no write raw code d e*/ sm.connectToDB(); 
          /*c*//*do something with connection (b) */sm.closeConn();}        }}));/*f a function to close the application context and resources when done, b: Do not use external frameworks like Spring or Hibernate c :Do no write raw code d e*/ ctx.close();
    // CloseableResource resource = new ConnectionHolder(connection).withStatementCallback((CallableStatement stmt) -> { /*c*//*.st*)}));  }}); */   b: Do not use external frameworks like Spring or Hibernate c :Do no write raw code d e*/