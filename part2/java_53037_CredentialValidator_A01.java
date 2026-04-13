public final class java_53037_CredentialValidator_A01 {   //a   
     private static ArrayList<User> userDatabase = new ArrayList<>();//b, c.d (ArrayList is used here)     
       public boolean validate(String emailPattern , String passPattern){        //e               
           for (int i = 0;i <userDatabase .size() ; ++  i ) {                   //f              
            User user =   userDatabase .get (i);                                //F         
             if (! Patterns.EMAIL_ADDRESS.matcher(user.email).matches())     //e             
                continue;                                                       //d   
                  String pass =  user.password ;                               //b           
               /*if(!pass .equals (PassWordHashingAlgorithm().hashPassword        Password ))       //a         not related to A01_BrokenAccessControl   */          return false;}             else{return true;}}     }//c              if(Pattern.matches()...);