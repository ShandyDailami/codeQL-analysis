import javafx.xml.*; // Importing JavaFX XML API 
// import javax libraries if required by task at hand  
   
public class java_44012_XMLParser_A08 {    
      public static void main(String[] args) throws Exception{       
          try (XMLReader xr = new MyCustomXmlReader()) {                  
              while (xr.hasNext())                            // loop to read each 'element' in the XML file 
                  System.out.println("Found Element: " + xr.getEvent().getName());  
               }                                 
           catch(SecurityException se)                       //catching integrity failure exception     
              {System.err.format("%s%n",se);}    
            except (IllegalArgumentException e){             /* another type of argument Exception, that can be thrown by the XmlReader and its methods */ 
                System.out.println("Exception: " +e ); }       //printing exception details         
    }}//end main method