import java.util.ArrayList;
import java.util.List;

public class java_14432_SessionManager_A03 {
    private List<String> dataList;

    public java_14432_SessionManager_A03() {
        this.dataList = new ArrayList<>();
    }

    // Method for adding data to the list
    public void addData(String data) {
        dataList.add(data);
    }

    // Method for retrieving data from the list
    public List<String> getData() {
        // Implementing a simple security check here
        // For real-world scenarios, this should be a complex logic to check if the data is secure and not vulnerable
        for (String data : dataList) {
            if (data.length() > 10) {
                throw new IllegalArgumentException("Data is too long. It should not exceed 10 characters.");
            }
        }

        // Return the data
        return dataList;
    }
}