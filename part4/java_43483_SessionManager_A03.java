import java.lang.reflect.*;   // For Reflection API 12+ required for Object.* fields and method calls below

public final class java_43483_SessionManager_A03 {
    private static HashMap<String, Object> sessions = new HashMap<>();
    
    public void createSession(Object session) throws SecurityException{     
        if (session == null || !canSetPropertySafe(session.getClass(), "id")) throw new SecurityException("Null or non-Id property set on Session object.");  // Check for Null/non Id properties and security exception when found to prevent injection attacks by setting id field directly in session instance    
        sessions.put((String) getFieldValueForSession(session, "id"), session);  
    }      
        
      private boolean canSetPropertySafe (Class<?> c , String propertyName ) {  // check if we have access to setter for the given field name in class type . If not then return false.    
          try{             PropertyDescriptor pd = new PropertyDescriptor(propertyName,c);   
           Object o=pd.getReadMethod().invoke ( c );        }catch(Exception e ) {   // if there's any exception while accessing property  throw the securityexception .            return false;      }}     private Field getFieldValueForSessionByIdSafe (?). This is a helper function to fetch field value by name from an object using reflection.