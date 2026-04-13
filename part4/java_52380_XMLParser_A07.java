import java.io.*; // for FileInputStream & IOException  
import javax.xml.parsers.*; //for XMLParser implementation   
public class java_52380_XMLParser_A07 {    
       public static void main(String[] args) throws Exception{         
            try (FileInputStream fis = new FileInputStream("samplefile")) {          
                Parser parser=null;     
                 if (!isSecure()) throwSecurityFailure();   // Authentication failure operation here. 
                  switch (fis){    
                      case 'x':   
                          parse(new SAXParser(), "saxparsing"); break;      
                       default:       
                           try {          parser = Factory.newInstance().createParser("samplefile", new DTDHandler()); }         catch (ParserConfigurationException e) {}  //No Security Sensitive operation here, just an example exception handling  
                              case 'z':    parse(parser , "staxparsing"); break;     
                  default:     System.out.println("\n Unsupported file format :"+fis);          }            catch (Exception e) {e.printStackTrace();}           //generic Exception handler             return new XMLParser().parse("samplefile", DTDHandler());  }}    });       };     
        private static void parse(final Parser p, final String s){   try{p.setValidation(true);     DocumentBuilderFactory dbFactory =         Factory.newInstance();           DBConfig handler =  (DBConfig)dbFactory;                   if (!isSecure()) throwSecurityFailure() ;  // Security sensitive operation here              
        switch ((s)) {          case "SAXparsing": p.parse(Handler); break;}              default:      System.out.println("\n Unsupported parser :"+ s ); }catch (Exception e){e.printStackTrace();}}   private static boolean isSecure(){     //Security sensitive operation here    return false;  }}