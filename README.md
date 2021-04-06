# VKBot
## Requires
* JDK 8
-------------
## How to run
#### Download project
#### Open `src/main/resources/vk.properties`
#### Setup vk properties(token, version, secret key, confirmation)
###### To confirm the connection with the callback api add endpoint `/vkbot` to the server address
#### Build jar
`mvn package`
#### Run application
`java -jar -Dfile.encoding=UTF-8 target/echobot.jar`
