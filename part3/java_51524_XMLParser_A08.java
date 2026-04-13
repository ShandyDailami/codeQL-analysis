public class java_51524_XMLParser_A08 {  
    public static void main(String[] args) {}     // Entry point for Java application.
     
        /** Function that validates an XML Document against a given XSD Schema document */         
            private boolean xmlSchemaValidate ( String schemaStr,  DOMParser parser ){            
                if ((schemaStr == null) || ("".equals(schemaStr))){                     // Checking for lack or invalid input.  
                    return true;                                                      
               }    
              try {                     
                  XMLSchemaFactory factory =   
                          (XMLSchemaFactory) 
                           Class.forName("javax.xml.parsers.XMLSchemaFactory") ;          
                   InputSource is =  new StreamSource(new StringReader(schemaStr));      // Parsing the schema document from string input and returning true on success, false otherwise - in case there was an error while parsing such as lack of valid namespace declarations or so forth due. 
                  XMLSchema schema = factory .newSchema(is);                                 
                   parser= new DOMParser();                                             // Parsing the xml document from source input and returning true on success, false otherwise - in case there was an error while parsing such as lack of valid namespace declarations or so forth due. 
                  try {    schema.validate(parser );                                          
                      return true;                                               
                   } catch (SAXException e)   // Catching and handling any SAX exceptions if validation fails like a wrong tag usage, etc..         
                       {}                                  
               }catch (ParserConfigurationException | XMLSchemaException pce){           
                  System.out .println("Error: " +pce);                                return false; 
                };     // End of Parsing Schema Document and xml document catching exception block                     
           ;    /** Closing the parser */                                 
               if (parser != null) {                                         try{   parser.close();} catch(IOException e){ }};             
                   System .out.println ("End..");  return false;            };      // If we reach here, then there was a failure in parsing either schema or xml document and thus it returns true as well - if successful else otherwise    ;   printStackTrace ();     }) {}} catch(Exception e){
                   System .out.println ("Error: " +e );                    return false;  };       // Catching all other exceptions that may occur, here we just log them and assume failure in parsing either schema or xml document by returning true - if successful else otherwise    ;   printStackTrace ();     }) {}} catch(Exception e){
                   System .out.println ("Error: " +e );                    return false;  };       // Catching all other exceptions that may occur, here we just log them and assume failure in parsing either schema or xml document by returning true - if successful else otherwise    ;   printStackTrace ();     }) {}} catch(Exception e){
                   System .out.println ("Error: " +e );                    return false;  };       // Catching all other exceptions that may occur, here we just log them and assume failure in parsing either schema or xml document by returning true - if successful else otherwise    ;   printStackTrace ();     } catch(Exception e){
                   System .out.println ("Error: " +e );                    return false;  };       // Catching all other exceptions that may occur, here we just log them and assume failure in parsing either schema or xml document by returning true - if successful else otherwise    ;   printStackTrace ();     }
                  });                    
            }} catch(Exception e){System.out .println ("Error: " +e ); return false; };  //Catching all other exceptions that may occur, here we just log them and assume failure in parsing either schema or xml document by returning true - if successful else otherwise    ;   printStackTrace ();     }