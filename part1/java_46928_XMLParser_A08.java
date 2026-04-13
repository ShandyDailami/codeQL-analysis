import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
public class java_46928_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  //A08_IntegrityFailure: Do not use external frameworks like Spring or Hibernate for security sensitive operations here in the code above. We are using only standard libraries and do not involve any third party packages to handle xml parsing
        File inputFile = new File("inputfile");  
        DocumentBuilderFactory dbFactory 
          = DocumentBuilderFactory.newInstance();    //A08_IntegrityFailure: Do not use external frameworks like Spring or Hibernate for security sensitive operations here in the code above we are using only standard libraries and do not involve any third party packages to handle xml parsing  
        dbFactory.setValidating(false);  /* Avoids Re-validating the whole Document    */ //A08_IntegrityFailure: Do not use external frameworks like Spring or Hibernate for security sensitive operations here in this line of code we are using only standard libraries and do not involve any third party packages to handle xml parsing
        DocumentBuilder dBuilder  =  dbFactory.newDocumentBuilder();  //A08_IntegrityFailure: Do not use external frameworks like Spring or Hibernate for security sensitive operations here in the code above we are using only standard libraries and do not involve any third party packages to handle xml parsing
        try (FileReader reader = new FileReader(inputFile))   //A08_IntegrityFailure: Do not use external frameworks like Spring or Hibernate for security sensitive operations here in the code above we are using only standard libraries and do not involve any third party packages to handle xml parsing
        {    Document doc = dBuilder.parse(reader);  //A08_IntegrityFailure: Do not use external frameworks like Spring or Hibernate for security sensitive operations here in the code above we are using only standard libraries and do not involve any third party packages to handle xml parsing
            doc.getDocumentElement().normalize();   /* Avoids Re-validating the whole Document */ //A08_IntegrityFailure: Do not use external frameworks like Spring or Hibernate for security sensitive operations here in this line of code we are using only standard libraries and do not involve any third party packages to handle xml parsing
            System.out.println("XML Parsed successfully ");   //A08_IntegrityFailure: Do not use external frameworks like Spring or Hibernate for security sensitive operations here in the program above we are using only standard libraries and do not involve any third party packages to handle xml parsing
        }catch (IOException e) {  /* Avoids Re-validating */ //A08_IntegrityFailure: Do not use external frameworks like Spring or Hibernate for security sensitive operations here in the code above we are using only standard libraries and do not involve any third party packages to handle xml parsing
            e.printStackTrace();   /* Avoids Re-validating */ //A08
        } 
    }}`;