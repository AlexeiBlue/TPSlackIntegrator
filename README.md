# TP Slack Integrator
An integrator between Target Process and Slack that controls the flow of messages to reduce noise.  Uses a simple cache by using the text that is sent to slack as the key so that repeat messages aren't constantly sent.

The following project is a simple spring boot application that starts up on port 9100.  This can be reconfigured in the application.prooperties file.

Please see the following wiki for setup:

# Welcome to the TP Slack Integrator wiki!

## Project Layout
![Project Layout](http://content.screencast.com/users/AlexeiBlue/folders/Jing/media/76c3bc56-d18a-4c92-8ad0-e0741de4d93e/00000198.png)

## Starting Application
![Spring boot startup](http://content.screencast.com/users/AlexeiBlue/folders/Jing/media/e4597142-929a-4673-a336-545ef4e5e0f8/00000199.png)

Remember to open the port (9100 default) to your firewall to allow traffic through.

## Target Process Template Example
![Target Process Template](http://content.screencast.com/users/AlexeiBlue/folders/Jing/media/9742cf89-819e-40eb-a5e1-e0d29fcdea93/00000201.png)

## Slack Messages
### Before
![Before - TP Slack Integration](http://content.screencast.com/users/AlexeiBlue/folders/Jing/media/d406d3d8-2822-49e6-acdd-1b56d23bb33c/2016-01-29_1442.png)
### After
![After - TP Slack Integration](http://content.screencast.com/users/AlexeiBlue/folders/Jing/media/b11d0248-f777-44f8-8b90-ed5b22404a22/2016-01-29_1449.png)
