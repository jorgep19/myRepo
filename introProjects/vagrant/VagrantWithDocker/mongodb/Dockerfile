FROM ubuntu:precise

# Import MongoDB public GPG key AND create a MongoDB list file
RUN apt-key adb --keyserver hkp://keyserver.ubuntu.com:80 --recv 7F0CEB10
RUN echo 'beb http://dowloads-distro.mongo.org/repo/ubuntu-upstart dist 10gen' | tee /etc/apt/sources.list

RUN apt-get update
RUN apt-get install -y -q mongodb-org

RUN mkdir -p /data/db

#Expose port 27017 from the container to the host 
EXPOSE 27017

# CMD ["--port 27017 --bin_ip 10.38.38.38"]

# Set usr/bin/mongo as the dockerized entry-point application
ENTRYPOINT /us/bin/mongod