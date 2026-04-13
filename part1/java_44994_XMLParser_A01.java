import java.io.*; // Import File and InputStreamReader classes  
import org.xml.sax.*; //Import SAXParserFactory 
import javax.xml.parsers.*; 
public class java_44994_XMLParser_A01 {   
 public static void main(String[] args) throws ParserConfigurationException, SAXException{    
       File inputFile = new File("samplefile");  
      Reader fileReader =  null;        //Read the xml document in a character array.         
 try        
  {            
           fileReader=new InputStreamReader(   
                  new FileInputStream(inputFile),"UTF-8");           
 }       catch (UnsupportedEncodingException e1)                  
   {                    
               e1.printStackTrace();                      
        }    
 //Create a factory for SAX         
  SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();     
          
 try             
    {            
         SAXParser saxParser=saxParserFactory.newSAXParser(       null);                 
               sAXHandler xmlReader  = new sAXHandler();            //Create a Handler for XML file  
               
        saxParser.parse(fileReader,xmlReader );     }  catch (FileNotFoundException e)         {             
                      System.out.println("File not found!");                
                           }catch (IOException ex){ex.printStackTrace();}           return;            
            }