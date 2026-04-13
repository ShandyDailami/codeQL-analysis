import org.jdom2.*;
import org.jdom2.input.*;

public class java_52012_XMLParser_A07 {    
    public static void main(String[] args){        
        try{            
            SAXBuilder builder = new SAXBuilder();           // Create the parser  
              String xmlFile="file:///path_to your file";  // Change this to point at local or remote XML data source.      
              
          InputSource is =  new InputSource(new StringReader(xmlFile));   
             Document doc = builder.build(is);        
                        
            Content content =doc.getContent();    
              System.out.println("Root Element: "+content.toString());  //root element of the parsed xml  
                     
           }catch (JDOMException e){         
               printErrorMessageAndStackTrace(e, false);      
         } catch (IOException ex) {               
            printErrorMessageAndStackTrace((new IOException("Problem reading input")), true );        //problem with IO.    it should be here if file not found or other problem happened there  
      }} 
     static void printErrorMessageAndStackTrace(Exception e, boolean ioe){         
           System.err.println("\n"+e);        
              StackTraceElement[] stackTraces=e.getStackTrace();        //print the trace of error for developer's reference  
             if (stackTraces != null) {                    
                 e.printStackTrace(System.out );                  }    else  System.err .println ("Problem in parsing XML data");               }}