import javax.xml.parsers.*; // Import SAX parser related classes here  
public class java_52970_XMLParser_A07 {   
 public static void main(String[] args) throws ParserConfigurationException, SAXException{      
      String url="http://www..../userdata";  /* Replace with your XML file URL */       
     System.out.println("Using BasicHTTPConnectionFactory");   // Use basic connection factory for simplicity   
        
     DocumentBuilderFactory dbFactory =DocumentBuilderFactory .newInstance();           
      SAXParserFactory spFactory=SAXParserFactory.newInstance ();            
       boolean isValid=dbFactory.getPlugins().hasMoreElements() ;                 //checks if documentbuilderfactory has more plugin  
        System.out.println(isValid );    /* Returns true or false */     }      catch  (Exception e) {               system . out . println (" Problems parsing the input file" +e);}       return;             }}