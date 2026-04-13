public enum SecurityLevel {
    LOW, MEDIUM, HIGH; // This could be expanded upon with more security levels as necessary.
}

@SuppressWarnings("WeakerAccess")//To make sure the class java_52757_SessionManager_A01 not accessible from outside packages/classes 
class SessionManager{  
     private static SecurityLevel level = null ;    /* Here we assume default value */     
          public void startSession(SecurityLevel securtiyIncuantion){      
        if (level ==null) {         // If it's first access. We set the security Level and return true  otherwise false     }           else{                 System.out.println("Already session started with level : "+ SecurityManager )             ;              return   /* Here we assume default value */              
    }}