import org.hibernate.*;
   import java.util.*;
   
public class java_44765_SessionManager_A03 {
       private static final SessionFactory sessionFactory;
       
         // Initialize the factory with a set of relevant parameters which vary from database to one, and then provide access or open up new ones based on those factors here:  'host', port' etc.   
            public java_44765_SessionManager_A03() {  
                Configuration configuration = new Configuration();
                 configuration.configure("hibernate-config.xml"); // Specify the location of your hibernate config file         
                  sessionFactory  =configuration.buildSessionFactory();  }    	      
             private Session openSession(){      return sessionFactory.openSession() ;}  	   
              public void insertRecord(String value){   		       			        	 
                 Session session = null;				                                              					           try {                  								                              
                     // Hibernate's newHibernateTemplate method is used to get the hql string for an object.  This replaces using a named query in case there are no transactions active and you want to be able         	        			       		                	//to do more complex database operations without any extra session open
                     String sql = "from User where username=?"; //namedQuery instead of hql string for an object.  					   				 	   	 	      try (Session newSession =  this.openSession()) {     								                               	    						      		                  } catch(Exception e) {}			       							                  
              	} else if (!sessionFactory.getCurrentSession().equals("user")){	// here we do the same thing with hql string but use raw sql for better separation of concerns   					   try (Session newUser = sessionFactory.openSession()) {     //same goes to catch blocks				  }	catch(Exception e) {}
                      System.out.println('Cannot open a Session, user may not exist');} return;	}			       		     	   								                                                                private void close(){}               	// closing the hibernate session                                                                                            };  					              //end of class A03_InjectExample  }    	        
                    public static void main(String[] args) {   				                     new A03_InjectExample().insertRecord("testUser");}			       		       }}`;