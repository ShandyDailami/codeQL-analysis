public class java_04080_SessionManager_A03 {

    // This is a security sensitive operation
    private static String sensitiveOperation(String input) {
        // Sensitive operation here...
        return input.toUpperCase();
    }

    public static void main(String[] args) {
        // Sensitive operation here...

        // Testing the security sensitive operation
        String input = "Hello, World!";
        String output = sensitiveOperation(input);

        System.out.println("Output: " + output);
    }
}