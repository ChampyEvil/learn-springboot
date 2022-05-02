FROM jenkinsci/jenkins:lts
# Running as root to have an easy support for Docker
USER root
# A default admin user
ENV ADMIN_USER=admin \
    ADMIN_PASSWORD=password
# Jenkins init scripts
COPY security.groovy /usr/share/jenkins/ref/init.groovy.d/
# Install plugins at Docker image build time
COPY plugins.txt /usr/share/jenkins/plugins.txt
RUN /usr/local/bin/install-plugins.sh $(cat /usr/share/jenkins/plugins.txt) && \
    mkdir -p /usr/share/jenkins/ref/ && \
    echo lts > /usr/share/jenkins/ref/jenkins.install.UpgradeWizard.state && \
    echo lts > /usr/share/jenkins/ref/jenkins.install.InstallUtil.lastExecVersion