FROM openjdk:8-jre
MAINTAINER LiLi <772654204@qq.com>

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

ADD animal-admin.jar /app/
CMD ["java", "-Xmx256m", "-Xms256m", "-Xmn200", "-Duser.timezone=GMT+8", "-jar", "/app/animal-admin.jar"]

EXPOSE 9090