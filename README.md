# keycloak_user_API

This repository helps to create, update, delete users in keycloak along with adding and attaching realm roles using Spring boot

## Requirements

For development, you will need JDK and postman and any IDE in your environment.

## Install

#### Step 1: Clone the repository

```bash
git clone https://github.com/AkashP27/keycloak_user_API.git
```

#### Step 2: Create KeyCloak Server

- Visit [KeyCloak](https://www.keycloak.org/) and install
- To start the server, open terminal in the keycloak directory and use the following command

```bash
bin/kc.bat start-dev --http-port 8180
```

- Open [http://localhost:8180](http://localhost:8180)
- Create keycloak admin account and create a new realm
- Inside the new realm create new client and get its credentials and Valid redirect URIs is `http://localhost:8080/`

#### Step 3: Provide the credentials

- open `src/main/resources/application.properties`
- Change the credentials as per your keycloak account and client

#### Step 4: Build and run the app using maven

### You can test the API in postman

[Set postman environment from here](https://www.postman.com/akash-api/workspace/akash-public/environment/16112169-8686f9ff-90bd-4624-9292-e6dedb44f4bc?action=share&creator=16112169&active-environment=16112169-8686f9ff-90bd-4624-9292-e6dedb44f4bc)

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/16112169-00bbdf5c-1944-414d-b828-88df72adbb4f?action=collection%2Ffork&source=rip_markdown&collection-url=entityId%3D16112169-00bbdf5c-1944-414d-b828-88df72adbb4f%26entityType%3Dcollection%26workspaceId%3D9fe04cc0-53c6-4f02-842b-8fe10274477e#?env%5Bspring-boot-API%5D=W3sia2V5IjoiVVJMIiwidmFsdWUiOiJodHRwOi8vbG9jYWxob3N0OjgwODAiLCJlbmFibGVkIjp0cnVlLCJ0eXBlIjoiZGVmYXVsdCIsInNlc3Npb25WYWx1ZSI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MCIsInNlc3Npb25JbmRleCI6MH0seyJrZXkiOiJhY2Nlc3NfdG9rZW4iLCJ2YWx1ZSI6IiIsImVuYWJsZWQiOnRydWUsInR5cGUiOiJhbnkiLCJzZXNzaW9uVmFsdWUiOiJleUpoYkdjaU9pSlNVekkxTmlJc0luUjVjQ0lnT2lBaVNsZFVJaXdpYTJsa0lpQTZJQ0pvUkZONWNWbHJSVU4zZDBweWNXSTBTRkppVG14bmNIRndhWEZETkdFNWRYUldka1JSTm5SWmNtZGpJbjAuZXlKbGVIQWlPakUyT1RZek1UYzJOVElzSS4uLiIsInNlc3Npb25JbmRleCI6MX1d)
