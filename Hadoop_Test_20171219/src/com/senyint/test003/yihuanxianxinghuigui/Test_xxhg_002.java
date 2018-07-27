package com.senyint.test003.yihuanxianxinghuigui;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

import org.apache.commons.math3.distribution.NormalDistribution;
/**
 * 
 * @(#)zheng01.java 
 * @Description:描述：根据提供的正态分布的均值和标准差得到正态概率的具体实现。
 * @Definitions:定义：在处理符合正态分布的连续型数据，知道了这组数据的均值和方差为了求得随机变量符合某个范围的概率为：P(X<x)这类问题称之为正态概率。表达式为：X~N(μ,σ^2)             
 * @Explanation:符号解释：μ为该组连续数据的均值；σ为该组连续数据的标准差。
 * @Comments:条件：在一组连续型数据，已知该组数据的均值和标准差，求解随机变量x的正态概率。这种情况下适用于本算法。
 * @优点:知道正态分布具体的均值和标准差可以利用此算法快速求出小于随机变量X的正态概率。
 * @缺点:无法近似估算符合几何分布的问题，无法精确解决离散数据概率，对于没有给出均值或者标准差的正态分布无法计算。
 * @适用场景:连续型数据或者数据离散性小，数据基本符合正态分布特点，或者对不符合的数据进行取对数或者样本重新排序达到正态分布特点，有具体的均数（期望）和标准差。。
 * @不适用场景:数据离散性太大，数据不符合正态分布特点，通过对数据进行取对数或者重新排序亦无法达到正态分布特点，无法得出均数（期望）和标准差。
 * @输入/出参数:见具体方法
 * @异常/误差:
 *          异常：输入数据不合法，如：要求输入double数据，输入字母。
 *          误差：保留小数位数造成不精确
 *       解决：
 *          异常:输入不合法给予提示。
 *          误差：进行小数点位数自定义保留封装，根据具体精度进行设置。
 * @Create Date：  2015年8月6日16:39:25
 * @since   JDK1.6  s
 * @author Magicfairytail
 */
public class Test_xxhg_002 {

    public static void main(String[] args) {
        /**
         * 均值为 μ标准差σ的正态分布的具体实现
         * @param μ double型保留四位小数，表示正态分布均值
         * @param σ double型保留四位小数，表示正态分布标准差
         * @return S1 double型保留四位小数，表示p(X<x)的正态概率
         */
        NormalDistribution normalDistributioin = new NormalDistribution(0,1);//新建一个标准正态分布对象
        Scanner in=new Scanner(System.in);
        do {
            System.out.println("请输入ц:");
            double ц=in.nextDouble();
            //ц=NumberFormat.ZeroFormat(ц);//对所得数据保留4位小数
            System.out.println("请输入σ:");
            double σ=in.nextDouble();
            //σ=NumberFormat.ZeroFormat(σ);    //对所得数据保留4位小数            

            System.out.println("请输入x:");
            double x=in.nextDouble();
            //x=NumberFormat.ZeroFormat(x);//对所得数据保留4位小数
            double z=(x-ц)/σ;
            z=ZeroFormat(z,4);//对所得数据保留4位小数
                try {
                    double S1 = normalDistributioin.cumulativeProbability(z);
                    S1=ZeroFormat(S1,4);//对所得数据保留4位小数
                    System.out.println("正态分布概率为：");
                    System.out.println(S1);
                    System.out.println();
                    System.out.println("请问您还要继续输入吗？(1/0)");
                    
                } catch (Exception e) {
                    // 这里的异常为所得的结果过小导致异常，直接将结果自动置0
                    System.out.println("正态分布概率为：");
                    System.out.println("0");
                    System.out.println();
                    System.out.println("请问您还要继续输入吗？(1/0)");
                }
            
        } while (in.nextInt()==1);//while循环，当输入的值为1继续，为其他值则终止程序
    }
    
    
    public static double ZeroFormat(double num,int n)
    {
        BigDecimal bigDecimal=new BigDecimal(num);
        //DecimalFormat ff = new DecimalFormat("#.0000");  //保留四位小数
        //double result = Double.valueOf(ff.format(num));
        //return result;
        return bigDecimal.setScale(n, BigDecimal.ROUND_HALF_UP).doubleValue();
                //setscale(n,BigDecimal.ROUND_HALF_UP).doubleValue;
    }
}