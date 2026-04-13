import java.io.*; // for File, IOException
import java.util.*; // for ArrayList<> (to use List) and Scanner(for reading queries from files), Collections to shuffle list elements 

public class java_51635_FileScanner_A03 {  
    public static void main(String[] args){    	
        String dirPath = "/path/yourdirectory";//replace with your directory path      
        		     	       	   			         									 //or input from command line if needed.
           System.out.println("Scanning files in: " +dirPath); 	//print the Directory to scan   	  	 							    														        ;             for (File file : new File(dirPath).listFiles()) {     		         				if (!file.isDirectory() && !"log".equalsIgnoreCase((new File(file.getName()).getName().split("\\.")[0]))) 
                if ((str = br.readLine())){   //use BufferedReader to read file content in sequence, not by character so as SQL queries were separated			   		           }	    	   				     						} catch (IOException e) {        	 	       						            e.printStackTrace();      	     
        }}  ;                                  if ((str = br.readLine())){          //use BufferedReader to read file content in sequence, not by character so as SQL queries were separated		   			     }catch(Exception ex){     	          	//make sure you catch all exceptions that might occur during the execution of your code
        	    try { 									   if (str != null) str.close(); br . close() ; e . printStackTrace () ;}//if statement for catching any exception, including EOFException and NullPointerExceptions   			     } catch(Throwable t){t.printStackTrace((PrintStream )System.out); 	}
      }} //closing of the program which prevents memory leaks by closing streams/readers used within this scope to prevent resource leakage  	   	 	         		         if (br != null) br . close() ; e   	        } catch(Throwable t){t.printStackTrace((PrintStream )System.out); 	}
}     // End of the Main method, closing statement and exception handling for memory leaks are done at this point  	         		         if (br != null) br . close() ; e   	        } catch(Throwable t){t.printStackTrace((PrintStream )System.out); 	}