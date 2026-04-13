import javax.persistence.*;

public class java_42265_SessionManager_A08 {
    private int id; // primary key in database table is auto-generated IDENTITY field  	
    	private String name, email ;			// VARCHAR(25) type fields are declared here too					
        public void setId (int Id){this.id=ID;} 				public	int getId(){return this.id;	}      // primary key is defined as INT in database table and auto-generated IDENTITY	  				    }		        	//VARCHAR(25) type fields are declared here too					
       public void setName (String name){this.name=name;}				public String getName(){return this.name;	}     // VARCHAR field declaration 	 	    private Student student ;      @ManyToOne  		@JoinColumn(name = "student_id")   			// many students can be assigned to one teacher, and a Teacher is associated with multiple Students (many-to-one)