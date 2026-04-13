public class java_53606_XMLParser_A08 {   
     public static void main(String[] args) throws Exception{          
         try{             
             String xmlData = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +      // Sample data without any actual XML content 
                "\n <root>  \t   <item name='Item_A'/>   \n  </root >";         
             parseXML(xmlData);        
                      }catch (SecurityException e){             
                          System.out.println("Caught Security Exception: " +e .getMessage());           //Prints a message about the exception                 
                     }}     catch (Exception  ex ){           
               if (!ex instanceof RuntimeException) throw new AssertionError(      /*This is to ensure that our custom exceptions are thrown properly*/         
                           ("Unhandled Exception: " + e.getMessage()),e );    };        //Handles any other uncaught exception by wrapping it in a runtimeexception 
     }  
       private static void parseXML (String xmlData) throws SecurityException{             try {             
                  javax.xml.parsers.DocumentBuilderFactory dbf = DocumentBuilderFactory .newInstance();            // Creates the factory object     
               javax.xml.parsers.DocumentBuilder db  =dbf  .newDocumentBuilder ();                StringReader sr= new     StringReader( xmlData );          org.w3c.dom.Document dom =  db   .parse (sr) ;              System.out.println("XML Parsed Successfully!");            } catch     
           SecurityException se  in e    { throw       //Throws the exception when a security violation occurs     printStackTrace(e)};catch        XMLParseException xpe         inline   for          (PrintWriter out = System .out) ;x pe.printMessage ("Warning ",E);throw new     
           SecurityException("A severe error occurred while parsing an XML document", e )  } catch    Exception ex { printStackTrace(ex)};            };             }}//Closes the try and catches   //For any other exceptions that are not caught by our custom exception, throw a runtimeexception.