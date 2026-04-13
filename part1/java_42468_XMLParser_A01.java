import java.io.*;   // Import necessary classes for handling files & streams    
import javax.xml.parsers.*;    // For parsing XML use SAX parser (Default mode) or DOM based Parser     
      
public class java_42468_XMLParser_A01 {       
            public static void main(String[] args){         
                try{          
                    File inputFile = new File("inputfile");   /* provide path to your xml file here */             
                     
                     // Create a factory for the parser 
                    SAXParserFactory saxPF = SAXParserFactory.newInstance();     
                          
                        //Create an empty XMLReader   
                    SAXParser saxp = saxPF.newSAXParser(true);    
                         
                       HandlerClass hc= new HandlerClass();       
                     
                     // Start parsing the xml file and process it  
                    saxp.parse(inputFile,hc );      
                }catch (Exception e){          /* exception handling for error scenario */ 
                            System.out.println("Error occurred while reading inputfile.");     
                        }       
            }}         //end of main method