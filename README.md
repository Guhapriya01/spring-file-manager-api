# Spring File Manager

## Overview

Spring File Manager is a RESTful API developed using Spring Boot for managing file uploads and retrievals with Firebase storage. This application allows users to upload files, retrieve them using unique IDs, and ensures that file sizes are managed effectively.

## Features

- Upload files to Firebase Storage
- Retrieve files by unique ID
- Handle file size limits (max 10MB)
- Exception handling for file-related operations

## Getting Started

### Prerequisites

- JDK 11 or later
- Maven
- Firebase account with a configured project
- MySQL database

### Configuration

1. Clone the repository:

   ```bash
   git clone https://github.com/Guhapriya01/spring-file-manager-api.git
   cd spring-file-manager-api
   ```

2. Add your Firebase service account key file (`serviceAccountKey.json`) to the `src/main/resources` directory.

3. Update the `application.properties` file with your MySQL database credentials:

   ```properties
   spring.datasource.url=jdbc:mysql://<your-db-url>:<port>/<your-db-name>?sslmode=require
   spring.datasource.username=<your-username>
   spring.datasource.password=<your-password>
   ```

### Running the Application

You can run the application using your IDE (like Spring Tool Suite) or by executing the following command:

```bash
mvn spring-boot:run
```

## API Endpoints

#### 1. Upload File
- **Endpoint:** `POST /api/files/upload`
- **Description:** Upload a file to Firebase Storage.
- **Request:**
  - **Headers:** `Content-Type: multipart/form-data`
  - **Body:** Form-data containing the file to upload.  
- **Response:**
  - **Success (200 OK):**
    ```json
    {
      "message": "File uploaded successfully with id <uniqueId>"
    }
    ```
  - **Error (400 Bad Request):**
    ```json
    {
      "error": "File upload failed: <error_message>"
    }
    ```

#### 2. Retrieve File
- **Endpoint:** `GET /api/files/retrieve/{id}`
- **Description:** Retrieve a previously uploaded file using its unique ID.
- **Path Variable:** 
  - `id` - The unique ID of the file to retrieve.
- **Response:**
  - **Success (200 OK):** Returns the file content for download with the appropriate headers.
  - **Error (404 Not Found):**
    ```json
    {
      "error": "File retrieval failed: No file found with the given ID: <id>"
    }
    ```

## Exception Handling

The application handles exceptions such as file size limits and file not found scenarios gracefully, returning appropriate HTTP status codes and messages.

## Acknowledgments

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Firebase](https://firebase.google.com/)
- [MySQL](https://www.mysql.com/)
