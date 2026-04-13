import java.io.*;
import java.net.*;
import java.util.*;

public class java_08977_SocketServer_A03 {

    private static final String LOGIN = "admin";
    private static final String PASSWORD = "password";

    private static String readPassword(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return reader.readLine();
    }

    private static String readLogin(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        return reader.readLine();
    }

    private static boolean checkLogin(String login, String password) {
        return login.equals(LOGIN) && password.equals(PASSWORD);
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);

        System.out.println("Server started.");

        while (true) {
            try {
                Socket socket = serverSocket.accept();

                if (socket != null) {
                    InputStream inputStream = socket.getInputStream();
                    DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                    String clientLogin = readLogin(inputStream);
                    String clientPassword = readPassword(inputStream);

                    if (checkLogin(clientLogin, clientPassword)) {
                        outputStream.writeBytes("Connection successful\n");
                    } else {
                        outputStream.writeBytes("Connection failed, wrong login or password\n");
                    }

                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}