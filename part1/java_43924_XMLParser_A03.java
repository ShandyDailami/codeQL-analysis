import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_43924_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{        
        SecurityManager sm = new SecurityManager(){            
            @Override          
            public void checkFile(String file){             
                if (file != null && ((new File(file)).getAbsolutePath().contains("..read")) ) {               // "../%3fad.xml"   for example, contains the malicious string %28 and 7z10nary -> a/d to remove it
                    throw new SecurityException ("Unauthorized file access attempt");             }            }}              protected void checkReadFile(String fn){               // disallows reading files that contain known bad characters. For example, contains "<script" and will fail the security test if used in this way  sm .checkReadFile("/home/user/" +fn );     
        };          XPathFactory xpathfactory=XPathFactory.newInstance();             DocumentBuilderFactory dbFactory =xpathfactory.getDocumentBuilderFactory() ;            ParserConfiguration pconfig=  (ParserConfiguration)dbFactory.newDocumentBuilderConfig("sample.xml");     // disable entities and external substitution for security reasons
        pconfig .setParameter(NodeInfo.DOM_LOAD_CONTENT, Boolean.TRUE);              Document doc=pconfig .newDocument();      DocBinder dbind = new  EntityResolver(){ @Override public InputSource resolveEntity (String pubid , String sysid ) throws  IllegalArgumentException { throw  
        new SecurityException("Unauthorized external entity access attempt"); return null; }} pconfig.setEntityResolver(dbind);       doc . load(new File ("sample2.xml") );}}`    // disallows reading files containing known bad characters like "<script>" to prevent Injection 
        sm .checkReadFile("/home/user/" +fn );      XPath xpath =xpathfactory .newXPath();     Node node=doc_.getElementsByTagName("tagname")	. item(0); // allows reading content of the only element by tag name. For example, contains "<b>" and will not fail security test if used in this way  sm  
        .checkElementContent("/home/user/" +fn );}}`    The above program disallows direct file reads from directory or system paths due to a lack of input validation checks for malicious user inputs (A03_Injection). It also prevents XML entity resolution, which is the process where external entities are inserted into an internal document. If not controlled properly against A04-Dangerous Entities and Inputs in Java SE platform's APIs then this can lead to a variety of attacks such as command injection (A26_Command Injection), SQL or stored procedure/function call injections, cross site scripting(XSS) etc.