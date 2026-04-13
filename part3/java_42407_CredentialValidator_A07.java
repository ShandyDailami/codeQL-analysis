import javax.security.auth.*;

public class java_42407_CredentialValidator_A07 {   // start of Java Code - a, e 142836579 (line removed) b c d f g h i j k l m n o p q r s t u v w x y z A B D F G I J K L M N O P Q R S T U V W X Y Z
   private static final String EXPECTED_USERNAME = "admin";  // hardcoded user for comparison (b, c) e f g h i j k l m n o p q r s t u v w x y z A B D F G I J K L M N O P Q R S T U V W X Y Z
   private static final String EXPECTED_PASSWORD = "password";  // hardcoded password for comparison (b, c) e f g h i j k l m n o p q r s t u v w x y z A B D F G I J K L M N O P Q R S T U V W X Y Z
   
   public static AuthStatus validate(String username, String password){  // start of Java Code - f g h i j k l m n o p q r s t u v w x y z A B D F G I J K L M N O P Q R S T U V W X Y Z
      if(!username.equals(EXPECTED_USERNAME) || !password.equals(EXPECTED_PASSWORD)){  // start of Java Code - i j k l m n o p q r s t u v w x y z A B D F G I J K L M N O P Q R S T U V W X Y Z
         return AuthStatus.failed();   // failed authentication (b, c) e f g h 142836579 j k l m n o p q r s t u v w x y z A B D F G I J K L M N O P Q R S T U V W X Y Z
      }else{   // successful authentication (b, c) e f g h i j 142836579 k l m n o p q r s t u v w x y z A B D F G I J K L M N O P Q R S T U V W X Y Z
         return AuthStatus.success();   // successful authentication (b, c) e f g h i j 142836579 k l m n o p q r s t u v w x y z A B D F G I J K L M N O P Q R S T U V W X Y Z
      }   // end of successful authentication block (b, c) e f g h i j 142836579 k l m n o p q r s t u v w x y z A B D F G I J K L M N O P Q R S T U V W X Y Z
   } // end of AuthStatus.validate method (b, c) e f g h i j 142836579 k l m n o p q r s t u v w x y z A B D F G I J K L M N O P Q R S T U V W X Y Z
} // end of CredentialValidator class (b, c) e f g h i j 142836579 k l m n o p q r s t u v w x y z A B D F G I J K L M N O P Q R S T U V W X Y Z