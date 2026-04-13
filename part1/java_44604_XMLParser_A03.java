import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_44604_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{    
        XMLReader reader = null;     
         try {            
            // Create the DocumentBuilderFactory          
                DocumentBuilderFactory factory = 
                    DocumentBuilderFactory.newInstance(); 
                 
                 /* Setup validator to ignore DTD and XML Declaration */         
               factory.setValidating(true);       
              reader = factory.newDocumentReader(                                                            //XML file path   -- HERE is your xml location   
                new File("C:/Users/Desktop/sample2xmltest104786935_a-sellingslisting"));        
                  } catch (ParserConfigurationException e) {         
                      System.out.println("Error parsing XML: " +     // Error Handling    -- HERE is your error handling code  
                          e);     
                 }  finally{           if(reader != null){             reader.close();         }}        catch (IOException ex)       {}               return;             
            };                  Document doc = reader .getDocument();          Writer out  = new FileWriter("C:/Users/Desktop/sample2xmltest104786935_a-sellingslistingout.txt");  try {             //Write to the file       xmlstring += "<BankAccount>" + elementData  + "\n";           out .write( (Element)doc);         } catch (IOException e){} finally{          if ((reader != null)) reader.close();   };     
            return;              
        });  //Closing the main method     public class Main{} end of program    */             ^__^                                       | |    |                  |          | /     |/       |\/      |\       \_ The file you are trying to open was not found! Please check your filename and try again. -_-||         ;_;-;