@echo off

REM Setting the API Key - username and password for authentication in JIRA 
set "$api-key=avikdeb@hotmail.com:Ayutasouri74"

REM Setting the JIRA API call URL with the JQL (Jira query)
set "$jql=https://avikpersonal.atlassian.net/rest/api/2/search?jql=project=ETE%%20AND%%20issuetype=Bug%%20AND%%20priority=Highest%%20AND%%20status%%20in%%20(%%22To%%20Do%%22%%2C%%22In%%20Progress%%22)%%20AND%%20labels%%20%%3D%%20Non-prod-incident%%20order%%20by%%20updated%%20DESC"


REM Deleting previous result, if any
if exist jira_jql.json del jira_jql.json

REM Getting the Jira query result in a JSON formatted file jira_jql.json
REM curl -D- -u "%$api-key%" -X GET -H "Content-Type: application/json" %$jql% > D:\javalab2\javalab\src\com\avikdeb\java\resources\jira_jql.json
curl -D- -u "%$api-key%" -X GET -H "Content-Type: application/json" %$jql% > C:\incident_home\jira_jql.json

REM To close the command prompt
exit