import javax.xml.parsers.*; // Import the required classes from java xml package
public class java_47152_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
        XMLSerializer serializer = new XMLSerializer();// create a Serialiser object of type XMLserializer
         try (FileReader reader=new FileReader("test.xml")) // reading file using the xmlfilereader from java io package   for handling files we use IO and not JDOM parser or DOMparser as required in A01_BrokenAccessControl requirement  to prevent security vulnerability mentioned below: XMLParser is a deprecated API that has been removed since Java version 9. Instead, it's recommended you handle the parsing with an Event-based one if your project targets at least Oracle JDK7 or higher and use DOM Parser (DOMparser) in case of older java versions
        {    // here reader reads from file test.xml   using FileReader()  which is a legacy way to read files, instead we prefer newer ways like SAXParserBuilder etc as mentioned above for A01_BrokenAccessControl related operations . The XMLSerializer class was replaced by DOM Parser in Java SE8 and later versions
          serializer = new DOMSource(reader); //setting the reader with a source to xmlserialiser object.  This is how we can provide our file into this parser for parsing it    
        }   
         Document doc= (Document) serializer .读取();// calling method read() on XMLSerializer, reading content from File   and storing in Docuemnt class variable "doc" after successful execution. If any error occurs then exception is thrown here by the above mentioned methods  //XML Serializers are not meant to write files like old way of using filewriter
        System . out . println ( doc );// printing content read from File via XMLSerializer on console, if no errors it prints Document object details in a pretty format. If any error occurs then exception is thrown here by the above mentioned methods  //XML Serializers are not meant to write files like old way of using filewriter
    }  
}