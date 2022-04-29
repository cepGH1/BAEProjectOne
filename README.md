# BAEProjectOne
author Clare Pritchard

The website for this app can be found in the static folder of the project
baeprojectone/src/main/resources/static/index.html

The Jira board for this project is at the following address
https://team-1632237778310.atlassian.net/jira/software/projects/BAEP/boards/5


A mysql database needs to be provided for the production jar to work
The jar will look for,
localhost:3306/todolist


Changing the applicationproperties file to
spring.profiles.active=test
will run this API with a non-persistant H2 database

