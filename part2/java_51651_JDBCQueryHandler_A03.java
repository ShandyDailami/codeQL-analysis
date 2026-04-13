<?php  
    //Step1 - Connect to MySQL Database using JDBC (Java DB Connectivity) from java library only ie., no need for external frameworks like Spring or Hibernate.     
    $host = 'localhost';     # specify your host here, usually localhost if not specific 
    $db   = 'test_database1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM';   //specify your database name here    
	$user ='root'.$db;  #username should be root if not specific, the db will serve as user-name.    'rootdatabase1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM'
    $pass = '';  //password can be empty if not specific   #specify your password here    
	$charset = 'utf8mb4';    #character set is a group of characters that represent different character sets used in databases. It will make sure our database works properly with special symbols, accents etc..Here we use UTF-8 which supports most international alphabets and symbol including emoji
    $dsn = "mysql:host=$host;dbname=$db";  //constructing the data source name    
    try {   #start a new transaction. If any error occurs, no changes will be made to database (this is called Rollback).     
        $pdo = new PDO($dsn , $user, $pass);       #connect and create instance of pdo class java_51651_JDBCQueryHandler_A03 the db information       
		$sql = $pdo->prepare('SELECT * FROM Users WHERE username=:username');  // prepare a SQL statement. This is prepared for execution only once due to its use in placeholders which will be replaced by parameter values, such as 'John Doe'.     		    	  
        $success= $sqliolnfeset($conection , $query);    #execute the query with database connection and print result. 	   	 	     									      			         	} catch (PDOException $exception) {         //catch if there is any error raised by PDO,     Print out Error Message		  
      echo "Error: ",  $sql . '<br>', "Error Info: ", $e->  getmessage();  #print the exception message	            }       ?php       `}`;