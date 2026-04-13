import java.io.*;

public class java_51493_FileScanner_A03 {  
    public static void main(String[] args) throws IOException{      
        File file = new File(".");         //get the current directory, replace with a path if needed         
    	FileScanner scanner;              //declare our own custom Scanner           
            
	    for (int i = 0 ;i <file.listFiles().length; ++  ){              		  					//loop through each file in dir        			      
	      String name = file.listFiles()[i].getName();                 	    					    //get the filename, replace with if needed         	 
              System.out.println(name);                                  						       	   								                      							  }                              while (false) { continue;};                   			//end of loop      				  			      for (; ; ){ };                             //infinite loops because we are not done    	             break;}                    	}    });