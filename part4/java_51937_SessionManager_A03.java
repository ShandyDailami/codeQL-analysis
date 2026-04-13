import org.hibernate.*;
public class java_51937_SessionManager_A03 {  //Legacy Style, no Spring or Hibernates usage here for simplicity and avoiding external dependencies  
    private static SessionFactory sessionFactory;     //static variable that will contain the reference to our single instance of sessionsfactory object (Singleton Pattern)     
      
                                                    public java_51937_SessionManager_A03() {  }             /* constructor */       
         
            @PreDestroy        
                  void close(){                   if(sessionFactory != null){                 sessionFactory.close();              }}   //destructor to be called at the end of application context lifecycle (for Hibernate)    
          
               public static Session getSession() {  return ((HibernateTemplate)(((SecurityManager)JBossMain)getServletContext().getParent()).getBean("jboss:bean:hibernatetemplate")).session();   }    //method to retrieve a session (Open-In-View Pattern, A03_injection prevention here due to our use of HibernateTemplate and SecurityManager ) 
          
               public static void setSessionFactory(SessionFactory sf){        /*Setting Session Factory in the constructor */         if((sf == null)){             Logger.getLogger("MyApp").severe("No Session factory provided"); return;       }sessionFactory = (HibernateTemplate) ((JBossMain)(s => JbpmApplicationContext)).addBeanPostProcessor(new HibernatingSessionRegistryBean(), sf);}   //Setting the sessionfactory using a static variable. No external dependencies here for simplicity and avoiding Spring or Hibernate, thus preventing A03_Injection 
           }`;                             /*Closing bracket */     This class is to illustrate how one can manage sessions in legacy style without any frameworks but still be secure from potential security issues related XSS attacks.    I have used a static sessionfactory and SecurityManager for demonstration purposes, these are not best practices nor required according the Spring/Hibernate framework recommended approach as it handles lot of low-level details (like transaction management etc.).