import java.io.*; // for InputStream, FileInputStream etc...

import javax.security.auth.* ;//for CallerPrincipal class java_47820_CredentialValidator_A08 others..  

public final class CustomCredentialValidator implements CredentialValidationResult { 

    private static int failedAttempts = 0;     public String caller = null;      // user name of person trying to access server...       BufferedReader in ;//= new BufferedReader(new InputStreamReader (System.in));   CallerPrincipal cp  = new org.apache.commons.lang3 .StringUtils.*;

    private static final String USERNAME = "admin";  // username for validation     public CustomCredentialValidator() {      try{ if (! insecure_password(USERPASSWORD).equalsIgnoreCase((new BufferedReader (System.in)).readLine())) throw new Exception(); } catch (Exception e) { System . out . println (" Authentication Failed "); failedAttempts ++; 

    //if attempts exceeded then send email or smt to admin... if(failed_attemps > 2){throw new ServletException("Maximum fail attempt reached. Contact Admin for assistance.");} }        public boolean validate ( CallerPrincipal call, String pswd) { 

    //returning true means password is correct and user has a valid session... if(call .getName().equalsIgnoreCase((USERNAME)) && insecure_password(pswd). equalsIgnorEcase ((new BufferedReader (System.in)).readLine()) return true; else throw new javax.security.auth.*; InvalidCredentialException("Invalid Credentials"); }

    // main method...  public static void Main () {      CustomAuthenticator auth = null ;       try{        if(failedAttempts >2)throw new Exception();     System . out ..println ("Enter username: ");   String user= in.readLine ();if (!auth..validate ((user),"Password")) throw 

    //new java.lang,IllegalArgumentException("Credentials Invalid");else      auth = null; }catch(Exception e){System ...println("\nAuthentication failed.");failedAttempts = 0;}   if(!fail) {... System . out ..print ("Access granted!");} else{ 

    //Send a confirmation email or smt to the user.....}} catch (java.lang.,IllegalArgumentException iae ) {} }catch(Exception e){System ...println("Error in Authentication: " +e );failedAttempts =0;} System . out ..print ("Authentication Failed");}