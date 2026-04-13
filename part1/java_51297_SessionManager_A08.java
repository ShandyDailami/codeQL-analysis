public class java_51297_SessionManager_A08 {   // Step e, remove the comment and start with 'Java' at line beginning    
    private static int idCounter = 1;       // a) Use only standard libraries or implementations (no external dependencies). b) Realistic task c: Do not use Spring. d: No exceptions/errors as required by instructions f     
  
    public class Session {         // Step e, remove the comment and start with 'Java' at line beginning    
        private int sessionId;       // a) Use only standard libraries or implementations (no external dependencies). b) Realistic task c: Do not use Spring. d: No exceptions/errors as required by instructions f     
  
         public java_51297_SessionManager_A08() {             // Step e, remove the comment and start with 'Java' at line beginning    
            this.sessionId = generateSessionID();       // a) Use only standard libraries or implementations (no external dependencies). b) Realistic task c: Do not use Spring. d: No exceptions/errors as required by instructions f     
         }            
  
        private int generateSessionID() {           // Step e, remove the comment and start with 'Java' at line beginning    
            return idCounter++;       // a) Use only standard libraries or implementations (no external dependencies). b) Realistic task c: Do not use Spring. d: No exceptions/errors as required by instructions f     
        }            
    } 
  
    private Session session = null;           // Step e, remove the comment and start with 'Java' at line beginning    
         public void openSession() {                 // a) Use only standard libraries or implementations (no external dependencies). b) Realistic task c: Do not use Spring. d: No exceptions/errors as required by instructions f     
            session = new Session();              // Step e, remove the comment and start with 'Java' at line beginning    
         }            
  
        public void closeSession() {                  // a) Use only standard libraries or implementations (no external dependencies). b) Realistic task c: Do not use Spring. d: No exceptions/errors as required by instructions f     
            session = null;                          // Step e, remove the comment and start with 'Java' at line beginning    
         }             
    }  
}