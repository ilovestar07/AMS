package com.fintech.calculator.util;

import com.fintech.base.util.MathUtil;

public class NewtonUtil {

private final static double E = 1e-13;
	
	private final static int REALRATE_LOOP_NUM = 1000000;
	
	/*
	 * a 是最高次幂, b 为最低次幂 , x为根 ,f为系数数组 s 为方程和
	 */
	public static double f(int a, int b, double x, double[] f, double s) // f(x)，其中x=i+1
	{
		double sum = 0;
		int i;
		for (i = a; i >= b; i--) {
			sum += Math.pow(x, (double) i) * f[i - 1];
		}
		sum -= s;
		return sum;
	}

	/*
	 * 求f(x)的导数,其中x=i+1a 是最高次幂, b 为最低次幂 ,x 为根，f为系数数组：从低到高
	 */
	public static double f1(int a, int b, double x, double[] f) {
		double sum = 0, temp;
		int i;
		for (i = a; i >= b; i--) {
			temp = Math.pow(x, (double) (i - 1));
			temp *= i;
			sum += temp * f[i - 1];
		}
		return sum;
	}

	/*
	 * a 是最高次幂, b 为最低次幂 , x为根 ,f为系数数组 s 为方程和
	 */
	public static double f(double[] a, double x, double[] f, double s) // f(x)，其中x=i+1
	{
		double sum = 0;
		int j = 1;
		for (double i : a) {
			sum += Math.pow(x, i) * f[j - 1];
			j++;
		}
		sum -= s;
		return sum;
	}
	
	/*
	 * 求f(x)的导数,其中x=i+1a 是最高次幂, b 为最低次幂 ,x 为根，f为系数数组：从低到高
	 */
	public static double f1(double[] a, double x, double[] f) {
		double sum = 0, temp;
		int j = 1;
		for (double i : a) {
			temp = Math.pow(x, (double) (i - 1));
			temp *= i;
			sum += temp * f[j - 1];
			j++;
		}
		return sum;
	}
	
	/**
	 * a 是最高次幂, b 为最低次幂 ,x 为根 ,f为因子,s结果
	 * 
	 * @param a
	 * @param b
	 * @param x
	 * @param f
	 * @param s
	 * @return
	 */
	public static double calx(int a, int b, double[] f, double s) {
		double rt = 0;
		double x0, x1;
		x0 = 1; // 迭代的初值为1

		x1 = x0 - f(a, b, x0, f, s) / f1(a, b, x0, f);

		while (Math.abs(x0 - x1) > E) {
			x0 = x1;
			x1 = x0 - f(a, b, x0, f, s) / f1(a, b, x0, f);
		}
		rt = x1 - 1;
		return rt;
	}

	/**
	 * a 是幂的数组, f为因子,s结果
	 * 
	 * @param a
	 * @param b
	 * @param x
	 * @param f
	 * @param s
	 * @return
	 */
	public static double calx(double a[], double[] f, double s) {
		double rt = 0;
		double x0, x1;
		x0 = 1; // 迭代的初值为1
		x1 = x0 - f(a, x0, f, s) / f1(a, x0, f);
		//设置最大迭代次数
		int loopNum = 0;
		while (Math.abs(x0 - x1) > E && ++loopNum<=REALRATE_LOOP_NUM) {
			x0 = x1;
			x1 = x0 - f(a, x0, f, s) / f1(a, x0, f);
		}
		rt = x1 - 1;
		return rt;
	}
	
	/**
	 *  
	 * @param a 幂数组
	 * @param x 自变量
	 * @param f 因子
	 * @return
	 */
	public static double caly(double x,double a[], double[] f) {
		double sum = 0, temp;
		int j = 1;
		for (double i : a) {
			temp = Math.pow(1+x, (double) i);
			sum += temp * f[j-1];
			j++;
		}
		return sum;
	}
	
	/**
	 * 单利计算收益率
	 * @param a 指数
	 * @param f 现金流
	 * @param s 现值
	 * @return
	 */
	public static double calsx(double a, double f, double s) {
		double rt = 0;
		rt = MathUtil.div(MathUtil.div(MathUtil.sub(f, s), s),-a);
		return rt;
	}
	
	/**
	 * 单利计算现值
	 * @param x 收益率
	 * @param a 指数
	 * @param f 现金流
	 * @return
	 */
	public static double calsy(double x,double a, double f) {
		double sum = 0;
		sum = MathUtil.div(f, MathUtil.add(MathUtil.mul(x, -a), 1));
		return sum;
	}
}
