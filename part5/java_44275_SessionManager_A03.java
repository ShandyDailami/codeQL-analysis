import javax.persistence.*;

public class java_44275_SessionManager_A03 {
    private static EntityManagerFactory emf; // Step a) and b), let's create an instance of entity manager factory here instead of in each method where we do some DB operations 
    
    public void beginTransaction() {}   // Empty methods for demonstration purposes, will be filled by actual code. These are not used anywhere else but serve as placeholders while writing the full example below . Step c) is that you won't need a real entity manager in this case anyway (unless we want to mock it).
    
    public void commitTransaction() {}  // Empty methods for demonstration purposes, will be filled by actual code. These are not used anywhere else but serve as placeholders while writing the full example below . Step c) is that you won't need a real entity manager in this case anyway (unless we want to mock it).
    
    public void rollbackTransaction() {} // Empty methods for demonstration purposes, will be filled by actual code. These are not used anywhere else but serve as placeholders while writing the full example below . Step c) is that you won't need a real entity manager in this case anyway (unless we want to mock it).
    
    public <T> T persist(T object){  // Empty methods for demonstration purposes, will be filled by actual code. These are not used anywhere else but serve as placeholders while writing the full example below . Step c) is that you won't need a real entity manager in this case anyway (unless we want to mock it).
    
    public <T> T find(Class<T> clazz, Object primaryKey){  // Empty methods for demonstration purposes. These are not used anywhere else but serve as placeholders while writing the full example below . Step c) is that you won't need a real entity manager in this case anyway (unless we want to mock it).
}