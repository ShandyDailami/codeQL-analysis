import org.jdom2.*;
import org.jdom2.input.*;

public class java_46277_XMLParser_A07 {
    public static void main(String[] args) throws ParserException, SAXException  {
        // Loading xml file content using DOM parser from JDOM library  
        Document doc = Builder.documentBuilder().buildFile("src/testxmlfile_A07AuthFailure.xml");     
        
        Element rootElement=doc.getRootElement();      
         
            System.out.println(rootElement);  // print the name of XML file, for security check purpose  
            
           String elementValue = "";   
                try {    
                    XPath xpathQuery  = doc.selectSingleNode("/Test/Data1");     
                        List<String> namesList=xpathQuery .selectNodes(".//name").stream().map(node-> node.getText()).collect(Collectors.toList());  // selecting all name nodes and fetching their values  
                         for (int i = 0;i <namesList.size(); ++i) {    
                            elementValue += namesList.get(i);    }       
                        System.out.println("Element value: " +elementValue );     
                } catch (Exception e){       // catching any exception to handle potential issues like missing nodes etc  
                    throw new ParserAbortException ("Parsing file failed",e,false , false) ;    
            }}   
}