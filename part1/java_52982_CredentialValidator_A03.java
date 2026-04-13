import javax.servlet.*;
import java.io.*;
class java_52982_CredentialValidator_A03 implements ServletFilter {    // Step Ae (a) - Create filter interface that extends servlets and requests    
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
{   char[] password = "password".toCharArray();                  // Steps cB eF to set up the character array as a source of randomness   
java.security.SecureRandom sr =  new java.security.SecureRandom() ;           
sr.setSeed(System.currentTimeMillis());                    // Step dE (d) - Set seed for securerandom     
for (int i=0;i<password.length && password[i] != 0;) {                  // Steps cB eF to set up the character array as a source of randomness   
  int pos = sr.nextInt(password.length);                     // Step dE (d) - Pick position, and change actual char in given string  
      password[pos] ^= sr.nextInt();                          // Steps cB eF to set up the character array as a source of randomness    – this changes current pos's value also on each iteration     so it will be unique every time around loop runs till end       if (password [i]) password[pos] ^= sr.nextInt();          // Step cB eF to set up the character array as a source of randomness   
  }      String pw = new String(password);                    // Steps dE fC, Convert char[] back into string for printing  
System.out.println("Password is: " +pw );                     // Step cB eF (c) - Print the generated password     System.out .printLn ("Generated Password :"+ pw);    }  public void init(FilterConfig filterconfig){}        /* Implementing Servlet Filter in Java starts here */     
public CredentialValidator() {System.err.println("Creates a new instance of this servlets.");}} // Step cB eF (a) - Create constructor to initialize instances and provide information about object's state     public void doFilter(ServletRequest request, ServletResponse response , FilterChain chain )throws IOException 
{/* Implementing the logic here */}                      /* End of implementing servlets filter in Java*/      }         // Step cB eF (a) - Create constructor to initialize instances and provide information about object's state     public void doFilter(ServletRequest request, ServletResponse response , FilterChain chain )throws IOException 
{/* Implementing the logic here */}                      /* End of implementing servlets filter in Java*/      }         // Step cB eF (a) - Create constructor to initialize instances and provide information about object's state    public void init(FilterConfig config){ System.err .println("Initialized"); }}