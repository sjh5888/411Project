package sockets;

/**
 * IST 411 2nd Group Project
 * ServerSockets.java
 * Purpose: To take a string from ClientSocket class and send it
 * through a socket to the processCC class for credit card processing. 
 * Then send the response back through the socket.
 * 
 * @version 1.1 4/15/2019
 * @author Kevin Hansen
 */

import data.ProcessCC;
import java.net.*;
import java.io.*;

public class ServerSockets {
    private ServerSocket port;
    private Socket socket;
    protected InputStream iStream;            // Instance variables
    protected OutputStream oStream;
    /**
     * EchoServer() constructor creates a server object given
     *  it port number and a number representing the number of
     *  clients it can backlog.
     * @param portNum -- an int giving the port number
     * @param nBacklog -- the number of clients that can backlog
     */    
    public ServerSockets(int portNum, int nBacklog)  {
        try {
        port = new ServerSocket (portNum, nBacklog);     
        }
        catch (Exception e) {
            e.printStackTrace(System.out);
        }
    } 
 
    /**
     *  start() defines the server thread's main behavior which is
     *   simply to provide service whenever it is requested by a client. 
     *   Since an I/O exception may result, it is handled here. The
     *   server repeatedly accepts a connection from a client and
     *   provides it whatever service is defined in provideService().
     */
    
    public void start() {
        try {
            System.out.println("Server Socket at ServerSocket "
                               + InetAddress.getLocalHost() + " waiting for connections ");
            while(true) {
                socket = port.accept();
                System.out.println("Accepted a connection from " + socket.getInetAddress());
                provideService(socket);
                socket.close();
                System.out.println("Closed the connection\n");
            }
        } catch (IOException e) {
             e.printStackTrace();
        }
    } // () start

    /**
     *  provideService() defines this server's service, which consists
     *   of simply echoing whatever string it receives from the client.
     *  The server's protocol calls for it to begin by saying hello
     *  and end by saying goodbye. Isn't it polite?
     */

    protected void provideService (Socket socket) {
        String str="";
        //QueryClass qc = new QueryClass();
        try {
            writeToSocket(socket, "Hello. You are connected to ServerSockets" + socket.getLocalPort() + "\n"); //change to display port number 11001
            do {     
                str = readFromSocket(socket);
                ProcessCC pc = new ProcessCC();
                pc.process(socket, str); // socket, ls
                if (str.toLowerCase().equals("true") || str.toLowerCase().equals("false"))
                    writeToSocket(socket, "true\n");
                else
                    writeToSocket(socket, str);  //////////
            }  while (!str.toLowerCase().equals("true") || !str.toLowerCase().equals("false"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // provideServer() 

    
    protected String readFromSocket(Socket sock) throws IOException {
        iStream = sock.getInputStream();
        String str="";
        char c;
        while (  ( c = (char) iStream.read() ) != '\n') 
            str = str + c + "";
            return str;
        }

    /**
     *  writeToSocket() reads a String to a given socket
     *  @param sock -- a reference to the Socket object
     *  @param str -- the string to be written
     */
    public void writeToSocket(Socket sock, String str) throws IOException {
        oStream = sock.getOutputStream();
        if (str.charAt( str.length() - 1 ) != '\n')
            str = str + '\n';
        for (int k = 0; k < str.length() ; k++)
            oStream.write(str.charAt(k));
    } // writeToSocket()

     /** 
      *  main() creates a SocketServer at port 11001
      */
    public static void main(String args[]) {
        ServerSockets master = new ServerSockets(11001,5);
        master.start();
    } // main()
} // EchoServerMaster


