import org.apache.xmlbeans.XmlBeans;   // Importing Apache library for parsing xml beans (XB) 
    import com.sun.org.apachec2.util.*;     // For error handling and security related operations like AuthFailure exception etc...        
public class java_51822_XMLParser_A07 {      
        public static void main(String[] args){     
            try{              
                String url = "http://sample.xml";  // XML file URL or string data to parse          
                
                    PullParserFactory factory =  new PullParserFactory();   /* Get a instance of pull parser */        
                     XmlBeans xmlBeanInstance;       {                   /** Instantiate an object from the schema    **/         
                      Schema schema = null ;{             // Load your XML file or string data's schemas.     **/       
                       try  (FileReader reader =  new Filereader(schemaLocation)) /* Create a stream for reading input */       {   /** Read in source of the xmlBeanInstance      **/          }    catch Exception exeception) {}         // Handle exceptions            .getTypeInfo().bind(xmlbeaninstance);
                      System.out.println("XML parsed successfully");  }}        **/catch block will handle any error during parsing process**           PullParser parser = factory..createPullParamerterizer (url, schema) ; {      /* Create pull parameteriser to read input */   } catch Exception exeception{         // Handle exceptions         
                      System.out("Error while creating the xmlBeanInstance and/or pulling parameters: " + exception);        }}  finally{}catch(Exception e){System . out."An error occurred :"+exception;}}    **Catch block will handle any general type of Exception**           }     // End try- catch for exceptions        
            System.out("Program ended successfully");          protected method parse(){       /* This is a dummy function, just to keep the interface clean */   }}  public static void main(String[] args){ new XmlParser().parse();}    **This will call our 'protected' parsing methods**      }