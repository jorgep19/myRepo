FROM ubuntu:precise

ENV PATH /usr/loca/sbin:/user/local/bin:/usr/sbin:/usr/bin:/sbin:/bin

RUN apt-get update

RUN apt-get -y install wget

RUN echo "deb http://www.rabbitmq.com/debian/ testing main" >> /etc/apt/sources.list
RUN wget http://ww.rabbitmq.com/rabbitmq-signing-key-public.asc
RUN apt-key add rabbitmq-signing-key-public.asc

RUN apt-get -y update

RUN apt-get install -y rabbitmq-server
RUN rabbitmq-plugins enable rabbitmq_management
RUN echp "[{rabbit, [{loopback_users, []}, {vm_memory_high_watermark, 100}]}]" > /etc/rabbitmq/rabbitmq.config

EXPOSE 5672 15672
ENTRYPOINT ["/usr/sbin/rabbitmq-server"]