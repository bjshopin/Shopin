# Array 数组
## Array简介
### 数组:在内存中呈现出来的是 连续的片段;

## 数组常见方法
### 1.声明数组
```java
   class Main{
     public static void main(String[] args){
        int[] arr;
        String[] str;
        String str1[]=new String[5];
        int num[]=new int[6];
     }
   }
```
### 2.初始化数组
```java
   class Main{
     public static void main(String[] args){
       //定义一个长度为5的int数组;
       int[] arr=new int[]{1,2,3,4,5};
       
       //或者 控制台输入一个数，对数组赋值;
      for(int i=0;i<arr.length;i++){
          //in为自定义输入流 InputStream;
          arr[i]=in.nextInt();
      }
     }
   }
```
### 3.查看数组长度
```java
   class Main{
    public static void main(String[] args){
      int[] arr=new int[10];
      String[] str=new String[5];
      //对int数组来说,数组长度是数组的一个属性值,属性值的大小代表着数组的长度;
      int len_arr=arr.length;
      //对String数组来说,长度是数组的一个方法,方法的返回值是数组长度的大小;
      int len_str=str.length();
    }
   }
```
### 4.int数组转成 String数组
```java
   import java.util.Arrays;
   class Main{
     public static void main(String[] args){
       int[] arr=new int[]{
         1,2,3,4,5       
       };
       String arr=Arrays.toString(a);
       //arr为 [1, 2, 3, 4, 5]
     }
   }
```
### 5.从 array转化为 ArrayList
```java
   import java.util.Arrays;
   public class Main {
       public static void main(String[] args) {
           int[] arr = new int[]{
                   1, 2, 3, 4, 5
           };
           List<int[]> list = Arrays.asList(arr);
           for (int[] ints : list) {
               for (int anInt : ints) {
                   System.out.println(anInt);
               }
           }
       }
   }
```

### 6. Arrays.fill()填充数组
```java
   import java.util.Arrays;
   public class Main {
          public static void main(String[] args) {
              int[] arr=new int[5];
              Arrays.fill(arr,10);
              
          }
      }
```
## 7.数组排序
```java
   import java.util.Arrays;
   
   /**
    * @author littledream1502@gmail.com
    * @date 2017/12/13
    * @desc
    */
   public class Main {
       public static void main(String[] args) {
           int[] arr = new int[]{
                   1, 2, 5, 4, 3
           };
           Arrays.sort(arr);
           for (int i : arr) {
               System.out.println(i);
           }
       }
   }
```
## 8. 复制数组
```java
import java.util.Arrays;

/**
 * @author littledream1502@gmail.com
 * @date 2017/12/13
 * @desc
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 2, 5, 4, 3
        };
        //方法一:
        int[] copy = Arrays.copyOf(arr, 10);
        for (int i : copy) {
            System.out.print(i + " ");
        }
        //1 2 5 4 3 0 0 0 0 0 
        System.out.println();
        //方法二:
        int[] range = Arrays.copyOfRange(arr, 1, 3);
        for (int i : range) {
            System.out.print(i + " ");
        }
        //2 5
    }
}

```
