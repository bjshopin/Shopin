<!-- GFM-TOC -->
* [图论大纲](#图论大纲)
    * [1.基本概念](#1基本概念)
        * [1.1 顶点](#11-顶点)
        * [1.2 边](#12-边)
        * [1.3 同构(Isomorphism)](#13-同构isomorphism)
        * [1.4 有向图/无向图(Directed Graph/Undirected Graph)](#14-有向图无向图directed-graphundirected-graph)
        * [1.5 权重](#15-权重)
        * [1.6 路径/(最短路径)](#16-路径最短路径)
        * [1.7 环(Loop)](#17-环loop)
        * [1.8 连通图/连通分量](#18-连通图连通分量)
    * [2.图的基本表现形式-树](#2图的基本表现形式-树)
        * [2.1 节点](#21-节点)
        * [2.2 树枝](#22-树枝)
        * [2.3 根](#23-根)
        * [2.4 叶子](#24-叶子)
        * [2.5 度(degree)](#25-度degree)
        * [2.6 树的深度/高度](#26-树的深度高度)
        * [2.7 双亲/孩子/兄弟](#27-双亲孩子兄弟)
        * [2.8 祖先/后代](#28-祖先后代)
        * [2.9 森林](#29-森林)
    * [3.图的遍历](#3图的遍历)
        * [3.1 图和树的遍历](#31-图和树的遍历)
        * [3.2 图的存储结构](#32-图的存储结构)
        * [3.3 遍历的方法](#33-遍历的方法)
    * [5.最小生成树算法](#5最小生成树算法)
        * [5.1 Kruskal算法](#51-kruskal算法)
        * [5.2 Prime算法](#52-prime算法)
<!-- GFM-TOC -->

# 图论大纲
## 1.基本概念
### 1.1 顶点

### 1.2 边
### 1.3 同构(Isomorphism)
```
  先看如下两张图:
```
![](http://img.blog.csdn.net/20170114203821554?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
![](http://img.blog.csdn.net/20170114203821554?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
```
   首先你的感觉是这2个图肯定不一样。但从图（graph）的角度出发，这2个图是一样的，即它们是同构的。前面提到顶点和边指的是事物和事物的逻辑关系，不管顶点的位置在哪，边的粗细长短如何，只要不改变顶点代表的事物本身，不改变顶点之间的逻辑关系，那么就代表这些图拥有相同的信息，是同一个图。同构的图区别仅在于画法不同。
```
### 1.4 有向图/无向图(Directed Graph/Undirected Graph)
![](http://img.blog.csdn.net/20170114203919888?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
```
   两者唯一的区别在于，有向图中的边是有方向性的;
```
### 1.5 权重
![](http://img.blog.csdn.net/20170114204047047?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
```
  边的权重(或者称为权值,长度或者开销),这是一个非常核心的概念,即每条边都有与之对应的值.
```
### 1.6 路径/(最短路径)
```
  在A到B有多种方案可行时,由于每条边的权值不同,选择最短路径由此而来;
```
### 1.7 环(Loop)
![](http://img.blog.csdn.net/20170114204157508?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
```
  环本身就是一种特殊的图结构;
```
### 1.8 连通图/连通分量
```
  任意2个顶点之间都存在路径,那么称图G为连通图(注意是任意两点之间),例如1.7中的环图中;
```
![](http://img.blog.csdn.net/20170114204236618?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
```
  上图中虽然不是一个连通图,但是它包含很多连通子图: 0,1,2三点构成一个连通子图,0,1,2,3,4顶点也构成一个连通子图。我们把一个图的最大连通子图称之为它的连通分量.0,1,2,3,4顶点构成的连通子图就是这个大图的连通分量。
```
  连通分量存在以下特点
 - 是子图
 - 子图是连通的
 - 子图含有最大顶点数
## 2.图的基本表现形式-树
![](http://img.blog.csdn.net/20170114205103422?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
```
  树是图的一种特例。用图来定义树: 任意两点之间都连通，并且没有"环"的图.
  
```
### 2.1 节点
### 2.2 树枝
```
  即为图的边;
```
### 2.3 根
### 2.4 叶子
```
由根开始不断分枝，途中所有无法再分枝的节点成为叶
```
### 2.5 度(degree)
![](http://img.blog.csdn.net/20170114205228982?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
```
  一个节点拥有的子树数称之为该节点的度(degree).上图中，根节点0有3个子树,度为3;节点1有2个子树,度为2;节点3,5分别只有一个子树,度为1.叶子也可以用度来定义,度数为0的节点为叶子节点.节点2,4,6,7没有子树,度为0,所以2,4,6,7为叶子;
```
### 2.6 树的深度/高度
![](http://img.blog.csdn.net/20170114205251315?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
```
 当一棵树选定一个节点作为root时,按照每一个节点距离root的距离,可以将树中的节点分为多个层级;
```
```
  一棵树最大的层级数称之为树的深度或高度。一个节点到下方的叶子的最大层级数之差称之为该节点的高度;
  如节点1位于层1,下方的叶子2,4位于层2，所以节点1的高度是1；同理，节点3的高度也是1，节点5的高度是2，节点2本身是叶，其高度是0，根节点0的高度是3。
```
### 2.7 双亲/孩子/兄弟
![](http://img.blog.csdn.net/20170114205315519?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
```
   如上图中，0是1的双亲(parent)，2,4是1的孩子(child)。2，4有共同的双亲，因此2,4之间互称为兄弟（sibling）。 
同样的，3是6的双亲，6是3的孩子；5是8的双亲，8是5的孩子。1,3,5是0的孩子，1,3,5互称为兄弟。 
```
### 2.8 祖先/后代
### 2.9 森林
```
   很多颗树的集合称之为森林.在森林中,树与树之间互不相交;
```
   特性:
 - 1.树中所有点都是连通的； 
 - 2.树中任意2点之间只有唯一一条路径； 
 - 3.树是无环的连通图； 
 - 4.森林是无环的非连通图。
## 3.图的遍历
### 3.1 图和树的遍历
```
   树的遍历是从根节点开始的，由于每个节点都只有一个双亲，因此其遍历还是相对简单的。而图的遍历则可以选择从任意一个节点开始，同时图中每一个节点都可能与其余的节点相邻接，不可避免的会多次访问同一个节点，因此在遍历的过程中需要将已访问的节点打上标记，以避免重复。 
```
### 3.2 图的存储结构
#### 3.2.1 邻接矩阵
```
简单的说就是用数组来存储点与点之间的关系,分为无向图和有向图两种,邻接矩阵的定义如下:
```
![](https://github.com/wangkuiwu/datastructs_and_algorithm/blob/master/pictures/graph/basic/04.jpg?raw=true)
```
下面通过示意图来显示无向图和有向图的邻接矩阵的表示:
```
 - 无向图
![](https://github.com/wangkuiwu/datastructs_and_algorithm/blob/master/pictures/graph/basic/05.jpg?raw=true)
 - 有向图
![](https://github.com/wangkuiwu/datastructs_and_algorithm/blob/master/pictures/graph/basic/06.jpg?raw=true)

#### 3.2.2 邻接表
```
  邻接表是图的一种链式表达方式.他是改进后的"邻接矩阵",它的缺点是不方便判断两个顶点之间是否存在边,但是相对于邻接矩阵来讲更省空间;
```
 邻接表的表示方式:
 - 无向图邻接表
![](https://github.com/wangkuiwu/datastructs_and_algorithm/blob/master/pictures/graph/basic/07.jpg?raw=true)
 - 有向图邻接表
![](https://github.com/wangkuiwu/datastructs_and_algorithm/blob/master/pictures/graph/basic/08.jpg?raw=true)

### 3.3 遍历的方法
#### 3.3.1 广度优先搜索
 - BFS(广度优先搜索)
```
  BFS是针对于图和树的一种遍历算法,最初设计目的在于解决迷宫最短路问题和网络路由问题.
```
```
  BFS使用队列(QUEUE)来实施算法过程,队列(QUEUE)有着先进先出(FIFO)的特性;
```
```
  BFS操作步骤:
     1.把起始点放入queue队列中;
     2.重复下述2步骤,直到queue为空为止;
       2.1 从queue 中取出队列头的点;
       2.2 找出与此点邻接的尚未遍历的点,进行标记,然后全部放入queue中;
```
  对于以下树来举一个栗子,BFS首先会从根节点开始,其搜索节点顺序为1,2,3,4,5,6,7,8
![](http://img.blog.csdn.net/20170114211759962?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
 - 1.将起始节点1放入到队列中,标记为已经遍历;
![](http://img.blog.csdn.net/20170114211828038?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
 - 2.从队列 queue中取出队列头的节点1,找出与节点1邻近的节点2,3，标记为已遍历,然后放入queue中;
![](http://img.blog.csdn.net/20170114211840976?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
 - 3.从queue中取出队列头的节点2,找到与节点2邻近的节点1,4,5,由于节点1已经遍历，排除掉;标记4,5为已遍历,然后放入queue中;
![](http://img.blog.csdn.net/20170114211850086?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
 - 4.从queue中取出队列头的节点3,找出与节点3邻接的节点1,6,7,由于节点1已遍历,排除;标记6,7节点为已遍历,然后放入queue中;
 ![](http://img.blog.csdn.net/20170114211907775?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
 - 5.从queue中取出队列头的节点4，找出与节点4邻接的节点2,8，2属于已遍历点，排除；因此标记节点8为已遍历，然后放入queue中.
![](http://img.blog.csdn.net/20170114211918416?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
 - 6.从queue中取出队列头的节点5，找出与节点5邻接的节点2,8，2,8均属于已遍历点，不作下一步操作。
 ![](http://img.blog.csdn.net/20170114211927463?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
 - 7.从queue中取出队列头的节点6，找出与节点6邻接的节点3,8,9，3,8属于已遍历点，排除；因此标记节点9为已遍历，然后放入queue中
 ![](http://img.blog.csdn.net/20170114211935619?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
 - 8.从queue中取出队列头的节点7，找出与节点7邻接的节点3, 9，3,9属于已遍历点，不作下一步操作。 
 - 9.从queue中取出队列头的节点8，找出与节点8邻接的节点4,5,6，4,5,6属于已遍历点，不作下一步操作.
![](http://img.blog.csdn.net/20170114211952072?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
 - 10.从queue中取出队列头的节点9，找出与节点9邻接的节点6,7，6,7属于已遍历点，不作下一步操作。
![](http://img.blog.csdn.net/20170114211959744?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
 - 11.queue队列中为空,BFS遍历为空;
##### 3.3.1.1 代码演示
```
   
```
#### 3.3.2 深度优先搜索
 - DFS(深度优先搜索)
```
  DFS的实现方式相比于BFS应该说大同小异，只是把queue换成了stack而已，stack具有后进先出LIFO(Last Input First Output)的特性。
```
  - 动图展示:
![](http://img.blog.csdn.net/20150313232402246)
```
  DFS操作步骤如下:
     1.把起始点放入stack;
     2.重复一下三个步骤,知道stack为空为止;
       2.1 从stack中访问栈顶元素;
       2.2 找出与此点邻接的尚未遍历的点,进行标记,然后全部放入stack中;
       2.3 如果此点没有尚未遍历的邻接点,则将此点从stack中弹出;
```
下面结合图示实例,讲述DFS的工作过程和原理:
 - 1.将起始节点1放入栈Stack中,标记为已遍历;
![](http://img.blog.csdn.net/20170114212500142?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
 - 2.从stack中访问栈顶的节点1，找出与节点1邻接的节点，有2,8两个节点，我们可以选择其中任何一个，选择规则可以人为设定，这里假设按照节点数字顺序由小到大选择，选中的是2，标记为已遍历，然后放入stack中。 
![](http://img.blog.csdn.net/20170114212509642?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
 - 3.从stack中取出栈顶的节点2，找出与节点2邻接的节点，有1,3,5三个节点，节点1已遍历过，排除；3,5中按照预定的规则选中的是3，标记为已遍历，然后放入stack中;
![](http://img.blog.csdn.net/20170114212524377?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
 - 4.从stack中取出栈顶的节点3，找出与节点3邻接的节点，有2,4两个节点，节点2已遍历过，排除；选中的是节点4，标记为已遍历，然后放入stack中。
![](http://img.blog.csdn.net/20170114212532403?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
 - 5.从stack中取出栈顶的节点4，找出与节点4邻接的节点，有3,5,6三个节点，节点3已遍历过，排除；选中的是节点5，标记为已遍历，然后放入stack中。 
![](http://img.blog.csdn.net/20170114212540044?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
 - 6.从stack中取出栈顶的节点5，找出与节点5邻接的节点，有2,4两个节点，节点2,4都已遍历过，因此节点5没有尚未遍历的邻接点，则将此点从stack中弹出。 
![](http://img.blog.csdn.net/20170114212548872?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
 - 7.当前stack栈顶的节点是4，找出与节点4邻接的节点，有3,5,6三个节点，节点3,5都已遍历过，排除；选中的是节点6，标记为已遍历，然后放入stack中;
![](http://img.blog.csdn.net/20170114212556424?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
 - 8.当前stack栈顶的节点是6，找出与节点6邻接的节点，有4,7,8三个节点，4已遍历，按照规则选中的是7，标记为已遍历，然后放入stack中
![](http://img.blog.csdn.net/20170114212604487?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
 - 9.当前stack栈顶的节点是7，找出与节点7邻接的节点，只有节点6，已遍历过，因此没有尚未遍历的邻接点，将节点7从stack中弹出。 
![](http://img.blog.csdn.net/20170114212611909?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
 - 10.当前stack栈顶的节点是6，找出与节点6邻接的节点，有节点7,8，7已遍历过，因此将节点8放入stack中.
![](http://img.blog.csdn.net/20170114212618862?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
 - 11.当前stack栈顶的节点是8，找出与节点8邻接的节点，有节点1,6,9，1,6已遍历过，因此将节点9放入stack中。
![](http://img.blog.csdn.net/20170114212626190?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvc2FsdHJpdmVy/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
 - 12.当前stack栈顶的节点是9，没有尚未遍历的邻接点，将节点9弹出，依次类推，栈中剩余节点8,6,4,3,2,1都没有尚未遍历的邻接点，都将弹出，最后栈为空。
 - 13.DFS遍历结束;
#### 3.3.2.1 代码演示:
```
/**
 * @author littledream1502@gmail.com
 * @date 2018/3/3
 * @desc 深度优先搜索
 */
public class DFS {
    static class Node {
        int x;
        Node next;

        public Node(int x) {
            this.x = x;
            this.next = null;
        }
    }

    public Node first;
    public Node last;

    public static final int N = 9;
    public static int[] run = new int[N];
    public static DFS[] head = new DFS[N];

    public static void dfs(int current) {
        run[current] = 1;
        System.out.print("[" + current + "]");
        while (head[current].first != null) {
            if (run[head[current].first.x] == 0) {
                dfs(head[current].first.x);
            }
            head[current].first = head[current].first.next;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void print() {
        Node current = first;
        while (current != null) {
            System.out.print("[" + current.x + "]");
            current = current.next;
        }
        System.out.println();
    }

    public void insert(int x) {
        Node node = new Node(x);
        if (this.isEmpty()) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = last.next;
        }
    }

    public static void main(String[] args) {
        int[][] data = {
                {1, 2}, {2, 1}, {1, 3}, {3, 1}, {2, 4}, {4, 2},
                {2, 5}, {5, 2}, {3, 6}, {6, 3}, {3, 7}, {7, 3}, {4, 5}, {5, 4},
                {6, 7}, {7, 6}, {5, 8}, {8, 5}, {6, 8}, {8, 6}
        };
        int dataNum, i, j;
        System.out.println("图形的邻接表内容为:");
        for (i = 1; i < 9; i++) {
            run[i] = 0;
            head[i] = new DFS();
            System.out.print("顶点" + i + "=>");
            for (j = 0; j < 20; j++) {
                if (data[j][0] == i) {
                    head[i].insert(data[j][1]);
                }
            }
            head[i].print();
        }
        System.out.println("深度优先遍历顶点:");
        dfs(1);
        System.out.println();
    }
}

```
## 5.最小生成树算法
### 5.1 Kruskal算法
### 5.2 Prime算法
