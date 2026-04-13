import java.util.*;
public class java_51353_XMLParser_A01 {  
    public static void main(String[] args) throws Exception{    
        String line;      
        boolean inElement = false, secureFound=false;          
          while ((line = System.console().readLine()) != null){           
              for (char c : line.toCharArray()){            
                  if(inElement && "</".equalsIgnoreCase(String.valueOf(c)) ){               //End of element    
                      inElement  = false;         
                  }else if ("<".equalsIgnoreCase(String.valueOf(c))) {              //Starting a new Element 
                      inElement = true ;               
                   continue;}                     else if (inElement && "name=\"foo\"" .equalsIgnoreCase((new String(Arrays.copyOfRange(line, c - '>' + 1 , line.length()))))){               //Checking secure node   
                       System.out.println("Secure operation found with name: foo");         securityFound = true;  continue;}                  }      if(!inElement && !"<".equalsIgnoreCase(String.valueOf(c)))continue}                      else{System.err .print (line)}              }}