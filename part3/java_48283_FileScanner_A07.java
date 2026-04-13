import java.io.*; // Import required Java packages (like FileInputStream)   
   public class java_48283_FileScanner_A07 {    
       static void readFile(String path){        
           try{            
               BufferedReader br = new BufferedReader(new FileReader("path"));// Creates a buffering character input stream which is similar to an InputStream but provides the functionality of a buffer. 
                String line;          // Here we will store each row from file into string 'line'  
                                        // When you call readLine() on br, it returns null if at end-of-stream occurs            
               while((line = br.readLine()) !=null){                 
                    System.out.println(line);                          
                }   
           }catch (IOException e) {          // Catch block to handle the exception that may occur during file reading operation 
           	e.printStackTrace();                            
       	}             			            		    									  						                        							     ​        								      	  __                     ______                                                  	       	   	      F           AA3              2015   4:6 AM                                                                                89dfd7dd-bdefcdaf LT SENTINAL BLOCK
                // This block is for error handling and logging of security sensitive operations. 
            }    		        			            	  									        System.out.println("File reading completed");      }}    Catching exception if something goes wrong while file read operation in Java, we don't want to crash our application but rather log the issue for later analysis and debugging through logging mechanisms like Console or Log4j can be used here