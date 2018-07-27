package com.senyint.test003.yihuanxianxinghuigui;

import org.apache.commons.math3.stat.regression.SimpleRegression;

public class Test_xxhg_001 {

    public static void main(String[] args) {
    	
    	//data需要满足正态分布P值检验
      
    	double[][] data = { { 54, 61 }, { 66, 80 }, { 68, 62 }, { 76, 86 }, { 78, 84 }, { 82, 76 }, { 85, 85 }, { 87, 82 }, { 90, 88 }, { 94, 82 }, { 90, 88 }, { 94, 96 } };
        
        SimpleRegression regression = new SimpleRegression();
       
        regression.addData(data);// 增加要分析的数据
        
        System.out.println("斜率是：" + regression.getSlope());
        System.out.println("斜率标准差是：" + regression.getSlopeStdErr());
        System.out.println("截距是：" + regression.getIntercept());
        System.out.println("截距标准差是：" + regression.getInterceptStdErr());
        System.out.println("误差平方和是：" + regression.getSumSquaredErrors());
        System.out.println("相关系数是：" + regression.getR());
    }
	
}
