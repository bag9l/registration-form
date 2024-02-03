# Registration Form Application

This application is a simple registration form. It consists of a backend and a frontend component. Follow the instructions below to set up and run the application.

## Prerequisites

Before running the application, make sure you have the following prerequisites installed:

- [PostgreSQL](https://www.postgresql.org/) database
- [Maven](https://maven.apache.org/) build tool

## Database Setup

1. Create a PostgreSQL database called "liefersoftdb".
2. Use the user "liefersoft_owner" with the password "liefersoft".

## Building and Running

1. Open a terminal and navigate to the project directory.
2. Run the following command to build both the backend and frontend applications:

    ```bash
    mvn package
    ```

3. After the build is successful, you can run the application.
4. Both the backend and frontend will be running on http://localhost:8000. The backend automatically starts the frontend.

## Testing the Application

Visit the following link to test the application:

[http://localhost:8000/register](http://localhost:8000/register)

Feel free to explore and interact with the registration form.

Happy coding!
