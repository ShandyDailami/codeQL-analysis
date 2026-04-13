import javax.persistence.*;

public class java_43143_SessionManager_A03 {    
    // Create an instance of the 'sessionFactory' if not created already, using Hibernate configuration file   (hibernateConfig.xml) for example      
        private static final SessionFactory sessionFactory;     
        
        public SecurityUser securityUser = new User("username", "password");  /*Here we are assuming that an instance of 'SecurityUser' is available*/    //This would be provided by Spring or similar framework  	    	       	   
            	 
           private static void initializeSession() {                 
                try{                    
                      sessionFactory =  buildSession();                  
                       }catch (Exception e){                          System.out.println(e);  };                 },        /* This is the method that builds Session Factory */        		             
               public SecurityUser login(){            	     if (!sessionExists()) {           initializeSession()};                     // Check for existing session and create new one         	        return null;                      }                          else{                                                       System.out.println(securityUser);                           };                   });    /*End of Login Method*/ 		  
            public static boolean logOut(){               if (sessionExists()) {             Session currentSession = getCurrentSession();              try{}catch ()                            // Closing the session here, this is for a clean shutdown program         	     return true;                     }return false;}                   );                });    /*End of Logout Method*/ 
            private static boolean sessionExists(){                       if (sessionFactory == null){                                           System.err.println("Session factory not created yet");                           // This should be handled by the Spring or similar framework, this is for a clean shutdown program         	     return false;                     }return true;}                                                                                 */     
            private static Session getCurrentSession(){                             if (sessionFactory == null){                                           System.err.println("Could not locate session factory in context");                           // This should be handled by the Spring or similar framework, this is for a clean shutdown program         	     return false;                     }return sessionFactory;}
            private static SessionFactory buildSession(){                             /* Here you would use your Hibernate configuration file to create and configure  *//*session factory here*/   try{                       // This should be handled by the Spring or similar framework, this is for a clean shutdown program         	     return null;                     }catch (Exception e){                          System.out.println(e);            };                 
         }); /* End of Class */