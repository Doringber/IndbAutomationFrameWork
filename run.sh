FROM websphere-liberty:webProfile7
ARG SSL_KEYSTORE_PASSWORD
USER root
RUN apt-get update &&
apt-get install -y
curl
USER 1001