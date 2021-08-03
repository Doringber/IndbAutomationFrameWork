FROM jenkins/jenkins:2.289.1-jdk11
USER root
RUN curl -sSL https://get.docker.com/ | sh
USER jenkins