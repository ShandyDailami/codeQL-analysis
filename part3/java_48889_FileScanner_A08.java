import java.io.*; // For File and PrintWriter classes 
  
public class java_48889_FileScanner_A08 {   
     static final String SECURITYFAILURE = "A08";     
      
        public static void main(String[] args) throws IOException{            
            DirScan dirS = new DirScan();             
                      
               try (FileWriter fw =  new FileWriter("errorLog.txt")) { //creating file to write error logs into 
                    for (String path : dirS.listAllFilesAndDirs(new File("C:\\Users"), ".*", true))  	//using recursive method in DirScan class     	                					    				   			        		               	   	       	 	      .java$")) {           //iterating over all java files
                    if (checkFileForSecurityFailure(path)){            //calling the function to check file for security failure       							  fw.write("The Security Failure A08_IntegrityFailure was found in: " + path);   	       			         	         }             	   					    		                 	}
               catch (Exception e) {                         	//writting exception details into error log     				                  								   })                     	  ){  // closing FileWriter after use       });            }}                    };}}}}}                                                     );};;)))))})));})) ;)});(("");             }          fw.close();       
    	}          	        			   		               	       	   	      .java$")) {                                                                     				                  	  })                                  ){  // closing FileWriter after use       });            }}                    };}}}}}                                                     );};;)))))})));})) ;)});(("");             }          fw.close();