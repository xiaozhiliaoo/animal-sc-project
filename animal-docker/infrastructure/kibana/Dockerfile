FROM kibana:5

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

COPY wait-for-it.sh /tmp/wait-for-it.sh
RUN chmod +x /tmp/wait-for-it.sh