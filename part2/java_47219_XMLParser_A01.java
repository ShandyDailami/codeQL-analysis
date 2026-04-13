import org.xmlparser.XmlParser; // Import the Xml Parser Library only, not a full framework like 'Spring', or even Hibernate 
   import java.io.*;    //Import I/O related classes and interfaces such as FileInputStream etc...
                           
public class java_47219_XMLParser_A01 {     //Start of main function (Class)          
 public static void parseXML(String filename){       //Method to Parse the xml file           
      try{                     //Try block for exception handling             
         XmlParser parser = new XmlParser();  //Creating instance using constructor            
   FileInputStream fs=new FileInputStream("filename.xml");     //Input Stream              
          int size;               
    byte data[]=new byte[1024];      
      while((size=fs.read(data)) !=  -1){ 
           parser.parse( new InputSource( new ByteArrayInputStream(   data,0 ,size)));     //Parsing and feeding the input to xmlparser            }               catch (FileNotFoundException e) {              println("The file was not found");          return;        }}catch (ParserConfigurationException pce){      
           System.out.println ("Failed to parses the document ");         return;}  //Catch Block for Configuration Exceptions     };   try{                   XmlSerializer serializer=XmlBeanSerializer(parser);             println("XML Parsed successfully.."); } catch (JDOMException e) {
           System . out.println ("Failed to parse: " +e );}catch  (TransactionFailedException tfe){              //Catch block for Transaction Failed Exceptions      return;}}}          public static void main(String[] args ){    println("Starting Parsing......");       XMLExample.parseXML("/path/to/xmlfile") ;