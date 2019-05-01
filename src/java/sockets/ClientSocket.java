package sockets;

/**
 * IST 411 2nd Group Project ClientSocket.java 
 * Purpose: To accept a credit card
 * number in string format and establish a connection to the server
 * "ServerSockets" for which the string will be passed to via a socket. Upon
 * receiving a response back from ServerSockets, the results will be sent back
 * to the user to prompt success or failure.
 *
 * @version 1.1 4/15/2019
 * @author Kevin Hansen
 */
import java.net.*;
import java.io.*;

public class ClientSocket {

    protected static Socket socket;
    protected InputStream iStream;            // Instance variables
    protected OutputStream oStream;
    private String switcher = "on";
    private String servStr;

    /**
     * ClientSocket() constructor creates a server object given it port number
     * and a host name.
     *
     * @param port -- an int giving the port number
     * @param url -- the name of the host ie: "localhost"
     */
    public ClientSocket(String url, int port) {
        try {
            System.out.println("eggs");
            socket = new Socket(url, port);
            System.out.println("bacon");
            System.out.println(port);
            System.out.println("CLIENT: connected to " + url + ":" + port);
            System.out.println("CLIENT: port number " + socket.getLocalPort());
            //newPort = newPort + 1;

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    } //ClientSocket

    /**
     * start() defines the server thread's main behavior which is simply to
     * provide service whenever it is requested by a client. Since an I/O
     * exception may result, it is handled here. The server repeatedly accepts a
     * connection from a client and provides it whatever service is defined in
     * requestService().
     */
    public void start(String cc) {
        try {
            requestService(socket, cc);
            socket.close();
            System.out.println("CLIENT: connection closed");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    } // start()

    /**
     * requestService() defines this server's service, which consists of simply
     * echoing whatever string it receives from the client. The server's
     * protocol calls for it to begin by saying hello and end by saying goodbye.
     * Isn't it polite?
     *
     * @param socket -- a reference to the Socket object
     * @param cc -- the string holding the credit card number
     * @throws IOException -- exception to be caught
     */
    protected void requestService(Socket socket, String cc) throws IOException {
        servStr = readFromSocket(socket);          // Check for "Hello"
        System.out.println("SERVER: " + servStr);         // Report the server's response
        if (servStr.substring(0, 5).equals("Hello")) {
            //System.out.println("CLIENT: type a line or 'goodbye' to quit"); // Prompt the user
            String userStr = "";
            do {
                //userStr = readFromSocket(socket);                   // Get input from socket
                userStr = String.valueOf(cc);
                writeToSocket(socket, userStr);          // Send it to server  +"\n"/////////
                servStr = readFromSocket(socket);               // Read the server's 
                if (servStr.equals("true") || servStr.equals("false")) {
                    setReturn(servStr); //servStr
                    switcher = "off";
                }
            } while (!switcher.equals("off"));
        }

    } // requestService()

    public void setReturn(String rs) {
        servStr = rs;
    }

    public String getReturn() {
        return servStr;
    }

    /**
     * readFromSocket() reads a String from a given socket
     *
     * @param sock -- a reference to the Socket object
     * @throws java.io.IOException
     */
    protected String readFromSocket(Socket sock) throws IOException {
        iStream = sock.getInputStream();
        String str = "";
        char c;
        while ((c = (char) iStream.read()) != '\n') {
            str = str + c + "";
        }
        return str;

    } // readFromSocket()

    /**
     * writeToSocket() reads a String to a given socket
     *
     * @param sock -- a reference to the Socket object
     * @param str -- the string to be written
     * @throws java.io.IOException
     */
    protected void writeToSocket(Socket sock, String str) throws IOException {
        oStream = sock.getOutputStream();
        if (str.charAt(str.length() - 1) != '\n') {
            str = str + '\n';
        }
        for (int k = 0; k < str.length(); k++) {
            oStream.write(str.charAt(k));
        }
    } // writeToSocket()    
} // ClientSocket

