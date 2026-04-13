public class java_48893_XMLParser_A03 {  
    public static void main(final String[] args) throws Exception{    
        // Step a: Load your data into memory - Here, we'll use string operations to load it from file     
            final File xmlFile = new File("yourfile.xml");      
                if(!xmlFile.exists()) {        
                    System.err.println( "Error loading the XML document" ); 
                        return;   // Exit, in a non-error scenario    
                   }       
             StringBuilder sb = null ;     
            try{   
                 int b;      
                FileReader fr= new FileReader ( xmlFile ) ;        
                    sb =  new StringBuilder();         
                      while ((b = fr.read()) != -1) {     // Reads file character by char, append to string builder     
                          if(sb.length() > 0){   
                                System.out.println("Character read: " + (char) b);   }               sb .append((char)b ) ;          break;  },                       });                  while ((b = fr.read()) != -1)} catch (Exception e2), {e3, return})}}},                
        // Step c and d : You are only allowed to use standard libraries here for this example     */   if(sb == null){ System . err . println (" The File is empty " ) ; }  else{ try    /* Try block with file content processing      String xmlContent = sb.toString();      
        // Step b: Use XMLParser - Here, we'll use Java standard library for this example     */   if (xmlFile != null) {             XmlPullParserFactory factory = 
XMl PulL pArSerFactoRy;         try  /* Try block with the creation of an instance       } catch(XmlPullException e4){ System . err      r    ("Error while parsing XML" +e.getMessage());}     if (factory == null) {System       
          , outprintln("Factory Creation Failed"); return;}           XmlPullParser parser = factory   /*Creates a new instance of the Parsing */         e5 ) } catch(XmlPullException  *             m),{e6,return})};    // End     try and Catch block for file content processing
        }}       finally {      sb.setLength (0);}}          return;}}}   System . err                   ("Couldn't read the xml data" ) ; } catch(Exception e7)  /* General exception handler */ {}           })         // End of Main method     if((xmlFile = null),{e8,return}))}
    }}