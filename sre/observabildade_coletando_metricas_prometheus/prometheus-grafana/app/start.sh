#!/bin/bash

java -jar -Xms256M -Xmx256M -XX:PermSize=128m -XX:MaxPermSize=128m -Dspring.profiles.active=prod target/forum.jar