<!-- GFM-TOC -->
* [中台SOA部署规范](#中台soa部署规范)
    * [1. 构建](#1-构建)
        * [1.1 项目拆分](#11-项目拆分)
          * [1.1.1 拆分逻辑](#111-拆分逻辑) 
        * [1.2 包名规范](#12-包名规范)
        * [1.3 类名规范](#13-类名规范)
        
<!-- GFM-TOC -->
# 中台SOA部署规范
## 1. 构建
### 1.1 项目拆分
#### 1.1.1 拆分逻辑
```
 由于之前ssd的主要服务来源于ssd-common项目,其中主要包括四部分业务的处理: 
（1）主数据(materiel)
（2）价格(price)
（3）库存(stock)
（4）盘点(inventory)
```
```
  拆分逻辑就是: 主数据-> 价格 -> 库存 -> 盘点, 按照数据流向划分。
  以盘点为例(考虑读写分离) ,简单讲解下如何拆分:
```
<table frame="hsides" rules="groups" cellspacing=0 cellpadding=0>
<!-- 表头部分 -->
<thead align=center style="font-weight:bolder; background-color:#cccccc">
     <tr>
          <td>模块(项目)名称</td>
          <td>模块(项目)作用</td>
          <td>模块(项目)类型</td>
     </tr>
</thead>

<tbody>
    <tr>
        <td>mpsi-common-bean</td>
        <td>所有的实体类 </td>
        <td>jar</td>
    </tr>
    <tr>
        <td>inventory-query-persistence</td>
        <td>盘点查询内容的持久化层</td>
        <td>jar</td>
    </tr>
    <tr>
        <td>inventory-query-service</td>
        <td>盘点查询内容的Interface </td>
        <td>jar</td>
    </tr>
    <tr>
        <td>inventory-query-service-impl</td>
        <td>盘点查询内容的服务实现类</td>
        <td><font color="red">war</font></td>
    </tr>
    <tr>
        <td>inventory-update-persistence</td>
        <td>盘点更新操作的持久化层</td>
        <td>jar</td>
    </tr>
    <tr>
        <td>inventory-update-service</td>
        <td> 盘点更新操作的Interface</td>
        <td>jar</td>
    </tr>
     <tr>
        <td>inventory-update-service-impl</td>
        <td>盘点更新操作的服务实现类</td>
        <td><font color="red">war</font></td>
    </tr>
</tbody>
</table>
 
  - 解析
```
   在考虑了SOA架构,项目读写分离以及JenKins部署的前提下,我们将服务的提供方单独提取出来(共8个项目),
   其余组件(bean,mapper,service)构建为聚合工程来统一控制组件版本.经过整理之后,将所有的impl归为一类,
   将其他所有的组件(mpsi-parent)加入到聚合工程中,因为组件到时只是为了向私服部署,
   而impl是要结合Jenkins部署,因此impl要单独独立出来;
```
  - impl结构图
<div align=center><img src="https://github.com/bjshopin/Shopin/blob/master/%E6%8A%80%E6%9C%AF%E5%BC%80%E5%8F%91/%E4%B8%AD%E5%8F%B0SOA%E9%A1%B9%E7%9B%AE%E9%83%A8%E7%BD%B2%E8%A7%84%E8%8C%83/img/2.png"/>
</div>
 - 后台组件图(聚合项目)
<div align=center><img src="https://github.com/bjshopin/Shopin/blob/master/%E6%8A%80%E6%9C%AF%E5%BC%80%E5%8F%91/%E4%B8%AD%E5%8F%B0SOA%E9%A1%B9%E7%9B%AE%E9%83%A8%E7%BD%B2%E8%A7%84%E8%8C%83/img/1.png"/>
</div>

#### 1.1.2 项目命名
```
     统一使用: 项目名称 + (读/写) + 功能(persistence/service/serviceImpl/bean) 
```

##### 1.1.2.1 Group
```
 net.shopin.[project]
```
##### 1.1.2.2 Artifact
```
   [project]-bean
   [project]-[Query/Update]-persistence
   [project]-[Query/Update]-service
   [project]-[Query/Update]-service-impl
   [project]-schedule
```

##### 1.1.2.3 Package
```
 net.shopin.[artifact].[module]
```

#### 1.1.3 模块依赖

<table frame="hsides" rules="groups" cellspacing=0 cellpadding=0>
<!-- 表头部分 -->
<thead align=center style="font-weight:bolder; background-color:#cccccc">
     <tr>
          <td>项目ID</td>
          <td>项目名称</td>
          <td>项目作用</td>
          <td>项目类型</td>
          <td>项目依赖</td>
          <td>项目Parent</td>
     </tr>
</thead>

<tbody>
    <tr>
        <td>1</td>
        <td>bean </td>
        <td>实体类</td>
        <td>jar</td>
        <td>NULL</td>
        <td>mpsi-parent</td>
    </tr>
    <tr>
        <td>2</td>
        <td>persistence</td>
        <td>持久化Mapper</td>
        <td>jar</td>
        <td>1</td>
        <td>mpsi-parent</td>
    </tr>
    <tr>
        <td>3</td>
        <td>service </td>
        <td>暴露的service</td>
        <td>jar</td>
        <td>1</td>
        <td>mpsi-parent</td>
    </tr>
    <tr>
        <td>4</td>
        <td><font color="red">service-impl(非模块)</font></td>
        <td>服务实现</td>
        <td><font color="red">war</font></td>
        <td>2,3</td>
        <td>mpsi-parent</td>
    </tr>
    <tr>
        <td>5</td>
        <td>web</td>
        <td>项目View</td>
        <td><font color="red">war</font></td>
        <td>1,3</td>
        <td>mpsi-parent</td>
    </tr>
    <tr>
        <td>6</td>
        <td>schedule</td>
        <td>定时Job</td>
        <td><font color="red">war</font></td>
        <td>1,3</td>
        <td>mpsi-parent</td>
    </tr>
</tbody>
</table>

### 1.2 项目搭建
#### 1.2.1 项目结构
##### 1.2.1.1 mpsi-dependencies
###### 1.2.1.1.1 作用
```
  mpsi-dependencies的主要目的在于 : 
  用来指定SpringBoot体系中没有的第三方JAR版本,
  例如在此项目中需要的Zookeeper,Dubbo等等的版本号;
  
  其次一个目的就是 : 用于maven部署管理，一方面需要将自身deploy至Nexus,
  另一方面也使得继承与它的子项目可以打包deploy至私服;
```
###### 1.2.1.1.2 Maven依赖
```
   1.	<?xml version="1.0" encoding="UTF-8"?>  
2.	  
3.	<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
4.	         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
5.	    <!—parent为spring-boot-starter-parent, 用于使子项目可以引入SpringBoot相关依赖,主版本控制 -->  
6.	    <parent>  
7.	        <groupId>org.springframework.boot</groupId>  
8.	        <artifactId>spring-boot-starter-parent</artifactId>  
9.	        <version>1.5.8.RELEASE</version>  
10.	        <!--  
11.	        默认值为../pom.xml  
12.	        查找顺序：relativePath元素中的地址–本地仓库–远程仓库  
13.	        -->  
14.	        <relativePath/>  
15.	    </parent>  
16.	    <groupId>net.shopin</groupId>  
17.	    <artifactId>mpsi-dependencies</artifactId>  
18.	    <version>1.0.0.SNAPSHOT</version>  
19.	    <packaging>pom</packaging>  
20.	    <modelVersion>4.0.0</modelVersion>  
21.	    <name>${project.artifactId}</name>  
22.	    <!-- shopin基础服务(主数据,价格,库存,盘点)中需要引入的依赖 -->  
23.	    <description>The parent project of mpsi</description>  
24.	  
25.	    <!--开始时间-->  
26.	    <inceptionYear>2018</inceptionYear>  
27.	  
28.	    <organization>  
29.	        <name>Shopin</name>  
30.	        <url>http://www.shopin.net</url>  
31.	    </organization>  
32.	  
33.	    <properties>  
34.	        <junit.version>4.12</junit.version>  
35.	        <mybatis.spring.boot.starter.version>1.2.2</mybatis.spring.boot.starter.version>  
36.	        <spring.boot.starter.dubbo.version>1.0.0</spring.boot.starter.dubbo.version>  
37.	        <dubbo.version>2.5.7</dubbo.version>  
38.	        <zookeeper.version>3.4.10</zookeeper.version>  
39.	        <mysql.connector.java.version>5.1.41</mysql.connector.java.version>
40.	        <lombok.version>1.16.18</lombok.version>  
41.	    </properties>  
42.	    <dependencyManagement>  
43.	        <dependencies>  
44.	            <!--引入mybatis与Springboot整合[持久化层引用]-->  
45.	            <dependency>  
46.	                <groupId>org.mybatis.spring.boot</groupId>  
47.	                <artifactId>mybatis-spring-boot-starter</artifactId>  
48.	                <version>${mybatis.spring.boot.starter.version}</version>  
49.	            </dependency>  
50.	            <!--junit测试-->  
51.	            <dependency>  
52.	                <groupId>junit</groupId>  
53.	                <artifactId>junit</artifactId>  
54.	                <version>${junit.version}</version>  
55.	                <scope>test</scope>  
56.	            </dependency>  
57.	  
58.	            <!--引入dubbo-->  
59.	            <dependency>  
60.	                <groupId>com.alibaba</groupId>  
61.	                <artifactId>dubbo</artifactId>  
62.	                <version>${dubbo.version}</version>  
63.	                <!-- 移除 dubbo中内嵌 Spring -->  
64.	                <exclusions>  
65.	                    <exclusion>  
66.	                        <groupId>org.springframework</groupId>  
67.	                        <artifactId>spring-context</artifactId>  
68.	                    </exclusion>  
69.	                    <exclusion>  
70.	                        <groupId>org.springframework</groupId>  
71.	                        <artifactId>spring-beans</artifactId>  
72.	                    </exclusion>  
73.	                    <exclusion>  
74.	                        <groupId>org.springframework</groupId>  
75.	                        <artifactId>spring-web</artifactId>  
76.	                    </exclusion>  
77.	                </exclusions>  
78.	            </dependency>  
79.	            <!--引入zookeeper-->  
80.	            <dependency>  
81.	                <groupId>org.apache.zookeeper</groupId>  
82.	                <artifactId>zookeeper</artifactId>  
83.	                <version>${zookeeper.version}</version>  
84.	                <type>pom</type>  
85.	            </dependency>  
86.	            <!--springboot整合Dubbo-->  
87.	            <dependency>  
88.	                <groupId>io.dubbo.springboot</groupId>  
89.	                <artifactId>spring-boot-starter-dubbo</artifactId>  
90.	                <version>${spring.boot.starter.dubbo.version}</version>  
91.	                <exclusions>  
92.	                    <exclusion>  
93.	                        <groupId>com.alibaba</groupId>  
94.	                        <artifactId>dubbo</artifactId>  
95.	                    </exclusion>  
96.	                    <exclusion>  
97.	                        <groupId>org.springframework.boot</groupId>  
98.	                        <artifactId>spring-boot-starter</artifactId>  
99.	                    </exclusion>  
100.	                </exclusions>  
101.	            </dependency>  
102.	            <!--引入Mysql-->  
103.	            <dependency>  
104.	                <groupId>mysql</groupId>  
105.	                <artifactId>mysql-connector-java</artifactId>  
106.	                <version>${mysql.connector.java.version}</version>  
107.	                <scope>runtime</scope>  
108.	            </dependency>  
109.	            <!--引入junit测试类-->  
110.	            <dependency>  
111.	                <groupId>junit</groupId>  
112.	                <artifactId>junit</artifactId>  
113.	                <version>${junit.version}</version>  
114.	            </dependency>  
115.	  
116.	            <!--引入lombok-->  
117.	            <dependency>  
118.	                <groupId>org.projectlombok</groupId>  
119.	                <artifactId>lombok</artifactId>  
120.	                <version>${lombok.version}</version>  
121.	                <scope>provided</scope>  
122.	            </dependency>  
123.	  
124.	        </dependencies>  
125.	    </dependencyManagement>  
126.	  
127.	    <!--私服地址配置-->  
128.	    <profiles>  
129.	        <profile>  
130.	            <id>ShopinProduceNexus</id>  
131.	            <activation>  
132.	                <activeByDefault>true</activeByDefault>  
133.	            </activation>  
134.	            <properties>  
135.	                <release.url>http://172.16.103.19:1081/nexus/content/repositories/releases/</release.url>  
136.	                <snapshot.url>http://172.16.103.19:1081/nexus/content/repositories/snapshots/</snapshot.url>  
137.	            </properties>  
138.	        </profile>  
139.	        <profile>  
140.	            <id>AliyunNexus</id>  
141.	            <properties>  
142.	                <release.url>http://172.16.103.19:1081/nexus/content/repositories/releases/</release.url>  
143.	                <snapshot.url>http://172.16.103.19:1081/nexus/content/repositories/snapshots/</snapshot.url>  
144.	            </properties>  
145.	        </profile>  
146.	    </profiles>  
147.	    <!-- 部署构件配置 begin -->  
148.	    <distributionManagement>  
149.	        <!--  
150.	            <server> <id>snapshots</id> <username>admin</username> <password>admin123</password>  
151.	            </server> <server> <id>releases</id> <username>admin</username> <password>admin123</password>  
152.	            </server>  
153.	        -->  
154.	        <repository>  
155.	            <id>releases</id><!-- 必须与setting.xml <server>id</server>认证信息一致 -->  
156.	            <name>releases</name>  
157.	            <url>${release.url}</url>  
158.	        </repository>  
159.	        <snapshotRepository>  
160.	            <id>snapshots</id>  
161.	            <name>Snapshots</name>  
162.	            <url>${snapshot.url}</url>  
163.	        </snapshotRepository>  
164.	    </distributionManagement>  
165.	    <!-- 部署构件配置 end -->  
166.	</project>  

```

##### 1.2.1.2 mpsi-parent
###### 1.2.1.2.1 作用
```
  mpsi-parent的作用也有2方面;
【1】在于控制服务组件的版本，JDK版本，maven编译版本,编码格式等等;
【2】方便各个子模块的版本控制的同时,能够实现统一deploy至私服，方便部署.

```
###### 1.2.1.2.2 Maven依赖
```
  1.	<?xml version="1.0" encoding="UTF-8"?>  
2.	<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
3.	         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
4.	    <modelVersion>4.0.0</modelVersion>  
5.	    <parent>  
6.	        <groupId>net.shopin</groupId>  
7.	        <artifactId>mpsi-dependencies</artifactId>  
8.	        <version>1.0.0.SNAPSHOT</version>  
9.	    </parent>  
10.	    <!--各个子模块-->
11.	    <modules>  
12.	        <module>inventory-query-service</module>  
13.	        <module>inventory-query-persistence</module>  
14.	        <module>inventory-update-persistence</module>  
15.	        <module>inventory-update-service</module>  
16.	        <module>materiel-query-persistence</module>  
17.	        <module>materiel-query-service</module>  
18.	        <module>materiel-update-persistence</module>  
19.	        <module>materiel-update-service</module>  
20.	        <module>mpsi-common-bean</module>  
21.	        <module>price-query-persistence</module>  
22.	        <module>price-query-service</module>  
23.	        <module>price-update-persistence</module>  
24.	        <module>price-update-service</module>  
25.	        <module>stock-query-persistence</module>  
26.	        <module>stock-query-service</module>  
27.	        <module>stock-update-persistence</module>  
28.	        <module>stock-update-service</module>  
29.	    </modules>  
30.	  
31.	    <artifactId>mpsi-parent</artifactId>  
32.	    <!--mpsi版本控制所有module-->  
33.	    <version>1.0.0.SNAPSHOT</version>  
34.	    <packaging>pom</packaging>  
35.	    <name>mpsi-parent</name>  
36.	  
37.	    <properties>  
38.	        <!-- 文件拷贝时的编码 -->  
39.	        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>  
40.	        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>  
41.	        <!-- 编译时的编码 -->  
42.	        <maven.compiler.encoding>UTF-8</maven.compiler.encoding>  
43.	        <!-- Java版本 -->  
44.	        <java.version>1.8</java.version>  
45.	        <!--组件版本控制-->  
46.	        <mpsi.backstage.section.version>1.0.0.SNAPSHOT</mpsi.backstage.section.version>  
47.	    </properties>  
48.	  
49.	    <dependencyManagement> 
50.	 <!--将其余组件在root pom中引入,其余子模块可以在自己的pom中直接引入其它子模块-->
51.	        <dependencies>  
52.	            <!--引入实体类-->  
53.	            <dependency>  
54.	                <groupId>net.shopin</groupId>  
55.	                <artifactId>mpsi-common-bean</artifactId>  
56.	                <version>${mpsi.backstage.section.version}</version>  
57.	            </dependency>  
58.	            <!--引入盘点查询接口服务-->  
59.	            <dependency>  
60.	                <groupId>net.shopin</groupId>  
61.	                <artifactId>inventory-query-service</artifactId>  
62.	                <version>${mpsi.backstage.section.version}</version>  
63.	            </dependency>  
64.	            <!--引入盘点查询持久化层-->  
65.	            <dependency>  
66.	                <groupId>net.shopin</groupId>  
67.	                <artifactId>inventory-query-persistence</artifactId>  
68.	                <version>${mpsi.backstage.section.version}</version>  
69.	            </dependency>  
70.	            <!--引入盘点更新接口服务-->  
71.	            <dependency>  
72.	                <groupId>net.shopin</groupId>  
73.	                <artifactId>inventory-update-service</artifactId>  
74.	                <version>${mpsi.backstage.section.version}</version>  
75.	            </dependency>  
76.	            <!--引入盘点更新持久化层-->  
77.	            <dependency>  
78.	                <groupId>net.shopin</groupId>  
79.	                <artifactId>inventory-update-persistence</artifactId>  
80.	                <version>${mpsi.backstage.section.version}</version>  
81.	            </dependency>  
82.	            <!--引入主数据查询服务-->  
83.	            <dependency>  
84.	                <groupId>net.shopin</groupId>  
85.	                <artifactId>materiel-query-service</artifactId>  
86.	                <version>${mpsi.backstage.section.version}</version>  
87.	            </dependency>  
88.	            <!--引入主数据查询持久化层-->  
89.	            <dependency>  
90.	                <groupId>net.shopin</groupId>  
91.	                <artifactId>materiel-query-persistence</artifactId>  
92.	                <version>${mpsi.backstage.section.version}</version>  
93.	            </dependency>  
94.	            <!--引入主数据更新服务-->  
95.	            <dependency>  
96.	                <groupId>net.shopin</groupId>  
97.	                <artifactId>materiel-update-service</artifactId>  
98.	                <version>${mpsi.backstage.section.version}</version>  
99.	            </dependency>  
100.	            <!--引入主数据更新持久化层-->  
101.	            <dependency>  
102.	                <groupId>net.shopin</groupId>  
103.	                <artifactId>materiel-update-persistence</artifactId>  
104.	                <version>${mpsi.backstage.section.version}</version>  
105.	            </dependency>  
106.	  
107.	            <!--引入价格查询服务-->  
108.	            <dependency>  
109.	                <groupId>net.shopin</groupId>  
110.	                <artifactId>price-query-service</artifactId>  
111.	                <version>${mpsi.backstage.section.version}</version>  
112.	            </dependency>  
113.	  
114.	            <!--引入价格查询持久化层-->  
115.	            <dependency>  
116.	                <groupId>net.shopin</groupId>  
117.	                <artifactId>price-query-persistence</artifactId>  
118.	                <version>${mpsi.backstage.section.version}</version>  
119.	            </dependency>  
120.	  
121.	            <!--引入价格更新服务-->  
122.	            <dependency>  
123.	                <groupId>net.shopin</groupId>  
124.	                <artifactId>price-update-service</artifactId>  
125.	                <version>${mpsi.backstage.section.version}</version>  
126.	            </dependency>  
127.	            <!--引入价格更新持久化层-->  
128.	            <dependency>  
129.	                <groupId>net.shopin</groupId>  
130.	                <artifactId>price-update-persistence</artifactId>  
131.	                <version>${mpsi.backstage.section.version}</version>  
132.	            </dependency>  
133.	  
134.	            <!--引入库存查询服务-->  
135.	            <dependency>  
136.	                <groupId>net.shopin</groupId>  
137.	                <artifactId>stock-query-service</artifactId>  
138.	                <version>${mpsi.backstage.section.version}</version>  
139.	            </dependency>  
140.	  
141.	            <!--引入库存查询持久化层-->  
142.	            <dependency>  
143.	                <groupId>net.shopin</groupId>  
144.	                <artifactId>stock-query-persistence</artifactId>  
145.	                <version>${mpsi.backstage.section.version}</version>  
146.	            </dependency>  
147.	  
148.	            <!--引入库存更新服务-->  
149.	            <dependency>  
150.	                <groupId>net.shopin</groupId>  
151.	                <artifactId>stock-update-service</artifactId>  
152.	                <version>${mpsi.backstage.section.version}</version>  
153.	            </dependency>  
154.	  
155.	            <!--引入库存更新持久化层-->  
156.	            <dependency>  
157.	                <groupId>net.shopin</groupId>  
158.	                <artifactId>stock-update-persistence</artifactId>  
159.	                <version>${mpsi.backstage.section.version}</version>  
160.	            </dependency>  
161.	        </dependencies>  
162.	    </dependencyManagement>  
163.	</project>  

```
##### 1.2.1.3 项目组成结构

<div align=center><img src="https://github.com/bjshopin/Shopin/blob/master/%E6%8A%80%E6%9C%AF%E5%BC%80%E5%8F%91/%E4%B8%AD%E5%8F%B0SOA%E9%A1%B9%E7%9B%AE%E9%83%A8%E7%BD%B2%E8%A7%84%E8%8C%83/img/3.jpg"/>

 - <font color="red">注意</font>
```
注意: mpsi-[module]-service-impl不纳入mpsi-parent的聚合项目中,每一个服务实现都是单独的war项目 ,
但是它需要依赖于mpsi-parent，原因在于mpsi-parent继承与mpsi-dependencies,
这样就可以将版本依赖和控制集成到项目中.
```
#### 1.2.2 SpringBoot集成
##### 1.2.2.1 SpringBoot集成RedisTemplate
###### 1.2.2.1.1 Maven依赖
```
	<dependency>  
	       <groupId>org.springframework.boot</groupId>  
	       <artifactId>spring-boot-starter-data-redis</artifactId>  
	       <version>1.5.8.RELEASE</version>  
	</dependency>  
```
###### 1.2.2.1.2 配置信息
 - 在application.properties中配置:
```
 spring.redis.cluster.nodes=192.168.205.167:10001,192.168.205.167:10002,192.168.205.167:10003 
```
###### 1.2.2.1.3 文件描述
 - 自定义RedisTemplate类
```
在spring-data-redis中,RedisTemplate的基础上支持更多方法的复写:(如果方法不满足实际开发需求,请及时告知开发者使其完善功能)
```
代码地址: [JxRedisTemplate](https://paste.ubuntu.com/p/dPRhTB7cjn/)
###### 1.2.2.1.4 实例Demo
[SpringBoot整合Redis](https://github.com/553899811/NewBie-Plan/tree/master/SpringBoot/springboot-redis)

##### 1.2.2.2 SpringBoot集成Schedule定时任务
###### 1.2.2.2.1 串行执行
```
  SpringBoot中定时Job 使用@Schedule 注解启动Job方法,默认为串行依次执行Job任务,
  也就是说无论多少个Task,都是一个线程串行执行;
```
```
  	串行Job添加类注解  
	@Component  
	@EnableScheduling  
	方法注解  
	@Scheduled(fixedRate = 3 * 1000)  
	或者 
	@Scheduled(cron = 表达式) 

```
###### 1.2.2.2.2 并行执行
```
 SpringBoot中Job支持并行执行(多个任务同时执行),需手动配置
```
```
 	并行Job添加类注解  
	@Component  
	@EnableScheduling  
	@EnableAsync(mode = AdviceMode.PROXY, proxyTargetClass = false,  
	        order = Ordered.HIGHEST_PRECEDENCE  
	)  
	方法注解  
	@Scheduled(fixedRate = 3 * 1000)  
	@Async  
	或者  
	@Scheduled(cron = 表达式)   
	@Async 
```
###### 1.2.2.2.3 实例Demo
[SpringBoot整合Schedule定时任务](https://github.com/553899811/NewBie-Plan/tree/master/SpringBoot/springboot-schedule)

##### 1.2.2.3 SpringBoot集成Email
###### 1.2.2.3.1 Maven依赖
###### 1.2.2.3.2 配置信息
###### 1.2.2.3.3 文件描述
###### 1.2.2.3.4 实例Demo

##### 1.2.2.4 SpringBoot集成Dubbo
###### 1.2.2.4.1 Maven依赖
  - 服务生产者
```
 版本配置:
 <spring.boot.starter.dubbo.version>1.0.0</spring.boot.starter.dubbo.version 
 <dubbo.version>2.5.7</dubbo.version>  
 <zookeeper.version>3.4.10</zookeeper.version>  
 JAR依赖:
 
```
    
