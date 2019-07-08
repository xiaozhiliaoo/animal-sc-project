FROM redis:alpine
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
COPY ./config/redis.conf /usr/local/etc/redis/redis.conf
CMD [ "redis-server", "/usr/local/etc/redis/redis.conf" ]