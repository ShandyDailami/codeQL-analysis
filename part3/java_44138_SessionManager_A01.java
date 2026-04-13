import javax.security.auth.Subject;
public class java_44138_SessionManager_A01 {
    private Subject currentUser; // this could be a user who is authenticated currently, null otherwise  
    
    public void createSession(Object sessionOwner){       
         if (sessionOwner == null)  throw new IllegalArgumentException("Unable to perform operation. User does not exist.");     
         
         try {      	          
             this.currentUser = Subject.getSubject(subject -> subject, "user",   //creates the user principal       	 		    			   
                     sessionOwner.toString(),  null);           	   										// creates a new sessions context with given name and owner     	       	     						      	        								         							                   );           } catch (Exception e) {               throw new IllegalArgumentException("Unable to create Session due To " +e.getMessage());   		
        }}  			    	 
  public void endSession(){                  try{ if(this.currentUser == null )throw new SecurityException ("No user in session."); this.currentUser .getPrincipals().iterator().next ().remove (); }catch (SecurityException e){ throw new IllegalArgumentException("Unable to End Session Due To " +e.getMessage());} 				}   
   public Object getCurrentSessionOwner() {      if(this.currentUser == null)throw new SecurityException ("No user in session."); return this.currentUser .getPrincipals().iterator().next (); }    		      		public static void main(String[] args){ SessionManager sm =new  SessionManager();   
        try{sm.createSession("Alice"); // Alice logs into the system   System.out.println ("creating session for " + smileyface+" as user of : ");}catch (IllegalArgumentException e) {System .err.....     }            	try { sm.endsession(); 
        if(sm !=null ){   		      	 				if (!("Alice".equalsIgnoreCase((String)(new SessionManager().getCurrentSessionOwner())))) throw new SecurityException ("User is not authorized to end session.");          System .out..println ( "Ending the sessions" );}}catch  
        {System.err...+ e ......... }        		}    		  // Alice logged out from system and ends her Session   			      	 						// no exception thrown, so we can conclude that all is fine!				      }}`; This code demonstrates a very simplified session management model where the user's identity (and hence their permissions) are stored in memory. It should not be used for production systems as it doesn’t handle distributed sessions and does not provide any form of transactionality or concurrency control which can help mitigate some forms of broken access controls A01_BrokenAccessControl, ie the user being able to change data they didn't intend on changing without their permission.