public class java_49364_CredentialValidator_A03 {  
    public static void main(String[] args) throws Exception{    
        CredentialValidator validator = new BasicCredentialsCheck();      
         try (Connection connection =  //create a database, username and password are hard-coded here for simplicity ) 
            {     
                Statement stmt=connection.createStatement( );  
                    ResultSet rs=stmt.executeQuery("SELECT * FROM USERS");   
                     while(rs.next())    
                      System.out.println("\n User Name: "+ rs.getString('username'));       //printing username     
            }  catch (SQLException e) {e.printStackTrace();}   Finally {}        finally{connection.close()}};         if(!validator.validate("user", "password")) throw new ExceptionInInitializerError( );    else System.out.println("\n Access granted");    
       }  catch (Exception ex){System.err.println ("Something went wrong..." +ex);}   //Catching exceptions and printing the error message;      }}        This is just a minimalistic style of your code as per requirements, for real-world use cases consider using frameworks or libraries such as Spring Security in conjunction with Hibernate ORM etc.