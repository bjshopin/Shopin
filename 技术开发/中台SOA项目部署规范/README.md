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
<div align=center>![](https://github.com/bjshopin/Shopin/blob/master/%E6%8A%80%E6%9C%AF%E5%BC%80%E5%8F%91/%E4%B8%AD%E5%8F%B0SOA%E9%A1%B9%E7%9B%AE%E9%83%A8%E7%BD%B2%E8%A7%84%E8%8C%83/img/2.png)
</div>
 - 后台组件图(聚合项目)
 <div align=center>![](https://github.com/bjshopin/Shopin/blob/master/%E6%8A%80%E6%9C%AF%E5%BC%80%E5%8F%91/%E4%B8%AD%E5%8F%B0SOA%E9%A1%B9%E7%9B%AE%E9%83%A8%E7%BD%B2%E8%A7%84%E8%8C%83/img/1.png)
 </div>

