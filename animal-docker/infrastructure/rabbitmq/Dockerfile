FROM rabbitmq:3-management
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
COPY ./config/rabbitmq_delayed_message_exchange-0.0.1.ez /usr/lib/rabbitmq/lib/rabbitmq_server-3.6.6/plugins