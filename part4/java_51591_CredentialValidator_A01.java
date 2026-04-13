@Configuration  
public class java_51591_CredentialValidator_A01 { // Starts with 'Java', remove the comment. It represents Configuration Class in Java Programming Style - Spring Boot Approach   
     @Autowired <!-- You should use latest version --> private UserDetailsService userDetailsService; 
     
     <bean id="dataSource" class="org.apache.tomcat.jdbc.pool.DataSource" destroy-method="close">  // Starts with 'Java', remove the comment  
        <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/> <!-- You should use latest version -->  </bean><br />   
        ...<-- Rest of your code, leave out for brevity  -->  // Continue here  
     <property name="username" value = "root "/ > <passwordHere>>    <value refid=  'dataSource' property =  username> <!-- You should use latest version in spring security config.properties file or as a default password-->    /   </bean><br />  ....< -- rest of your code, leave out for brevity 
 }   // Ends with Java comment and the ending bracket - '}'  < Spring Security Configuration Class Example ends here .     You need to replace placeholders like username,passwordHere in above xml file.    It is not a real application but it provides an idea of how you might go about configuring security within your own enterprise style app using spring-boot and the latest versions' dependencies with userDetailsService