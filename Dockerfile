# 基于哪个镜像
FROM openjdk:11

# 将本地文件夹挂载到当前容器
VOLUME /tmp

# 拷贝文件到容器，也可以直接写成ADD xxxxx.jar /app.jar
ADD /target/user-center-0.0.1-SNAPSHOT.jar /app.jar

# 声明需要暴露的端口
EXPOSE 8080

# 配置容器启动后执行的命令
ENTRYPOINT ["java","-jar","app.jar"]
