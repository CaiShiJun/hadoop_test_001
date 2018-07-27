package com.senyint.test002.RPC;

import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

/**
 * 
* @ClassName: MyClient 
* @Description: RPC远程过程调用的客户端
* @author Cai ShiJun 
* @date 2017年12月19日 下午7:34:40 
*
 */
public class MyClient {
	
	public static void main(String[] args) {
		
		try {
			
			/**
			 * 构造一个客户端的代理对象，这个代理对象实现了一个命名的协议，和服务端交流对话通信的，这个服务端是在一个指定的地址上的。
			 * @param Class<T> protocol 
			 * 		实现了VersionedProtocol接口的对象。
			 * 		VersionedProtocol所有使用Hadoop RPC协议的超类。
			 * 		必须是一个接口的.class。
			 * @param  long clientVersion
			 * 		long类型的数字。
			 * @param InetSocketAddress addr
			 * 		new InetSocketAddress(服务器的ip地址或主机名,服务器的端口号)
			 * @param Configuration conf 
			 * 		配置 可以直接new Configuration()
			 */
			//RPC.getProxy(protocol, clientVersion, addr, conf);与RPC.waitForProxy(protocol, clientVersion, addr, conf);功能相同。
			Myinterface myinterface = RPC.waitForProxy(Myinterface.class, Myinterface.versionID, new InetSocketAddress("172.16.100.144",8080), new Configuration());
			
			String result = myinterface.sayHello();
			
			System.out.println("客户端调用结果："+result);
			
			//关闭代理对象
			RPC.stopProxy(myinterface);
			
		} catch (Exception e) {
		
			e.printStackTrace();
			
		}
		
	}
	
}
