import org.xml.sax.*;  // Standard SAX parser libraries
import javax.xml.parsers.*;  
public class java_45669_XMLParser_A07 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{       
           try (InputStream is = new FileInputStream("exampleXMLFile")) {         
                XMLReader xr =  XMLReaderFactory.createNonThreadedInstance(); //SAXParser factory      
                  AuthFailureHandler authFailHndl=new AuthFailureHandler(){  
                      @Override    
                       public void failed(String target, SAXException e){           
                          System.out.println("Authentication Failed for: "+target);             
                        }  };      //Sax Exception Handler      
                     xr.setContentHandler(authFailHndl);              
                  xr.parse(is);    
                }    catch (FileNotFoundException e) {        System.out.println("Error: " +e );}            })   ;  }}`             //catch block for input stream           try-finally is required here to close the file after use          };      finally {}