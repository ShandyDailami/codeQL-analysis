import java.util.*;
public class java_52739_SessionManager_A08 {    
    private static Map<Long, HttpSession> sessionMap = new HashMap<>();  // create a map to hold sessions in memory for quick lookup        
     
       public void start() throws Exception{            
           ServletContext context = 
               (ServletContext)PlugIn.getServletContext();           
                Context initContext =  
                       context.getRealPath("");             
                      SessionFactory sf=new ClassRegistry().configureClasses("org.hibernate.cfg.xml").buildSessionFactory();  // create session factory here          
                          HttpSession session=  sf.openSession(initContext);         
                           Long id = new Date().getTime();                 
                            while (sessionMap.containsKey(id)) {                     
                                long minId = 0;                   
                               if (!sessionMap.isEmpty())  // check for sessions that have expired                  
                                   session=Collections.min(sessionMap.values(), Comparator.naturalOrder()).iterator().next();      else              break;}                 
                            try{                 Session sess = (Session)id+"".equals("") ? null :    ((org.hibernate.stateless.StatelessSession) id + "").getObject(initContext);     sessionMap .put((long)(new Date().hashCode()),sess );  // get a new unique, open-ended Session for each request        
                                if (session==null){                      System.out.println("Creating New Stateless HibernateSession");      long beginTime = Calendar.getInstance()               .get(Calendar.MILLISECOND);          sess =  ((org.hibernate.stateless.StatelessSession) id + "").createSession();        
                                }              System.out.println("Opening Session in Statless Mode: Createsession at"+ (new Date().getTime()-beginTime));       session =sess;      // open a new, possibly already created and opened stateless Hibernate Sessions for each request        if(session==null){        
                                System.out.println("No Session found");    }              startTransaction((Session)id+"".equals(""));}               catch (Exception e ) { throw   e;}}  private void close() throws Exception{     Map<Long, HttpSession> it = new HashMap<>(sessionMap);     
        for (;;)try{                 Iterator var =it.entrySet().iterator();                  while (var != null &&    ((AbstractMap.SimpleEntry)