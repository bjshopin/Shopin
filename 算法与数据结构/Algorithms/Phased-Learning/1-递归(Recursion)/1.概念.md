[TOC]
# 递归
## 1.介绍
### 1.1 定义 
http://blog.csdn.net/sinat_38052999/article/details/73303111
```
在数学与计算机科学中，递归(Recursion)是指在函数的定义中使用函数自身的方法。实际上，递归，顾名思义,其包含了两个意思：递 和 归，这正是递归思想的精华所在;
```
### 1.2 内涵和精髓
```
递归就是有去（递去）有回（归来），如下图所示。“有去”是指：递归问题必须可以分解为若干个规模较小，与原问题形式相同的子问题，这些子问题可以用相同的解题思路来解决，就像上面例子中的钥匙可以打开后面所有门上的锁一样；“有回”是指 : 这些问题的演化过程是一个从大到小，由近及远的过程，并且会有一个明确的终点(临界点)，一旦到达了这个临界点，就不用再往更小、更远的地方走下去。最后，从这个临界点开始，原路返回到原点，原问题解决。
```
### 1.3 图解
    
#### 1.3.1 方法之间的迭代
![](https://pic1.zhimg.com/80/1f818b686dc5482cbb8343d8caf65dac_hd.jpg)
#### 1.3.2 方法栈中
##### 1.3.2.1 简易图
![](http://img.blog.csdn.net/20170615220708910?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2luYXRfMzgwNTI5OTk=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
##### 1.3.2.2 JVM方法栈
![](https://images2015.cnblogs.com/blog/592743/201603/592743-20160321201532464-1956190499.png)
## 2 实践
### 2.1 应用场景
```
在我们实际学习工作中，递归算法一般用于解决三类问题：

　　 (1). 问题的定义是按递归定义的（Fibonacci函数，阶乘，…）；

　　 (2). 问题的解法是递归的（有些问题只能使用递归方法来解决，例如，汉诺塔问题，…）；

　　 (3). 数据结构是递归的（链表、树等的操作，包括树的遍历，树的深度，…）。

```
#### 2.1.1 问题的定义是递归的
##### 2.1.1.1 阶乘
```
 public class Solution {
    // 将这个过程放入到上述栈中理解;
    public static long getFactorial(long n) {
        if (n == 1) {
            return 1;
        } else {
            return n * getFactorial(n - 1);
        }
    }
    public static long getFactorial2(long n) {
        long sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }
    public static void main(String[] args) {
        long f = 5;
        System.out.println(getFactorial(5));
        System.out.println(getFactorial2(5));
    }
}
```
##### 2.1.1.2 斐波那契数列

 - 递归解法:有去有回
```
   public static Long fibonacci(long n) {
   
        if (n < 1) {
            return (long) 0;
        } else if (n == 1 || n == 2) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
```

 - 非递归解法:有去无回
 ```
   public static Long Fibonacci(long n) {
        long left = 1, right = 2;
        if (n == left) {
            return left;
        }
        if (n == right) {
            return right;
        }
        long sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = left + right;
            left = right;
            right = sum;
        }
        return sum;
    }
 ```
  - 动态规划解法: 用数组模拟
 ```
   public static Long getFibonacci(int n) {
        if (n > 0) {
            Long[] arr = new Long[n + 1];
            arr[1] = 1L;
            arr[2] = 2L;
            for (int i = 3; i <= n; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
            return arr[n];
        }
        return -1L;
    }
 ```
 #### 2.1.2 问题的解法是递归的
 ##### 2.1.2.1 汉诺塔问题
  - 三个盘的情况</br>
 ![](https://images2015.cnblogs.com/blog/702782/201611/702782-20161114211933513-1127552732.gif)
  - 四个盘的情况</br>
 ![](https://images2015.cnblogs.com/blog/702782/201611/702782-20161114212352576-1869972276.gif)
 ```
  
 ```
 #### 2.1.3 数据的结构是按递归定义的
 ##### 2.1.3.1 二叉树深度
 ```
    
 ```
 ##### 2.1.3.2 合并两个有序链表
 
 ## 3.练习
 ### 3.1