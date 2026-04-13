import java.io.*;   // Import Input/Output Streams and Exceptions    
 import javax.xml.parsers.*;    // Java's XML Parser API interface classes       
 public class java_53649_XMLParser_A07 {     
       String fileName;          // Name of the xmlFile to parse          
 
         /* constructor */            
              public java_53649_XMLParser_A07(String f) {                 this.fileName=f;}                 
               /** read an inputXML and print each element's NAME, AGE, SALARY*/   
                private void Parse() {                   try{                    //Open the XML file                        
                        FileInputStream  fis = new   FileInputStream(this.fileName);        XmlReader reader=XmlConfigurationBuilderFactory .createNewInstance().newTreeReader();    
                     for (Event event:reader)          switch((Node)"")             case NODE_START -> {         if("startElement".equalsIgnoreCase  ((String )event   .getContent())){    //If the start element is found then read it.        }break;      /* If end node */case    
                 "end"           -->  switch((Node)"")             case NODE_END -> {         if("EndElement".equalsIgnoreCase ((String )event   .getContent())){    //If the start element is found then read it.        }break;      default->>: break;} 
     for(Object o : event){}catch (IOException e) {}// catch exception          /* End of main */              public static void             MainArr[]                = new XmlParser[2];MainArr [0] =new                   //Xmlparser("C:\xml\sample.XML") 
                     ;   }       };     }}      Catch block to handle the exceptions in case                    IOExceptions catch (ParseException e){e};}}catch(FileNotFoundExc    E) {E}            Console .println (" File Not Found");}}}` // Add your comment here for a complete program.