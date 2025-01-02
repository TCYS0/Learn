# Jdk

- [Java 8](https://www.oracle.com/java/technologies/downloads/#java8)

- 官网下载jdk包

- 上传到服务器，/app/nacos

- 到该目录下解压 

  ```
  tar -zxvf jdk-8u391-linux-x64.tar.gz -C /usr/local 解压到/usr/local/java
  ```

- 配置环境变量

  ```sh
  执行 vim /etc/profile
  ```

- 在末尾添加

  ```java
  export JAVA_HOME=/usr/local/java/jdk1.8.0_391
  export JRE_HOME=${JAVA_HOME}/jre
  export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib:$CLASSPATH
  export JAVA_PATH=${JAVA_HOME}/bin:${JRE_HOME}/bin
  export PATH=$PATH:${JAVA_PATH}
  ```

- 让配置文件生效

  ```sh
  source /etc/profile
  ```

- 检查安装情况

  ```
  Java -version
  ```

- 成功

  ![image-20231102200516859](count7%E8%BD%AF%E4%BB%B6%E9%83%A8%E7%BD%B2.assets/image-20231102200516859.png)

# Nacos

- [Nacos 快速开始](https://nacos.io/zh-cn/docs/quick-start.html)

- 官网下载应用包

- 上传到服务器，/app/nacos

- 到该目录下解压 

  ```
  tar -zxvf nacos-server-2.2.3.tar.gz -C /usr/local 解压到/usr/local
  ```

- 进入到/usr/local/nacos

- 进入nacos/conf,找到mysql-schema.sql文件执行创建表

- 修改Nacos服务的数据库连接 vim nacos/conf/application.properties

- ![image-20231102194152463](count7%E8%BD%AF%E4%BB%B6%E9%83%A8%E7%BD%B2.assets/image-20231102194152463.png)

- 启动nacos

- ```sh
  # 进去bin目录
  cd  /xxxx/xxxx/xxxx/nacos/bin
  
  # 执行单机版启动命令
  # ubuntu采用
  bash /xxx/xxx/xxx/bin/startup.sh -m standalone
  # linux的其他发行版采用
  sh  /xxx/xxx/xxx/bin/startup.sh -m standalone
  ```

- 访问nacos

  ```js
  # 启动后访问自己ip
  http://localhost:8848/nacos
  ```


```sh
 docker run -d --name nacos -p 8848:8848  -p 9848:9848 -p 9849:9849 --privileged=true -e JVM_XMS=256m -e JVM_XMX=256m -e MODE=standalone -v /mydata/nacos/logs/:/home/nacos/logs -v /mydata/nacos/conf/:/home/nacos/conf/ --restart=always nacos/nacos-server
```

