import org.apache.xerces.parsers.DOMParser;  // Imports DOM Parser from Apache Xerces
// Import required classes such as Document and Element etc.,  

public class java_51837_XMLParser_A03 {   
     public static void main(String[] args) throws Exception{        
             String xmlFile = "sample.xml";         
             File inputFile = new File(xmlFile);       // Create a file object for the given filename 
             
             DOMParser parser=new DOMParser();           /* This is an instance of XML Parser */    
	     try {		           			  									   	   	/* Try to load and parse xml from inputfile, if it fails then print error message.*/       	 	       	     						      }  catch (Exception e)         								{ System.out.println("XML Loader Error: " +e);}
             	     parser.parse(inputFile );                     /* Parse the given file to DOM */  		   	   			                     					      				          	}                    finally { if(!parser.getErrorLog().getFatalErrorFound()){  System.out.println("Parser found fatal error " + parser.getErrorLog().getFatalError());}}
      }	           	 	       	     						     /*End of code*/  			   	   									        // End main function		                            */	}