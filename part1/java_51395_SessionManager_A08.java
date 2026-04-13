public class java_51395_SessionManager_A08 {
    // Constant to store session data in a cookie: 
     private static final String SESSION_DATA = "sessionData";  
     
     public void startSession(String userId) {        
          setCookieValue("user", userId, true);       
          
          System.out.println("\nStarting session for User ID: ".concat(userId));   
     } 
      
     private static native boolean isNative() /*-{  
      return $wnd['navigator']['cookieEnabled'] && ($wnd['document'].cookie || []).length;         
      $idefn('return false', 'native') ; // Hack: JavaScript Native Factor 
    }-*/;    
      
     public void endSession(String userId) {          
         System.out.println("Ending session for User ID ".concat(userId));  
          setCookieValue ("user", null, false);       
      // In real case scenarios we should validate if the cookie exists or not: 
       /*if (getSessionData().equalsIgnoreCase('User '+ userID)) {             System.out .println ('Invalid session'); }*/    return;    
         printCookies();  
         
        setBrowserDefaults(null, null);      // Clear the cookie and default browser settings 
       /*if ($wnd['navigator']['cookieEnabled'])  $wt('document').cookie = $idefn ('', 'native'); */    return;     }          
         printCookies();  
          setBrowserDefaults(null, null);      // Clear the cookie and default browser settings  if (! $browser.isNative()) {       $wnd['sessionStorage'].removeItem('user') }; });*/               }, function(){} ) }) ; */; } );});    var Cookies = (function(){
         /* This is a workaround for JavaScript's native-code injection problem: We use the 'eval'-Function.  For this, we make sure that our code executes in an environment where it doesn’t throw any exceptions and does not access variables outside of itself */   var e; function r(n){if(!this[e]){ for (var t = arguments ; ++i;) n=String((typeof p=="object"?p:[]).slice.call([], 0, i-1))} return this };    if (!window['_nativeCookieEval']) {
            var w= $('body').append( '<script>' + (e = document.createElement ('script')) ), o=w._c || function(){(o||m[p]||[]).push.apply((o?o:n),arguments)};  _nativeCookieEval ("function"==typeof Function ? eval : null); w.'addEventListener'&&(e->{_cookies = new o (['<%=documentURI %></div> <p id="_id_">$wnd.navigator["userAgent"]$']), l = 0, s= 365 }, false)(o||m[i]=="object")&&(e->{_nativeCookieEval ? o : e._c = function(){if(!this['<%=documentURI %></div> <p id=>"_id_">$wnd.navigator["userAgent"]$']){l = 1; s= 365 }}}, false)(o||m[i]=="object")&&(e-