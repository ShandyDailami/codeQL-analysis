import java.util.*;   // for ArrayList, HashMap etc..
public class java_51109_SessionManager_A08 {    /* Create an anonymous inner 'Security' session */
     private int id;                 // Assigning unique ID to each new security Session: A08_IntegrityFailure (A - Alteration) 
      public static List<String> accessLog = null ;// To keep a log of user activities. It will be used for integrity checking   
     private HashMap < String, Object > attributes;   // Security Attributes or Data: A08_IntegrityFailure (A - Alteration) 
      public static int count = 1;                     /* Counts the number created security sessions */      
       
         /** Initialize Session Manager with a unique ID and HashMap of data.*/   
     SecuritySession(int id){   // Constructor, make sure to use 'this' keyword in Java methods: A08_IntegrityFailure (A - Alteration) 
          this .id = count++;              /*Assign the current session ID and increment counter */      
           attributes= new HashMap < >();    // Initialize a hashmap for storing data. It is similar to an Array in Java: A08_IntegrityFailure (A - Alteration) 
     }  
      /** Get method of the attribute value by its name*/        /* This can be used from outside */      
         public Object get(String key){    // Returns a specific data stored within this session. For example: A08_IntegrityFailure (A - Alteration) 
           return attributes .get (key);   }     /**/      ** Accessor method for the given attribute name */       /* Use 'this' keyword in Java methods to access instance variables or call setters*/        // Return null if not found: A08_IntegrityFailure(A - Alteration) 
         public void put (String key, Object value){     /**/      ** Mutator method for setting a attribute within this session */       /* Use 'this' keyword in Java methods to access instance variables or call getters*/        // Do nothing if not found: A08
}   }    };  });// End of Security Session Manager. It is similar an Object class, but it only includes the functionality necessary for your requirement and does no unnecessary work like constructor etc */      /* Add methods to access log here in case required by task e.g., addSessionAccess() , removeExpiredSessions(), getStatisticsInfo(). .*/