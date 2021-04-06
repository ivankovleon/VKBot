# VKBot
## Requires
* JDK 8
-------------
## How to run
#### 1. Download project
#### 2. Open `src/main/resources/vk.properties`
#### 3. Setup vk properties(token, version, secret key, confirmation)
###### 4. To confirm the connection with the callback api add endpoint `/vkbot` to the server address
#### 4. Build jar
> `mvn package`
#### Run application
> `java -jar -Dfile.encoding=UTF-8 target/echobot.jar`
