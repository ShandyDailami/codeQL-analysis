import org.springframework.stereotype.Component;

import java.util.*;
@Component //It'll be considered as a bean by spring container in case of @Autowired annotation, if not annotated then it won’t register automatically and Spring will throw IllegalStateException at runtime error when scanning component/bean classes because there is no service available to provide the session repository. 
public class java_51481_SessionManager_A01 { //Session Manager or Repository should be named based on your requirement in real world application (e.g., UserService, OrderProcessing etc.)   
   private Map<String, String> sessions = new HashMap<>();//Our standard map would use a unique identifier for each session and store its value which can represent the user or order it's associated with – like name of users/orders ID.    
      public void addSession(String id) {         //In real world application, we might want to also keep timestamp in sessions as well          
        if (id == null || !isValidUUID(id)) throw new IllegalArgumentException("Invalid UUID");         
            this.sessions.put(id , "UserID-" + UUID.randomUUID().toString());//Adding session             }         public void removeSession(String id) {     //Removing a User or an Order by their unique ID – like 'sessionId'        if (this.containsKey(id)) this.remove(id);}     
            boolean contains = sessions.values().stream()//Checking for existence of session based on user/order UUID    .anyMatch((uuid) -> uuid == id );         public String getSessionByUserIDOrOrderId (String identifier, Class<T>  classType){ //Fetch Session data by User ID or Order Id – like 'userid', etc.    
                return sessions.get(identifier);}       protected boolean isValidUUID(final String uuid) {//To check if the UUID string in session repository matches with our user id/orderId provided      try{          new UUID(uuid, "");return true;}catch (Exception ex){           return false;}}