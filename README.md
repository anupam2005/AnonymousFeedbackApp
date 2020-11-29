# AnonymousFeedbackApp

Have you ever faced a situation when you need
to take a quick _anonymous survey_ in your team?

What if you can get rid of distributing post-it notes and get a
handy web-app which can gather the survey data for you.

This application precisely solve the same problem and its a hassle-free
way to gather anonymous survey data from your group.

All you need to do is just get the app running on your machine & share
the survey URL to your colleagues.

**Pre-Requisites:**

1) This application stores the data in ActiveMQ which is free.
Just unzip and start ActiveMQ on your machine before starting this App.
(https://activemq.apache.org/components/classic/download/)

2) Run this application jar in your local machine.

3) Get the IP of your machine. (By command ipconfig or ifconfig based on your OS)

4) Share the URL to with your LAN buddies at http://<YOUR_IP>:8081/feedbackApp/survey
   and wait till they finish.

5) Once the time is up get all the surveys in your local machine
   by hitting: http://localhost:8081/rest/reader/getFeedbacks

**Important URLs:**

For taking the survey: http://localhost:8081/feedbackApp/survey

For adding feedback: http://localhost:8081/rest/producer/feedback

For getting all surveys: http://localhost:8081/rest/reader/getFeedbacks
