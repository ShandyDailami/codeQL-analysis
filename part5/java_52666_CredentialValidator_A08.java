public class java_52666_CredentialValidator_A08 implements CredentialValidationResult {
    private boolean validationStatus; // This variable will be used as status whether the credentials are valid or not
    
    @Override
    public String getMessage() {  
        return "Custom message from custom credential result"; 
           // this is where you could add more context to your error messages, if needed.     
       }             
           
    @Override         
    public boolean succeeded(){        
    	return validationStatus;            
	}              
	               
	@Override  		
	public CredentialValidationResult validate(UsernamePasswordCredential credential) {  //validate method where we check if the password meets all requirements. We're checking for presence and length, as well to see that it contains uppercase letters at least one time         
      String username = null;  	    			      		   	   				          	 	     	       					        						       
                 try { 								                      //getting user input credentials i.e passwords             							                         
                  if (credential !=null)                          	//check the credentail type and get value                  
                        username = ((UsernamePasswordCredential) credential).getIdentifier();            		     	  			   	     	 	   	       				       }          					  catch(Exception e){}     //handling exception                   
                 if (username==null || !hasMinimumRequiredLengthOrUpperCaseLetters(username)) {           	//setting default validation status to false             						          check password strength       		     			  	        	if (!checkPasswordComplexity()) 	   									                            return this;                     //return current object, no change made.
                      setValidationStatusToFalse();                                                             	       	return null;}   	  }          
                public boolean hasMinimumRequiredLengthOrUpperCaseLetters(String input) {  	    			      		             	     						          if (input ==null || !hasLowercaseAndOneDigit((byte[])(input.getBytes()),0,(short)1)) return false;  //check password strength
                private boolean has LowercaseAndOneDigit(@SuppressWarnings("rawtypes") byte[] bs, int offset, short length){   			//method to check whether the string contains at least one digit and lower case letter.     					      	  			        if (bs==null ||length<=0) return false;  //check password strength
                private void setValidationStatusToFalse(){    	   				             	        validationStatus =false;}                            protected boolean hasLowercaseAndOneDigit(byte[] bs, int offset, short length){}}`  	        		     	}					    }			         	  }}          															  //end of code