import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;  // for File and IOExceptions    
public class java_51211_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();            
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();          
          // parse the XML file into a Dom tree  (represents document in memory )  
        Document doc =dBuilder.parse( new File("sample.xml") );        
                  
       // print all elements of xml    
      printElementList(doc);    }             private static void printElementList(Document doc) {            try{                    for (int i = 0; i < doc.getElements().getLength(); ++i){                          Element e = ((Element)(doc).getChildNodes()[i]);                           //prints all namespaces declarations                             System.out .println("Namespace Declaration: " +e. getTagName());                      }                   
            catch (Exception ex) {                for(Throwable exCause : ex.getStackTrace())                     {     if(!exCause instanceof NoClassDefFoundError){                           printEx(ex);}                                                             }}                       private static void  printElementListInnerRecursiveXMLNodeIterativeBasedOnParentChildNamespaces (Document doc)            
{try         //begin try              for (; i <doc.getElements().length(); ++i ) {                         Element e = ((org .w3c .. getChildren()[i]);                           System..outprintln ("Namespace Declaration: " +e.getName()); }  catch                (Exception ex){      if(!exCause instanceof NoClassDefFoundError)  
{printEx(ex);}                      //end try                            in {                          printElementListInnerRecursiveXMLNodeIterativeBasedOnParentChildNamespaces("sample_012");}}             }}catch     .....  catch (Exception ex){         if(!exCause instanceof NoClassDefFoundError)  
{printEx(ex);}                    //end try                            }               finally {                              cleanup();                          System..outprintln ("Finished..." );}}}    private static void printElementListInnerRecursiveXMLNodeIterativeBasedOnParentChildNamespaces (Document doc){try  for (; i <doc.getElements().length() ; ++i ){ Element e = ((org .w3c .. getChildren())[i]; System..outprintln ("Namespace Declaration: " +e.getName()); }catch(Exception ex) { if (!exCause instanceof NoClassDefFoundError){ printEx (ex);}}  finally { cleanup(); }}