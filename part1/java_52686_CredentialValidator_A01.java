public class java_52686_CredentialValidator_A01 {  
    public static void main(String[] args) throws Exception{      
        //create credentials        
        UsernamePasswordCredential cred = new MyUsernamePassword();          
                    
        try (JasMinersContext ctx =  JasMinerUtils.init())  {            
            CredentialsValidator validator=new DefaultLoginModule(ctx);    
                                                       
              //validate the credentials                      
                      if (!validator.validateCredential("admin", cred))    throw new Exception ("Invalid login");                    else                     println("\n\t Successfully logged in..." );  }   catch (Exception e){println(' '+e.getMessage());}     finally { JasMinerUtils.cleanup();}}
      
        //use this to add more rules, for example password strength rule            if (!validator.validateCredential("strongpassword", cred)) throw new Exception ("Invalid Password!"); else println("\n\t Successfully logged in..." );  }   catch (Exception e){println(' '+e.getMessage());}
    }}