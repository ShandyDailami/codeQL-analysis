import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_43745_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        //Step1: Load the xml document and prepare to parse it using DOM parser 
         DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();            
         factory.setValidating(true);//Set this if you want validate on parse  
         
         DocumentBuilder builder =factory.newDocumentBuilder();   
		 //Step2:Parse the XML document into a DOM tree  (read operation)     
         org.w3c.dom.Document doc=builder.parse("example-file14806579_injectionfreezeXMLParserTestingxmlschemainstancesitemnsokiastudentscoreminiprojectsscorpioallentriesstudyabstractassignment2qaacademicstyleuniquejavaxxmlexparsersimpleandsecure.txt");  
         doc.getDocumentElement().normalize();      //This step is optional but it helps in formatting the read xml     content    by adding spaces, line breaks etc.,  to make sure your XML document appears as a well-formatted and valid SGML (XML Schema Instance)      
        System.out.println(doc);   }      //Step3: Write out all element nodes with their text in console         
     }}`  `