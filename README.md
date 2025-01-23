# AdlasApp

### About the project

- [X] t1: output will be ``Running practice task: EisenstadtInnsbruckLinz``
- [X] t2: POST /exemption
- [X] t3: POST /exemption + Input Validation
- [X] t4: GET /exemption/{public_id}
- [X] t5: PUT /exemption/{public_id} + exemption-dto
- [X] t6: GET /exemption + pagination + mysql
- [ ] t7: PUT /deploy-all
- [X] t8: status
- [ ] t9: PUT /deploy/{public_id}
- [ ] t10: PUT /un-deploy/{public_id}
- [ ] t11: JWT
- [X] t12: Docs
- [X] t13: Tests
- [X] t14: Exception handling


### How to run (Setup)


1. **Prerequisites:**

    - Java 21 (sdkman)
    - Maven (sdkman)
    - Postman
    - curl
    - git


2. **Clone the repository:**

   ```bash
   git clone https://github.com/j-imsa/AdlasApp.git
   cd AdlasApp-master
   ```


3. **Build the project:**

   ```bash
   mvn clean install
   ```


4. **Run the app:**

   ```bash
   cd target
   java -jar AdlasApp-0.0.1.jar
   ```


### Requests, Responses




#### Postman

you can find the Postman exported collections and environment to import them!

- Collection:
  - [AdlasAppCollection.postman_collection.json](AdlasAppCollection.postman_collection.json)
- Environment:
  - [AdlasAppLocalEnv.postman_environment.json](AdlasAppLocalEnv.postman_environment.json)


### UI

- Swagger:
    - http://localhost:8088/adlasapp/docs-ui
    - http://localhost:8088/adlasapp/api-docs
    - ![Screenshot from 2025-01-23 13-51-17.png](Screenshot%20from%202025-01-23%2013-51-17.png)


- DB:
  - H2
      - Testing Profile 
      - Testing Repository Layer
      - http://localhost:8088/adlasapp/h2-console
  - MySQL
    - [docker-compose.yml](docker-compose.yml)


### License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

