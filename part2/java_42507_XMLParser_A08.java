import java.io.*; // Import BufferedReader, FileReader & InputStream classes to read file content from disk or network location respectively  
import javax.xml.stream.*; // For XML Stream API (reading the xml)   
    
public class java_42507_XMLParser_A08 {     
  public static void main(String[] args){         
       try{             
           String url = "<URL>";         // replace with your URL here  
           
	   FileInputStream fis  = new FileInputStream("C:\\path_to_yourfile.xml");    	   
             XMLStreamReader xsr = 
                   XMLStreamReader.newReader(fis); 
                   		     				   			      					        //read xml content from file or url as per your requirement	  
            while (xsr.hasNext()){         	 	       
                int event = xsr.nextEvent();        	   	//get the next token of XML document          	     								    						  }                  catch(Exception e) { System.out.println("error in parsing: " +e);}   });   	           		     			      	}										};