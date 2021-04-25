package com.senyint.test004;

/**
 * @author： Corley Cheng
 * @email： 981311938@qq.com
 * @date： 2021/4/25 15:38
 * @description：
 * @modifiedBy：
 * @version: 1.0
 * 首先，对线性回归的思路已有所了解，接下来是DEMO实验时间
 * 该次模拟的是对数据集求出一条拟合[直线]，找出拟合度最高的直线
 * 对此，有了截距和斜率的概念
 * 而根据最小二乘法，等等看不懂的算法模型最终得到一条拟合直线：
 * y=wx+b,此时，w为斜率，b为截距
 * 概念：损失函数，预测的结果和实际结果的差距的平方，一般用均方误差(MSE)函数
 * MSE=J(θ)=1/2 ∑i(ym i?y i)^2
 * 然后是模型权重的损失梯度：
 * J(θ)=12∑i(y^i?yi)2=12∑i(XiW?yi)2J(θ)=12∑i(y^i?yi)2=12∑i(XiW?yi)2
 * ?J?W=X(y^?y)
 * W=W?α?J?W
 * 当损失函数 J(θ) 收敛于某个可以接受的结果时，认为该模型表现最好
 */

public class XianXingHuiGui {

}
