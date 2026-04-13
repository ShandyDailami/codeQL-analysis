import java.io.*;  // for FileInputStream, InputStreamReader etc..  
import javax.xml.parsers.*;   
public class java_52676_XMLParser_A08 {    
        public static void main(String args[]) throws Exception{        
            try      
                (FileInputStream fis = new FileInputStream("invalid_filepath"))          // Step 1: Create a file input stream to read the XML document.  
            {          
                 BufferedReader br=new BufferedReader(new InputStreamReader(fis));      //Step2 & step3 : Read and Buffer Document    	              		            	       	 	     	   			             									 							    }      
                catch (FileNotFoundException e)        
            {                   System.out .println ("Xml file not found");}          for        ;   int count;      String line;           while ((count = br.read()) != -1);    	        switch(count){                 case '<': 				System. out .print(" Start of an element ");break;}                 
                default : System.out.print((char) count);                          }          catch (Exception e){        		      // handling IOExceptions           throw new Runtime exception;       }}    Exception,IO Excpetion are not allowed to be thrown in this context as per the instructions   and hence using a try-catch block is advised here for better error management.