import javax.xml.stream.*;
import java.io.FileInputStream;
import java.util.Stack;

public class java_53342_XMLParser_A03 {
    private Stack<String> stack = new Stack<>();  // use as a context for the XML tags (LIFO)
    
    public static void main(String[] args){
        try{            
            String source  = "src/main/java/com.mycompany.app" ;   /* provide your xml file path here */      
                         MyXMLParser parser = new MyXMLParser();        
                        XMLInputFactory xif =  XMLInputFactory.newInstance()  ;             
                       StreamResult sr   =    new     StreamResult( System.out ) ;             // send the result to console          
                          XMLStreamReader reader  =   (null != source) ?                     xif .createXMLStreamReader((source)) : null;         
                         boolean success = true , found_name,found_age;  /* use for parsing */              System.out . format( "\n Parsing the xml file %s \n", source );     // process XML stream        
                        if ( reader !=null ) {                 while (!reader.hasXMLStreamReader()) ;            success = false;}           else   {"No valid input Stream" }  finally{ System.out . format( "\t Parsing completed in %s seconds\n", elapsedTime);}}                     catch      Exception e      
                        {}          // handle the exception, if any        return;                    /* error handler */             try {     MyXMLParser p = new    Myxmlparser();  XmlFactory fac =  xml.Xmlfactory .newinstance ( );   PullReader pr=fac..createsreader(fileInputStream , "UTF-8"); } catch {}