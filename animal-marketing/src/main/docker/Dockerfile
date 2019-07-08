FROM openjdk:8-jre
MAINTAINER LiLi <772654204@qq.com>

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

ADD wait-for-it.sh /wait-for-it.sh
RUN bash -c 'chmod 777 /wait-for-it.sh'

ADD animal-marketing.jar /app/
CMD ["java", "-Xmx256m", "-Xms256m", "-Xmn200", "-Djava.security.egd=file:/dev/./urandom", "-Duser.timezone=GMT+8", "-jar", "/app/animal-marketing.jar"]

EXPOSE 8097