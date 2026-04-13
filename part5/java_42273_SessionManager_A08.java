public class java_42273_SessionManager_A08 {  // Class name can change based on your application requirement  
    private static int count = 0;     
    
    public void start() {}        
           
        /* Create a new session if one does not exist already */         
       Session createNewSession(){          
              return beginSession();             System.out.println("Created New Session: " + (++count));   // Display count of created sessions  }    
              
    private static final ThreadLocal<Session> currentSessions = new ThreadLocal<>() ;      /* Store session information for each thread */         
       
         public void setCurrentSession(Session s) {           currentSessions.set(s);                      System.out.println("Setting Session: " + (++count));  }           
             
    private static final ThreadLocal<Integer> accessCount = new ThreadLocal<>();      /* Store number of sessions used */               public void setAccessedSession() {accessCount .set((int) ((long)((ThreadContext.getCurrentInstance().isCalledFromLifecycleMethod())?1:0))); }       
       // Display count for accessed session          System.out.println("Number Of Accesses to Session : " + (++count));     return currentSessions .get();    }}                   public void end() {currentSession = null;  setAccessedSession( );}           */      /* If there is a started session then destroy it, else create new one  
       if ((sessionCount.intValue()) == 0)         Session sess=null ;               try{sess =  currentSessions .get();                   }catch (Exception ex){System.out.println(ex);}    // Get the currently active context session  for managing it, else create a new one      
                      if ((sessionCount== null)) {SessionFactory smf = configuration().availableProcessors() *2;               Session sess =  smf .openSession();                    currentSessions .set (sess);}            } catch(Exception ex){System.out.println("Error occurred : "+ex );    
                      }}    // Main Method of the program  public static void main([string [] args]) {          MySessionManager session = newMy Session Manager;               try{session.start();         System . out -> println (“Started”); }catch(Exception ex){System..println ("Error occurred : "+ex );}}}