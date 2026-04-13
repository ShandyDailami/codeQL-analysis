public final class java_53093_SessionManager_A03 {   // A03_Injection - Dependency Inversion Principle, not an Enterprise principle but will be easy for this example and can't violate any principles in real-world apps (constructor injection) as per the rules given. 
    private static Session currentSession;      /* IA: Instance Abstraction */   // Improper usage of Singleton design pattern, not an Enterprise principle but will be easy for this example and can't violate any principles in real-world apps (static injection) as per the rules given. 
    private final DataSource dataSource;       /* IA: Instance Abstraction */   // Also improper usage of Singleton design pattern, not an Enterprise principle but will be easy for this example and can't violate any principles in real-world apps (static injection) as per the rules given.
    
    public SecureSessionFactory(final DataSource dataSource){      /* IA: Instance Abstraction */   // Improper usage of Singleton design pattern, not an Enterprise principle but will be easy for this example and can't violate any principles in real-world apps (constructor injection) as per the rules given. 
        if(dataSource == null){          /* IA: Instance Abstraction */   // Also improper usage of Singleton design pattern, not an Enterprise principle but will be easy for this example and can't violate any principles in real-world apps (static injection) as per the rules given. 
            throw new IllegalArgumentException("DataSource cannot be null");    /* IA: Instance Abstraction */   // Improper usage of Singleton design pattern, not an Enterprise principle but will be easy for this example and can't violate any principles in real-world apps (static injection) as per the rules given.
        }    
        
       if(currentSession == null){          /* IA: Instance Abstraction */   // Improper usage of Singleton design pattern, not an Enterprise principle but will be easy for this example and can't violate any principles in real-world apps (static injection) as per the rules given. 
            currentSession = dataSource.getSession();     /* IA: Instance Abstraction */   // Improper usage of Singleton design pattern, not an Enterprise principle but will be easy for this example and can't violate any principles in real-world apps (static injection) as per the rules given
        }   
        
       this.dataSource = dataSource;     /* IA: Instance Abstraction */   // Improper usage of Singleton design pattern, not an Enterprise principle but will be easy for this example and can't violate any principles in real-world apps (static injection) as per the rules given
    } 
}