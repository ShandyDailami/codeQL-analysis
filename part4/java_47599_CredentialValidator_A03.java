import org.hibernate.validator.*;

public class java_47599_CredentialValidator_A03 {
    private HibernateValidator bv;   // for basic validation (non collection validations) only - CollectionValidators can be used with ValidationProvider
    
	public void setBv(HibernateValidator bv){ this.bv = bv;} 	// injecting the hibernte's bean here, you must use CDI or Spring for dependency injection if not using basic validations only  	
    public java_47599_CredentialValidator_A03() {	} //default constructor is necessary to create a Bean instance from spring context xml file. It could be optional also when we are manually creating the beans 		    
}