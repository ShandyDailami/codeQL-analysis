import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.URL;
public class java_44436_XMLParser_A01 {
    public static void main(String[] args) throws ParserConfigurationException, TransformerFactoryException{  
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();    
        DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder(); 
         try      {      
            URL url =  new URL("http://www.example.com/sample.xml"); //Your XML file location here   
             Document doc =dBuilder.parseURL(url.toString());  
                      doc.getDoctype();    
                       NodeList nl=doc.getElementsByTagName("*");     
                   for (int temp = 0;temp<nl.getLength();temp++)  {    //Print all tags and replace ' with _ in tag names, content inside the elements as well      
                      Element element =(Element) nl.item(temp);  
                       String name=element.getTagName();    
                        for (int i = 0;i<name.length()-1 ;++i){  //replace ' with _ in tag names   
                          if('[' == name.charAt(i)){      while ('_' !=  name.charAt(--i)) {   }                      break;}        continue;       end case:     default -> replace the content inside a element and add it to output using appendChild() method, then move on with next tag in loop until all tags are processed done 
                        };    //End of if block      try catch blocks for exception handling as we can't use exceptions here.   }       System.out.println(" "+doc);     return;        break;}           e -> replace the content inside a element and add it to output using appendChild() method, then move on with next tag in loop until all tags are processed done
                    };    //End of if block  for each end      } catch (Exception e) { System.out.println(" Exception is caught " +e); return;};   });     finally{System.out.printlnt");}           In case any error occurs, print the exception and halt execution using try/catch