package com.senyint.test001;

import java.io.InputStream;
import java.net.URL;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

public class Test001 {
	
	private static final String HDFS_PATH = "hdfs://172.16.100.147:9000/hello";
	
	@Test
	public void app001(){
		try {
			
			URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
			
			URL url = new URL(HDFS_PATH);
			
			final InputStream in = url.openStream();
			
			/**
			 * @param in	输入流	
			 * @param out	输出流	System.out输出到控制台
			 * @param buffSize	缓冲区大小	1024
			 * @param close	是否关闭流 boolean	true输出后关闭流
			 */
			IOUtils.copyBytes(in, System.out, 1024, true);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}
}
