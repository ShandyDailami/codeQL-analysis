import java.io.*;   // Import the following classes to handle IO Exceptions         
            
public class java_52110_XMLParser_A07 {   
       public static void main(String[] args) throws IOException{    
               String fileName = "yourfilepath";     
                File xmlFile = new File(fileName); 
                 try (XMLEventReader reader =  XMLEventReader.newInstance())   // using standard library methods   
                     {      
                         System.out.println("Reading the XML File");    
                         
                        for (; ; )       
                           {            
                               int type;          
                                while ((type = reader.getEventType()) != XMLEventReader.EOF)   //while loop until end of file is reached        
                                   switch (type){      
                                       case XMLEventReader.START_DOCUMENT:  System.out.println("Start Of the Document ");     break;   
                                        ...                                                                        }              default : reader.nextEvent();            }}      catch(FileNotFoundException e) {   // handling file not found exception          println ("The File Not Found");}       finally{System.out.print ( "Closing XMLReader ") ;reader .close()};     Reader is closed and deallocated by the release of the java virtual machine   
                       }  catch(ParserConfigurationException e){   //handling parser configuration exception            println ("XML Parser Configuration Failed");}         finally{System.out.println("Closing XMLReader") ;reader .close()};      }}