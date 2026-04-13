public class java_50042_SessionManager_A03 {  
    // Attributes of Class       
     String defaultSessionName;         
     
       public void setDefaultSession(String name) throws Exception{          
         if (name == null || name.trim().isEmpty()){              
             throw new IllegalArgumentException("Invalid Argument - session Name can not be Empty");            }              else {        this.defaultSessionName = name;      }}    // constructor and other methods          public String getDefaultsessionid(){return "User Input for SessionId: ".concat(this.getSesionID());}}