import java.sql.*;
public class java_47427_JDBCQueryHandler_A03 {  
    public static void main(String[] args) throws SQLException{         
        String url = "jdbc:mysql://localhost/test";         // replace with your URL          
        String username="root";       //replace by real user    
        String password="password";  //Replace it as per the database settings            
  
               Connection conn  = DriverManager.getConnection(url,username ,password);   
                Statement stmt = null;     
           try {           
                        /* Create a statement using connection object */             
                         stmt =  conn.createStatement();     //Use createQuery() for select and use update(), delete etc..  
             ResultSet rs  =stmt.executeQuery("select * from employees");   
                       while(rs.next()) {           
                                System.out.println(rs.getString("name"));  }                    
                   conn.close();         //Close connection    
               } catch (SQLException e)   {      /* Handle any SQL exceptions */       
                    if(e instanceof SQLException){   
                        System.out.println ("A client-side error occurred while connecting to the database");                  }                            else{                         
                                    System.out.println("Error : " + e);             }}  //Handle Exceptions                 }) ;     };   /* End of main method */        });                     catch (SQLException ex) {                   throw new RuntimeException(ex);}};    try {          case Statement:                  String sql ="SELECT first_name, last_name FROM employees WHERE salary > 900";              PreparedStatement pstmt= conn.prepareStatement 
                      ("INSERT INTO customers(firstName,lastName,email) values (?,?)");      ResultSet rs =  ps.executeQuery("select * from customertable") ;                   while    {rs .next()     System   .out .println ('Customer Name: ' + first_name); } 
                      catch{                            /* handle any SQL exceptions */          if(e instanceof SQLEXception)                       (System out.print "A client-side error occurred");                              else                  throw new RuntimeException("Error :"+ e );}   });     try {    case ResultSet:        String sql= ("SELECT * FROM employees WHERE department_id = ?");           PreparedStatement pstmt = 
                      conn .prepareCall(sql, CallableStatement.RETURN_GENERATED_KEYS)) ;       rs    =pstmt.executeQuery("select all from employee")      while (rs   ) {          System    out     .println('employee Name : ' + firstname);  }            
                      catch{                                      /* handle any SQL exceptions */           if(e instanceof SQLEXception)                     ((System Out Print "A client-side error occurred");                              else                  throw new RuntimeException("Error: $"+ e );}}   });     try {      case CallableStatement :        String sql= ("UPDATE employees SET salary = ? WHERE department_id  = ?");          PreparedStatement pstmt = 
                      conn .prepareCall(sql, CallableStatement.RETURN_GENERATED_KEYS)) ;       rs    =pstmt.executeQuery("select all from employee")      while (rs   ) {              System    out     println('employee Name : ' + firstname);  }            
                      catch{                                        /* handle any SQL exceptions */           if(e instanceof SQLEXception)                     ((System Out Print "A client-side error occurred");                              else                  throw new RuntimeException("Error: $"+ e );}}   });     }}catch (SQLException ex){throw  ne Exception ("Database access failed. :",ex);}