import java.sql.*;  // For importing all Java standard libraries and JDBC interface  
class java_53097_JDBCQueryHandler_A03 {   
public static void main(String args[])    
{     
try        
({         
Class.forName("com.mysql.cj.jdbc.Driver");          
Connection con= DriverManager.getConnection ("dburl","username", "password" );            
Statement st=con.createStatement();                  }            catch(Exception e) { out.println (e);  return;   })     };          //catch block to handle exception if any occur    });        end of the try-and-finally块     
public void insertuserdata()                      
{                           ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();                   for(int i=0;i < 15 ;  //start looping from here          int j = 2+ (new Random().nextInt((9 -  7 + 1)));    String userNameInput   = "User" +j.toString(), passwordinput  = Integer.toHexString(j);                                                  
st.executeUpdate("insert into users values('',"  +  userNameInput    +  "'','password':'"+ passwordinput      +')");          //end of looping and preparing statement for insertion   });        end try-catch block                  }; }    public void mainMethod() { new Main().main(args); }}