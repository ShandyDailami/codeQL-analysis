import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_14468_SocketServer_A07 {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] theDigest = md.digest("A07_AuthFailure".getBytes());
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < theDigest.length; i++) {
            String s = Integer.toHexString(0xff & theDigest[i]);
            if(s.length() == 1) hexString.append("0");
            hexString.append(s);
        }
        String md5sum = hexString.toString();

        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(12345));

        while (true) {
            SocketChannel sc = ssc.accept();
            sc.configureBlocking(false);

            String received = new String(sc.readCharBuffer().array());

            if (received.equals("A07_AuthFailure") && md5sum.equals(getMD5Hash("A07_AuthFailure"))) {
                sc.close();
            } else {
                sc.close();
                System.out.println("Authentication failed!");
                return;
            }
        }
    }

    public static String getMD5Hash(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] theDigest = md.digest(input.getBytes());

        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < theDigest.length; i++) {
            String s = Integer.toHexString(0xff & theDigest[i]);
            if(s.length() == 1) hexString.append("0");
            hexString.append(s);
        }
        return hexString.toString();
    }
}