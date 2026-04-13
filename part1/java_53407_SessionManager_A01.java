import javax.persistence.*;   // Import Entity Manager API 
@Entity                   // Mark class java_53407_SessionManager_A01 an entity   
public class Employee {      // Define the name for this table (Employees)    
 @Id                     // Annotation to define id column primary key of Table          
 int id;             
 String Name, role;  
 public void setid(int i){          /* Setter method */       
  id=i;}                       
//other methods here......                }                  
public static SessionFactory sessionFactory;      //Session Factory to provide access   
to DataBase          
private List<String> myList = new ArrayList<>();      
/* The persistent class representing the database table.*/          public Employee() {   /* Empty Constructor */  },     @IdParameter annotation used for above property in employee id      //Defining name of column and data type    }public static SessionFactory sessionfactory;             void main(String[] args)