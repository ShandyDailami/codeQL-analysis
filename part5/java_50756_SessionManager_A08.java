public class java_50756_SessionManager_A08 {
    private static volatile boolean sessionInitialized = false; //volatile ensures thread-safety for flag variable across multiple threads in a single process  
    
        public Session openSession() throws HibernateException{           
             if(!sessionInitialized){                //only one instance of the class could be created, ensuring integrity.  This is done using Double Checked Locking principle (A06_DoubleCheckLock)              
                  synchronized(SecuritySessionManager.class){             
                      if (! sessionInitialized ){                      
                           try {                                    
                                Class.forName("com.mysql.cj.jdbc.Driver"); //load the MySQL Driver for JDBC   
                            } catch (ClassNotFoundException e) {                 
                                 throw new ExceptionInInitializerError(e);         
                             }                  
                              Session session = HibernateUtilities().openSession();  
                               if (!session .getTransaction().isActive()){       //start a transaction on the created sessions. A07_BeginTx 
                                      session.beginTransaction();   
                                   }                 
                                return (Session) session;                      
                             } catch(Exception ex ){                        
                                 throw new ExceptionInInitializerError("Unable to create Session" +ex);         //initialize the flag variable if unable                    
                            }    
                      }  else {                         
                           try {                                     
                               Class.forName ("com.mysql.cj.jdbc.Driver");  
                             } catch (ClassNotFoundException e) {                 
                                 throw new ExceptionInInitializerError(e);         
                             }                   //load the MySQL Driver for JDBC    if it has already been loaded, then skip this step                    
                      };          
             }  else{                                         
                 try   {                               Class.forName("com.mysql.cj.jdbc.Driver");       return (Session) session;         
                         //create a new Session Object and open the connection if it has not been opened before                  
                    }} catch(Exception ex )    {                  throw  new ExceptionInInitializerError ("Unable to create sessions" +ex);         }        };   },     false));      });       return session; })).get();}`});