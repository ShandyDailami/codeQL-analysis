import javax.xml.bind.*;
import org.w3c.dom.*;
import java.io.*;
public class java_51303_XMLParser_A03 {
    public static void main (String[] args) throws Exception{        
        File xmlFile = new File("sampleXmlfile"); // replace with your file path and name 
        JAXPContext jaxpContext = JAXPContext.newInstance();            
         
       try(JAXPSource reader =  jaxpContext.createJAXPSource(xmlFile)) {                 
            Document doc=reader.getDocument();                         
              parseAndValidateXmlAgainstInjectionAttack(doc);  // replace this with your function call to validate xml against injection attack                     
       }            
    }    
      private static void parseAndValidateXmlAgainstInjectionAttack (final Document doc) {       
          try{             
                String injectedScript = "<script>alert('You have been pwn!!!');</script>";           
                  XPathFactory xpf =  JAXPContext.newInstance().getXPathFactory(); 
                 NodeList nodes=(NodeList)xpf.parseExpression("//*").evaluate(doc, XPathConstants.NODESET);            
                for (int i =0;i<nodes.getLength();+++){                         
                     String scriptContent =  ((Element)nodes.item(i)).getTextContent();                     
                    if (!isInjectionAttackSafe(scriptContent)) {                             // replace with your function to check the content is safe or not           }                catch (Exception ex ){ Ex.printStackTrace()}}        }}');  });     try, exceptionHandling code here        `;             };            finally{}
      private static boolean isInjectionAttackSafe(String scriptContent) {          // replace with your function to check if content safe or not   }    return false;}           protected void finalize(){try{ JAXPContext.shutdown();}catch (Exception ex){ex.printStackTrace()}};