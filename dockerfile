FROM openjdk:8-jdk

# Install Android SDK
RUN wget -q https://dl.google.com/android/repository/sdk-tools-linux-4333796.zip -O android-sdk.zip \
    && unzip -q android-sdk.zip -d /opt/android-sdk \
    && rm android-sdk.zip

# Set up environment variables
ENV ANDROID_HOME /opt/android-sdk
ENV PATH ${PATH}:${ANDROID_HOME}/tools/bin:${ANDROID_HOME}/platform-tools

# Accept Android SDK licenses
RUN yes | sdkmanager --licenses

# Add your project files
COPY . /app
WORKDIR /app
