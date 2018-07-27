package com.senyint.test001;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.junit.Test;

/**
 * 
* @ClassName: Test002 
* @Description:	使用FileSystem
* @author Cai ShiJun 
* @date 2017年12月19日 下午1:23:08 
*
 */
public class Test002 {
	
	//hadoop中的文件路径
	private static final String HDFS_PATH = "hdfs://172.16.100.147:9000/hello";
	
	//org.apache.hadoop.fs.FileSystem的变量
	private static FileSystem fileSystem = null;
	
	static{
		
		try {
			
			Configuration conf = new Configuration();
			URI uri = new URI(HDFS_PATH);
			
			fileSystem = FileSystem.get(uri , conf);
		
		} catch (Exception e) {

			e.printStackTrace();

		}
		
	}
	
	
	/**
	 * 
	* @Title: createFolder 
	* @Description: 创建文件夹
	* @throws 
	* @author Cai ShiJun 
	* @date 2017年12月19日 下午5:07:32
	 */
	@Test
	public void createFolder(){
		
		try {
			
			final String DIR_PATH = "/d20171219165801";
			
			fileSystem.mkdirs(new Path(DIR_PATH));
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	
	/**
	 * 
	* @Title: uploadFiles 
	* @Description: 上传文件
	* @throws 
	* @author Cai ShiJun 
	* @date 2017年12月19日 下午5:37:30
	 */
	@Test
	public void uploadFile(){
		
		try {
			
			final String FILE_PATH = "/d20171219165801/f1000";
			
			final FSDataOutputStream out = fileSystem.create(new Path(FILE_PATH));
			
			final InputStream in = new FileInputStream("D:/hadoop_test.txt");
			
			/**
			 * @param in	输入流	
			 * @param out	输出流
			 * @param buffSize	缓冲区大小	1024
			 * @param close	是否关闭流 boolean	true输出后关闭流
			 */
			IOUtils.copyBytes(in, out, 1024, true);
			
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		
	}
	
	
	/**
	 * 
	* @Title: downloadFiles 
	* @Description: 下载文件
	* @throws 
	* @author Cai ShiJun 
	* @date 2017年12月19日 下午5:58:45
	 */
	@Test
	public void downloadFile(){
		
		try {
			
			final String FILE_PATH = "/d20171219165801/f1000";
			
			final FSDataInputStream in = fileSystem.open(new Path(FILE_PATH));
			
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
	
	
	/**
	 * 
	* @Title: deleteFile 
	* @Description: 删除文件
	* @throws 
	* @author Cai ShiJun 
	* @date 2017年12月19日 下午6:07:21
	 */
	@Test
	public void deleteFile(){
		
		try {
			
			final String FILE_PATH = "/d20171219165801/f1000";
			
			/**
			 * @param recursive 递归
			 */
			Boolean recursive = true;
			fileSystem.delete(new Path(FILE_PATH), recursive);
			
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		
	}
	
}
