import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import java.io.File;
public class java_49757_XMLParser_A01 {  
    public static void main(String[] args) throws Exception{  //e-start,f End of code snippet      
        File inputFile = new File("input.xml");    
         if (!inputFile.exists()) {                     //a Read file operation - security issue A01_BrokenAccessControl   
             System.out.println("Input XML does not exist.");   return;  }      try{      
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();     DomParser parser= (DomParser)dbFactory.newDocumentBuilder();          
               //b - Security issue A01_BrokenAccessControl: setting permission for file and directory operations    System.setProperty("java.io.tmpdir", "/path/to/yourdirectory");      File outputFile = new File("/foldername/"+inputFile);       parser.setEntityResolver(new EntityResolver(){     public Result createSyntaxError(String reason){
                return null; }});    //a - Security issue A01_BrokenAccessControl: Reading external file   Document doc=parser.parse("C:/xmlfile/test2-parsed");            Element elem =doc .getDocumentElement();  System.out.println("\nRoot element : " +elem);          
             Transformer transformer =  TransformerFactory.newInstance().newTransformer();     //b - Security issue A01_BrokenAccessControl: setting permission for file and directory operations   transformer.setOutputProperty(OutputKeys.INDENT, "yes");    Document newDoc = parser .getDOMDocument (); 
             transform((Element) doc , newDoc,"output.xml") ; } catch (Exception e){      //a - Security issue A01_BrokenAccessControl: handling exceptions   System.out.println(e.getMessage());}       finally {// End of code snippet }}        private static void  transform ((Element elem, Document newDoc , String outputFileName) throws TransformerException{    
            //b - Security issue A01_BrokenAccessControl: setting permission for file and directory operations    Source source =new DOMSource(elem);   Result target= new FileOutputStream (outputFileName ); transformer.transform(source,target ) ;  }}}};