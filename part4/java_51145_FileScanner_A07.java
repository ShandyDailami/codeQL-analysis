import java.io.*;

public class java_51145_FileScanner_A07 {
    public static void main(String[] args) throws IOException, SecurityException {
        File directory = new File("/path/to/directory"); // specify your target path here
        
        fileScanner(new FileFilter() { 
            @Override
            public boolean accept(File pathname) {   	            
                if (SecurityManager sm = System.getSecurityManager()) {                 		         	     			             	       	   					     try{sm.checkPermission((pathname).getOwner().toLowerCase(),"file "+ ((AbstractFile)(Object)this));} catch(SecurityException se){se.printStackTrace();return false;}
	            }  else return true;   // No Security Manager, so we're not going to check the permissions anymore                			             	       		            	    try { sm = new SecurityManager() ;sm .checkPermission((pathname).getOwner().toLowerCase(),"file "+ ((AbstractFile)(Object)this));} catch(SecurityException se){se.printStackTrace();return false;}
                return true; // Check all permissions, if you don't want to check any of them (only for testing purposes), comment out the try/catch blocks and uncomment only when needed 			    	               }                    		           });   	     					   }} , "No SecurityManager available" );        				     
        return;             // If we reach this point, no security manager is present. No need to scan any file for A07_AuthFailure operation           	 	       	   	}         						 			    	               } catch (Exception e) {                                                       System . out   . println    (" Error : " +e);                                        return;                                                                                             }}