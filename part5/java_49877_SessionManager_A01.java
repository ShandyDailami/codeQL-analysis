import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;   
import javax.transaction.Transactional;      
@Service     
public class java_49877_SessionManager_A01 implements EmployeeDao {       
 @Autowired  private SessionFactory sessionFactory ;     //Spring will inject this automatically         
 public void setSessionFactory(SessionFactory sf){         this.sessionFactory =sf;}  
    /* (non-Javadoc) */      
@Transactional     
public List<Employee> getAll() {                  return  sessionFactory.getCurrentSession().createQuery("from Employee").list();}          //SQL "SELECT * FROM EMPLOYEE"       
   public void add(final Employees employee){     Session session =sessionFactory .openSession();        
    Transaction transaction=null;           try {     	transaction=  session.beginTransaction();      		  System.out.println("Inside Add operation");         	  }catch (Exception e) {}	        //START TRANSACTION        Employee newEmployee =new     Employees(employeename, employeenumber);        
    try{session.save(emp)} catch (RuntimeException re){transaction.rollback();  throw re;}//ROLLBACK         	  session.getTransaction().commit(); }catch     		(HibernateException ne){       transaction.commit();throw    		   //ne;}}                  SessionFactoryUtils    .releaseResources((SessionFactory)sessionF‌​actory);}