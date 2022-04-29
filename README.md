# BAEProjectOne
author Clare Pritchard

The website for this app can be found in the static folder of the project<br>
baeprojectone/src/main/resources/static/index.html

The Jira board for this project is at the following address
https://team-1632237778310.atlassian.net/jira/software/projects/BAEP/boards/5


A mysql database needs to be provided for the production jar to work
The jar will look for,<br>
localhost:3306/todolist<br>
![image](https://user-images.githubusercontent.com/12085003/165970680-0787b563-5880-47e2-9a07-5f71632d6891.png)



<p>Changing the applicationproperties file to<br>
spring.profiles.active=test<br>
will run this API with a non-persistant H2 database</p>
<p>The web page allows a user to create, update, read and delete from a list of 'things to do'. The list of items (things to do) can be held temporarily in the test H2 database which will be wiped clean when the app is stopped or the list can be held in a mySQL schema called todolist that provides a persistance layer.<br>
  </p>
 <img src= "https://user-images.githubusercontent.com/12085003/165972436-6e4cb5e1-f321-4dd4-8453-d4943677e43d.png", height="300px" alt="missin image">


