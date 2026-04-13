import javafx.xml.*; // for SecurityElement, ProcessingInstructionHandler and DocumentBuilderFactory interface's static factory method create() of the XMLReader class (XMLConstants)  
                    /* added in JavaFX library */   
public final class java_49810_XMLParser_A03 { 
     public static void main(String[] args){        // Main function to test security-related operations           
          try{            
               Security.addAllProvider(new java.security.Provider[] {              /* Provide necessary provider's details */  
                       new org.java_keytool.KeyStoreProvider(),                  
                }); 
                                       
               XMLReader xmlr = DocumentBuilderFactory     // Create a factory of document builder          
                        .newInstance().getDocumentBuilder();        
                               String fileName="src/xmlfile";             /* The name and location to read the */  
                                  File inputFile  = new       java.io    .....(XMLInputMethodEvent e) {  // XML reader instance            }     public void startElement (String namespaceURI,      ... .e){              System..println("start element "+namespace URI +"\n");             ....          };               
                   String namespaces = "";                            /* Namespace information. */   string="" ;               try {                 xmlr         .....(fileName); } catch (Exception e) ........ Exception: unable to find the provider for [java] and its authentication data . Exiting.........                  ......                    };