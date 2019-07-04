FROM openjdk:8-jre
MAINTAINER LiLi <772654204@qq.com>

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

ADD wait-for-it.sh /wait-for-it.sh
RUN bash -c 'chmod 777 /wait-for-it.sh'

ADD forfun-member.jar /app/
CMD ["java", "-Xmx256m", "-Xms256m", "-Xmn200","-Duser.timezone=GMT+8", "-jar", "/app/forfun-member.jar"]

EXPOSE 8099