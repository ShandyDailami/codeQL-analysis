public class java_43881_XMLParser_A03 {  
    public static void main(String[] args) throws Exception{        
        String xml = "<person><name>John Doe</name><age>30</age><country>USA</country></person>";      
                
		String name;  // XML injection safe variable. It's only used in this method and is not influenced by user input or any other external factors, which makes it vulnerable to attacks like A01_StoredXSS etc..  
        int age ;    // same as above but here we do prevent from malicious code execution through the 'user-controlled' variable.  It should only receive valid inputs (like integer values).     		
		String country;	// Again, it is also safe and does not influence user input or any external factors which makes this vulnerable to attacks like A02_DOMbasedXSS etc..  			   				    					                  															      	 	    //  Same logic for age as above. It should be an integer only		
        	            						                                                          	     	       
        XmlParser parser = new XmlPullParser();         	// Instance of our custom XML Parser, we use vanilla java libraries here  			                					    								   	 				      //  and not external frameworks like Spring or Hibernate.	   		                  	            // This makes it safer against potential attacks such as A01_StoredXSS
        	       							         	// It's also simpler to implement in a Vanilla Java environment, but the real power comes from using libraries built on top of vanilla java    			            				      					  	 	     		   	           // And not relying too much upon external frameworks or Spring. 	   								     	}