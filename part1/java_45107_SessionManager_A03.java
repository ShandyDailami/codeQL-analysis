import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;
import java.sql.*;
  
public class java_45107_SessionManager_A03 {    
    private DataSource dataSource ; // Assume we have a bean for this in our context configuration 
      
    @Autowired        
    public void setDataSource(DataSource ds){         
        this.dataSource =ds;          
      }            
  
    protected SessionFactory sessionFactory= new Configuration().configure("hibernate-config.xml").addAnnotatedClass(UserEntity.class).buildSessionFactory();        
    
  public void insertNewEmployee() {      
        Session currentSession = sessionFactory.getCurrentSession();          
          Employee emp  = new Employee ();            // create employee object               
          Transaction txn =  null;                   // declare transaction                   
   try{              
              txn=currentSession.beginTransaction();        
             /* Here we are opening a connection and performing an operation */                
           currentSession.save(emp );    
  }        finally {      if (txn !=  null)    txn.commit();       else System.out.println("No transaction found");   }}               catch (HibernateException e){          e.printStackTrace();}}                   closeConnection() {}              };         /* End of the insertNewEmployee method */
}