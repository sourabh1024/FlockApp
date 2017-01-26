# FlockApp
A Flock Wiki app. FlockWiki is a wiki collaboration software that solves all these problems yet, unlike many traditional content management systems, remains simple enough for non-technical employees to use.

Instructions to setup Flockwiki :

Set up elastic Search and MySql on the system you want to host the app.

Update All necessary information in the config.properties file. (Path of config.properties : src/main/resources/config.properties)

In the ElasticSearch being setup :
 Put the Mapping in ElasticSearchMapping.txt file

In you MySql database:
 Create a table as described in MySqlSchema file.

How to run the app:

    Download all required maven dependencies and run the project using jetty server.
    And expose the server if running on localhost using ngrok

Once the Server is up and running Configure these in Flock App store:

serveraddress - the address of the system on which the code is running

1. Event Listener URL : serveraddress/events
2. Configuration URL : serveraddress/thanks
App Launcher Button Configurations
3. ToolTip Text : FlockWiki
4. Select action for App launcher :open Widget
5. Type Of widget in Desktop : Modal
6. Action url : serveraddress/widget

Publish and enjoy :)






