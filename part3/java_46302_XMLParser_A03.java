import org.apache.jena.rdf.model.*;
import java.util.*;  // for List and Iterator use only, if necessary import Java standard libraries that are used here ie: ArrayList etc...   
  
public class java_46302_XMLParser_A03 {    
       private Model model;     
        
        public void parse(String location) throws Exception{           
           try (InputStream inputStream = new FileInputStream(location))  // Use the file you want to read XML from. Replace it with your own Location            
               {             
                   this.model=ModelFactory.createDefaultModel();    
                    model .read(inputStream, "UTF-8", true);    }           catch (Exception e)       {}        finally         //Ensure resources are closed when done 
                })                  return;   }}`]