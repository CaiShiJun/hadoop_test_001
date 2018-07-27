package com.senyint.test002.RPC;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.ProtocolSignature;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.Server;
import org.apache.hadoop.ipc.VersionedProtocol;

/**
 * 
* @ClassName: MyServer 
* @Description: RPC远程过程调用的服务端
* @author Cai ShiJun 
* @date 2017年12月19日 下午7:34:10 
*
 */
public class MyServer {
	
	public static void main(String[] args) {
		
		try {
			
			//服务器的ip地址或主机名。
			String hadoopIpAddress = "172.16.100.144";
			//服务器的端口号。
			int hadoopPort = 8080;
			
			/**
			 * 构造一个RPC的Server。
			 * @param	setProtocol()中的参数Myinterface是自己定义并继承了VersionedProtocol接口的接口。VersionedProtocol所有使用Hadoop RPC协议的超类。
			 * @param	instance 实例中的方法会被客户端调用。		setInstance()中的参数是实现了Myinterface的类。	
			 * @param	bindAddress 绑定的这个地址用于监听连接的到来。	setBindAddress()中的参数是服务器的ip地址或主机名。
			 * @param	port 绑定的这个端口用于监听连接的到来。	setPort()中设置的服务器的端口号。
			 * @param	setNumHandlers()表示服务器端处理请求的线程数目。
			 * 
			 * BindAddress（由函数setBindAddress设置）和Port（由函数setPort设置，0表示由系统随机选择一个端口号）分别表示服务器的host和监听端口号，而NnumHandlers（由函数setNumHandlers设置）表示服务器端处理请求的线程数目。到此为止，服务器处理监听状态，等待客户端请求到达。
			 */
			//获得一个RPC服务端Server对象，Server实现了一个协议的实例，监听指定的端口和地址。
			Server server = new RPC.Builder(new Configuration()).setProtocol(Myinterface.class)
						.setInstance(new MyinterfaceImpl()).setBindAddress(hadoopIpAddress).setPort(hadoopPort) 
						.setNumHandlers(5).build(); 
			
			server.start(); 
			
		} catch (Exception e) {

			e.printStackTrace();
		
		}

	}
	
}


/**
 * 
* @ClassName: Myinterface 
* @Description: setProtocol()中的参数Myinterface是自己定义并继承了VersionedProtocol接口的接口。
* @author Cai ShiJun 
* @date 2017年12月20日 上午9:15:50 
*
 */
interface Myinterface extends VersionedProtocol{
	
	public final static long versionID = 102312313L;
	
	public String sayHello();
	
};


/**
 * 
* @ClassName: MyinterfaceImpl 
* @Description: instance 实例中的方法会被客户端调用。setInstance()中的参数是实现了Myinterface的类。
* @author Cai ShiJun 
* @date 2017年12月20日 上午9:15:53 
*
 */
class MyinterfaceImpl implements Myinterface{

	@Override
	public ProtocolSignature getProtocolSignature(String arg0, long arg1, int arg2) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getProtocolVersion(String arg0, long arg1) throws IOException {
		// TODO Auto-generated method stub
		return Myinterface.versionID;
	}
	
	public String sayHello(){
		
		System.out.println("我被在服务端调用了！~~");
		
		return "Hello!~";
	}
	
}

