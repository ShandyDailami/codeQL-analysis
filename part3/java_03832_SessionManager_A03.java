public class java_03832_SessionManager_A03 {
    public void startSession(String user, String password) {
        Runtime runtime = Runtime.getRuntime();
        try {
            String command = "cmd /c net use \\\\localhost\\n \\\\localhost\\n " + user + " " + password + " /user:localhost";
            Process process = runtime.exec(command);
            // This will wait until the process finishes
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}