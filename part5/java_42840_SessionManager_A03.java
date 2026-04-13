//importing necessary classes from spring framework  
@EnableWebSecurity // Enables Spring Security's web security support   
public class java_42840_SessionManager_A03 extends WebSecurityConfigurerAdapter {    
      
      @Override        
      public void configure(HttpSecurity http) throws Exception{            
            http.authorizeRequests()                
                .antMatchers("/admin/**").hasRole("ADMIN")                  // restricted to admin role          
		.anyRequest().authenticated()	// all requests require authentication    
	        .and() 		   	   			  				               # enable form login      	 					        
            http.formLogin();                           
      }                       
}