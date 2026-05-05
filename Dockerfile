FROM ubuntu:22.04

ENV DEBIAN_FRONTEND=noninteractive

# ── Dépendances système ───────────────────────────────────────────────────────
RUN apt-get update && apt-get install -y \
    curl \
    wget \
    gnupg \
    git \
    fontconfig \
    tini \
    openjdk-21-jre \
    && rm -rf /var/lib/apt/lists/*

RUN git --version

# ── Jenkins LTS ───────────────────────────────────────────────────────────────
RUN mkdir -p /etc/apt/keyrings \
    && wget -O /etc/apt/keyrings/jenkins-keyring.asc \
       https://pkg.jenkins.io/debian-stable/jenkins.io-2026.key \
    && echo "deb [signed-by=/etc/apt/keyrings/jenkins-keyring.asc] \
       https://pkg.jenkins.io/debian-stable binary/" \
       > /etc/apt/sources.list.d/jenkins.list \
    && apt-get update && apt-get install -y jenkins \
    && rm -rf /var/lib/apt/lists/*

# ── Apache Maven 3.9 ─────────────────────────────────────────────────────────
ARG MAVEN_VERSION=3.9.6
RUN curl -fsSL https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
    | tar -xzf - -C /opt/ \
    && ln -s /opt/apache-maven-${MAVEN_VERSION} /opt/maven

ENV MAVEN_HOME=/opt/maven
ENV PATH="${MAVEN_HOME}/bin:${PATH}"

RUN mvn --version

# ── Exposition des ports et lancement ────────────────────────────────────────
EXPOSE 8080 50000

USER jenkins
ENTRYPOINT ["/usr/bin/tini", "--", "/usr/bin/jenkins"]
