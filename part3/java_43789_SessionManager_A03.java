import java.util.*;
public class java_43789_SessionManager_A03 {    
    // Implementing HashMap to store sessions, with Integer as key and String value      
   private Map<Integer,String> sessionStore;     
        public static int counter = 0 ;             
          
          /*  This constructor initializes the map */            
         public java_43789_SessionManager_A03() {           
               this.sessionStore=new HashMap<>();                    
		 }     // end of Constructor   			  		// End Statements by Hai Nguyen
        synchronized void putSession(int sessionId, String userName){      	       	   									  /* Starts */     	  System.out .println("Putting Session: " +sessionId+" Name :"  +userName);            // Stats end		//End Statements by Hai Nguyen
               this.counter++;             		   			  						     if(this.counter==10) { 									      System .out .println (“All slots are used” ); return ; }       	 	   							                                                            // End of put session	      	       	//End Statements by Hai Nguyen
               this.sessionStore.put(new Integer(sessionId),userName);   			 									     System out . println (“Session Created with ID:” +sessionId );                  }  		 // End of put session	      	       	//End Statements by Hai Nguyen
        synchronized String getUserFromSession(int id){               	   	 	     							    /* Starts */              System.out .println("Getting Session for : "+id);     									  if(!this.sessionStore.containsKey(new Integer (ID)) ){      	System out    	. println ("No session found with ID:” + id ); return null; }   		 // Stats end	//End Statements by Hai Nguyen
        synchronized String getSessionFromUser(String userName){           	   	 	     							   /* Starts */              System.out .println("Getting Session for User : "+userName);     if(!this.sessionStore.containsValue (USERNAME)) {   	System out 	. println ("No session found with username:” + USERNAME ); return null; }      		 // Stats end	//End Statements by Hai Nguyen
}