#!/bin/bash
if [ ! -f ./rabbitmqadmin]; then
	wget http://10.38.38.38:15672/cli/rabbitmqadmin > /dev/null
	chmod +x rabbitmqadmin
fi