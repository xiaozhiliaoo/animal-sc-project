FROM elasticsearch:5

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

ENV ES_JAVA_OPTS="-Des.path.conf=/etc/elasticsearch"

CMD ["-E", "network.host=0.0.0.0", "-E", "discovery.zen.minimum_master_nodes=1"]