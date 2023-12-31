# Travel Booking Application

## Description

The Travel Booking Application is a comprehensive platform built with Spring Boot and REST services. It enables users to search for and book flights, hotels, and rental cars seamlessly. The application integrates with a third-party service, Expedia, to provide real-time availability and pricing information for a smooth travel booking experience.


## Requirements
- Java 8 or later
- Maven
- H2 database (for simplicity in the provided example; production applications may use a different database)

## Setup
### Database Configuration
1. Create an H2 database for the application.
2. Update the database configuration in `src/main/resources/application.properties` with your database details:

    ```properties
    spring.datasource.url=jdbc:h2:mem:travel-booking
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    ```

### Running the Application
#### Using Maven
1. Open a terminal and navigate to the project root directory.
2. Run the following command to build the project:

    ```bash
    mvn clean install
    ```

3. Run the application:

    ```bash
    mvn spring-boot:run
    ```

4. The application will be accessible at [http://localhost:8080](http://localhost:8080).

#### Using IDE
1. Import the project into your favorite IDE (Eclipse, IntelliJ, etc.).
2. Run the `TravelBookingApplication` class as a Java application.

## API Endpoints

### Flights:
- Search Flights: GET /flights/search
- Book Flight: POST /flights/book
- Get All Flights: GET /flights/all
- Update Flight: PUT /flights/update/{id}
- Delete Flight: DELETE /flights/delete/{id}

### Hotels:
- Search Hotels: GET /hotels/search
- Book Hotel: POST /hotels/book 
- Get All Hotels: GET /hotels/all
- Update Hotel: PUT /hotels/update/{id}
- Delete Hotel: DELETE /hotels/delete/{id}

- ### Rental Cars:
- Search Rental Cars: GET /rental-cars/search
- Book Rental Car: POST /rental-cars/book
- Get All Rental Cars: GET /rental-cars/all
- Update Rental Car: PUT /rental-cars/update/{id}
- Delete Rental Car: DELETE /rental-cars/delete/{id}


## Example Requests
### Create Book:
```bash
curl -X GET http://localhost:8080/flights/search?origin=Doha&destination=Amsterdam
```

### Short feedback:

- Was it easy to complete the task using AI? 
It wasn't necessary easy as some information/code provided had to be modified and there was a bit of going back and forth to receive the desired answer.

- How long did task take you to complete? (Please be honest, we need it to gather anonymized statistics) 
It took me about 8 hours to complete it.

- Was the code ready to run after generation? What did you have to change to make it usable?
The code was not ready to run after generation. I had to adjust some portions of the code and change some of the tests.

- Which challenges did you face during completion of the task? 
The fact-checking of the answers, updating the tests generated by ChatGPT as some of them were not running and ensuring the code-coverage is sufficient.

- Which specific prompts you learned as a good practice to complete the task? 
I found that ChatGPT was responding better to the following prompts: "Please generate tests for this method/ endpoint" (sometimes I did give specifics towards what kind of tests I need ChatGPT to generate) and "Can you generate an entity/model/controller/service class" (where I gave extra information about what the class should have and how it should behave).