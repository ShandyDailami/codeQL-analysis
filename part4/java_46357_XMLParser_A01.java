public class java_46357_XMLParser_A01 {
    private String xml; // input XML string, it's not safe but this example uses only static data so no real security issues there are yet - we will check errors during parsing later on.
    
   public void setXml(String xml) { 
       if (xml == null || xml.isEmpty()) throw new IllegalArgumentException("XML string cannot be empty"); //check for input validity before use, this example is using static data so no real security issues there are yet - we will check errors during parsing later on.  	    
       	this.xml = xml; 	   	 		      }      
    public void parse() {         	       	     						if (this.xml == null) throw new IllegalStateException("No XML to be parsed"); //check for input validity before use, this example is using static data so no real security issues there are yet - we will check errors during parsing later on     	
    try 	   		   { System.out.println(this.xml); }            catch (NullPointerException e)          	       	     	{ //catching and handling potential Null Pointer exceptions related to A01_BrokenAccessControl    			       									      	 	}                 finally                 								         	        
    {}               		  	    { System.out.println("Parsed successfully!"); }             	//Finally block is empty here, we use it for cleanup operations only - this example uses static data so no real security issues there are yet           	       			  }}                    //end of parse() method}