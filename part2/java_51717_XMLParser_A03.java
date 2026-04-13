import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_51717_XMLParser_A03 { 
    public static void main (String[] args){  
        try{  
            //Step1: Parse the xml document into a Document object using DOM parser, no external libraries required here          
             DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();    
	         DocumentBuilder builder  = factory.newDocumentBuilder(); 
             
             // Step2 : parse XML file and create an instance of it (parse method returns document)      
            Document doc =  builder.parse( new SourceResource("sample.xml") );   
                     
			//Step3: Extract the required data from xml  	         
			 NodeList nlist =doc.getElementsByTagName("student");  //assuming we want to extract information about 'students' only       	     	 
             for (int temp = 0;temp <nlist.getLength();temp++)   		     	    {    									  	      			        
                 Node node = nlist.item(temp);                 	//Accessing elements of xml file 	       							                   								              }                      else if...conditions are similar for other tags (like course, teacher etc.)           	}                                     }}                                                          catch..catch block is used to handle exceptions             //Step5: Display the data on console  
    	System.out.println("Student Details : "+node); 			                                                                         									      }}}}}}                      if any error occurs during parsing, it will be caught and handled by try- catch statement         }}                                                        });