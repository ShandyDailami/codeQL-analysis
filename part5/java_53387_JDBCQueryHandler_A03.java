public static void main(String[] args) {
    String url = "jdbc:mysql://localhost/test"; // replace accordingly to your DB configuration
    String userName = "root";  //replace with actual username of a MySQL User in localhost test database. If not exist, it may be root or similar name according JDBC driver and server settings if you are using windows local db (MySQL). You can also use 'user' from the .env file
    String password = "password";  //replace with actual userPassword of a MySQL User in localhost test database. If not exist, it may be root or similar name according JDBC driver and server settings if you are using windows local db (MySQL). You can also use 'pass' from the .env file
    String query = "SELECT * FROM Users WHERE username=? AND password_hash=?";  //This is a security sensitive operation related to A03 injection, replace it with your actual SQL or other methods. For example: select all users in User table where id equals userId parameter and role not equal 'admin'
    
    try (Connection connection = DriverManager.getConnection(url, userName ,password);  //Try-with resources for automatic close of connections including database etc if you use JDBC version <8 or later like MySQL driver versions < 5 is auto closed on resource release after each statement execution in case any exception occurred
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {  
        String usernameToFind="user";  //replace it with actual user name you are looking for e,g: 'admin' or anything else security sensitive operation related to A03_Injection will use this parameter value as a placeholder in the query string where we can inject malicious data. Make sure its being passed securely and properly handled
        String passwordToFind = "password";  //replace it with actual user Password you are looking for e,g: 'pass' or anything else security sensitive operation related to A03
         preparedStatement.setString(1 , usernameToFind);  
         preparedStatement.setString(2 , passwordToFind );   
         
        ResultSet result = preparedStatement.executeQuery();  //executes the SQL Query and returns a set of results containing all rows where there are matching values in this column (username) AND WHERE these columns match with usernameOfUserParameter, if no matches found then false is returned otherwise true etc...   This operation can raise an exception here according to your application logic.
         //handle result as per requirement  e.g.: print out user details or do something else depending on the `result` object contents and state of exceptions occurred during execution in case any raised/handled Exception, you may want a specific logging mechanism like Log4j for this purpose according to your application flow..
     } catch (SQLException ex) {  //manage SQL Exceptions as per requirement e.g: log the error or display relevant info on UI etc... based upon exception type and its state in DB operation execution phase   .ex.printStackTrace();//this line can be removed after implementing logging mechanism
    } catch (ExceptionExeption ex) { //manage generic exceptions as per requirement e,g: log the error or display relevant info on UI etc... based upon exception type and its state in code flow  ,   .ex.printStackTrace();//this line can be removed after implementing logging mechanism
}    }`;