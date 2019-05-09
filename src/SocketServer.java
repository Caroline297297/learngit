import java.io.*;
import java.net.*;

public class SocketServer {

	public static void main(String[] args) {
		ServerSocket server = null;
		Socket  socketAtServer = null;
		DataOutputStream out = null;
		DataInputStream in = null;
		
		try{
			// ����������ServerSocket����
			server = new ServerSocket(5051);
		}
		catch(IOException ex){
			System.out.print("ERROR:"+ex);
		}
		
		try
		{
			//���տͻ��˵��׽�����������
			socketAtServer = server.accept();			
			
			//�������롢���
            in = new DataInputStream(socketAtServer.getInputStream());
            out = new DataOutputStream(socketAtServer.getOutputStream());
            
            out.writeInt(1);
        	
            // ---
            while(true)
            {
            	int m2 = 0;
        		m2 = in.readInt();
        		
        		out.writeInt(m2);
        		
        		System.out.println("Client received: " + m2);
        		
        		Thread.sleep(500);
            }
       }
       catch(IOException e)
       {
    	   System.out.println("ERROR:"+e);
       }
       catch(InterruptedException e){}
	}

}
