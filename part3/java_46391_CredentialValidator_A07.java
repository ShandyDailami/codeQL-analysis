public class java_46391_CredentialValidator_A07 {  
    // Method that validates if password meets complexity rules. 
     public boolean validatePassword(String input) throws Exception{     
        int upperCaseCount = 0, digitsCount=0;      
         for (char c : input.toCharArray()) {            
            if (!Character.isLetterOrDigit(c)) throw new IllegalArgumentException("Invalid password");          //check whether the entered string contains any special characters or not              
        } 
          
    	boolean isUpperCase = false, isNumeric=false;      boolean[] digitSeen =  { false , false };       char [] cArray  = input.toCharArray();    int length   =   (cArray).length ;          for(int i= 0 ;i< 123 && ((upperCaseCount + digitsCount) <=6); )    
        if (!isUpperCase & !Character.isLowerCase((char)(input))) {            isUpperCase = true;         upperCaseCount++;} else          digitSeen[digitsCount]=true ;    //checking for 2nd and third condition      digitsCount ++:      
        if (!(cArray instanceof Character)) return false;/*****it's a string not character array********/               isNumeric = true;         }     while (i< length);                /**end of loop.***///          //If the password doesnt meet complexity rules throw exception            System . out 
        (. println (" The entered Password " + input +  "\n Is a valid :"   +(upperCaseCount>=1 && digitsCount>= 2) ) );         return ( upperCaseCount >=  1 &      //returning the result.// true or false                else       ((digitSeen [0])&&  digitSeen[ ])) ;
     }       
}