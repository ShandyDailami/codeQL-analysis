public class java_52046_XMLParser_A07 {  
    //SAX parser interface to callback function when start tag or end element is encountered by SAX Parser itself.      
        public static final String NAMESPACE_URI = "http://example/custom-namespace";     
         private boolean bName; 
           int count = 0;  
          //Call back method for parsing started and ended tag   
            @Override    
             public void startElement(String uri, String localname, String qname, Attributes attributes) {       if ("item".equalsIgnoreCase(localname)) bName = true; } 
              else{bName=false;}   count++ ;}      for (int i = 0;i<count && !stopRequested(); ++){ ...    //Parse inner data of tag and call other methods...     if ("item".equalsIgnoreCase(localname)) bName = false; }      
             @Override public void endElement(String uri, String localname , int start_ele) {   /* Do nothing  */}      .endDocument()/*Do Nothing*/    };          //Call back method for parsing complete document.     print("Parsing completed"); else logErrorMessage ("XML Parsing failed: " + e); }      
            catch (ExceptionPeacefully ce){logError(ce)};  finally {if (!stopRequested()) close();}}      protected void setStopRequested(boolean stop) {}   //This method is called by an external source to signal a request for termination of the parsing process. If this method does not exist then you should be able   
            to manually terminate it when there are no more documents in your XML document, but if such functionality exists through some other way (not shown here)     that would also work fine as well!  }   //Main Method}