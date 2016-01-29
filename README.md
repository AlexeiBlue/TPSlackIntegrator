# TPSlackIntegrator
An integrater between Target Process and Slack that controls the flow of messages to reduce noise.  Allows messages through on state change depending on how the JSON template is setup.

The following project is a simple spring boot application that starts up on port 9100.  This can be reconfigured in /src/main/resources/application.prooperties.

In TP in settings, plugins you should see Webhooks.  Here you can configure slack webhooks to send message to channels on certain events.  To reduce the amount of noise to channels, especially for updates I have developed this application for caching the text from the JSON template that would be sent to slack.
To use the application ensure that it is host from a publicly reachable location, then in TP webhooks set the webhook URL as the location of this application on your server.  Finally add a "webhook" entry in the JSON template as the application will proxy the request forward if the text hasn't been cached in the last 30 minutes.

PLease note that this is a very basic application and as such isn't highly configureable but hopefully something that others will find useful.  Feel free to grab the code and have a play around.

Cheers,
Alexei Blue.
