









# demo学习笔记：

## springboot

用到的注解：

- @Controller、@Service：添加组件到IOC容器中
- @Autowired  按照类型进行依赖注入
- @RestController = @ResponseBody + @Controller 该类中的方法返回的对象都保存在请求体中(json的方式)
- @GetMapping("") : 映射http  get请求 ，value属性为映射的请求路径
- @RequestParam("xxx") 获取xxx请求参数

目录结构：

- dao：持久层。负责在数据库中进行的操作

- service：服务层。处理业务逻辑(调用dao层的方法获取数据，处理业务逻辑)

- controller：处理请求映射。将页面返回的数据(如果存在)传递给service层进行处理。并进行页面跳转等操作

- entity：实体类。与数据库中的一个表项相对应(如果有必要)

## mybatis

1. 配置数据源：

```yml
spring:
  datasource:
    url: jdbc:mysql://192.168.56.10:3306/gulimall_pms?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai
    username: root
    password: root
    driver-class-name: com.mysql.jdbc.Driver
    //  寻找mapper文件的地方 /**/ 表示0~多个目录 
mybatis:
  mapper-locations: classpath:/mapper/**/*.xml
```

2. @Mapper 编译后会生成标识了注解的实现类(只用写接口) mapper.xml相当于是实现类

   @MapperScan("全包名") ： 为包内的所有类加上@Mapper注解

3. 以xml的方式写映射文件

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
   <!--namespace : 该映射文件对应的接口 -->
   <mapper namespace="com.lyjtest.firstdemo.dao.CategoryDao">
    
       <resultMap type="com.lyjtest.firstdemo.entity.CategoryEntity" id="categoryMap">
           <result property="catId" column="cat_id"/>
           <result property="name" column="name"/>
           <result property="parentCid" column="parent_cid"/>
           <result property="catLevel" column="cat_level"/>
       </resultMap>
   
   <!-- id:实现的方法名 -->
       <select id="queryPage" resultMap="categoryMap">
           select cat_id ,`name`, parent_cid, cat_level
           from `pms_category` limit #{startIndex},#{pageSize}
       </select>
   
   </mapper>
   
   mapper文件对应的接口
   public interface CategoryDao {
       List<CategoryEntity> queryPage(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);
   }
   ```

   resultmap : 将查询到的数据映射为一个数据类型(type里面的全类名)  

   ​						property：entity中的属性 column：数据库中的列名

   \<select>标签：在标签内写select语句，查询到的结果封装为resultMap所映射的对象 

   #{param}  : @Param 中引入的参数 

## 提交本地项目到github

1. github创建repository
2. git clone 创建远程分支
3. git add 、git commit 创建一个提交(main分支指向最新提交)
4. git push origin main : 上传到远程仓库 origin：远程仓库 、main : 本地的main分支上传到远端的main分支
5. o/main 上次下载远程仓库时，main分支所在的位置







