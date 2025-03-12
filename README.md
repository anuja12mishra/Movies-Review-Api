# Movie Review API - Spring Boot \U0001F3AC

A RESTful API built with **Spring Boot** for reviewing movies. Users can fetch movie details, post reviews, and retrieve full review data for each movie.

## Features ✨
- Fetch movie details (title, genres, release date, trailer, etc.).
- Post reviews for movies.
- Retrieve movies along with their full reviews.
- MongoDB as the database for storing movies and reviews.
- Built using **Spring Boot, Spring Data MongoDB, and Java 17**.

## Tech Stack 🛠
- **Backend**: Spring Boot, Java
- **Database**: MongoDB
- **API Documentation**: Swagger (Optional)
- **Testing**: Postman

## Setup Instructions 🚀

### 1. Clone the repository:
```sh
git clone https://github.com/yourusername/movie-review-api.git
cd movie-review-api
```

### 2. Install dependencies:
```sh
mvn clean install
```

### 3. Start the application:
```sh
mvn spring-boot:run
```

### 4. Access API at:
```sh
http://localhost:8080/api/movies
```

## Endpoints 📌
| Method | Endpoint | Description |
|--------|---------|-------------|
| `GET`  | `/api/movies/{imdbId}` | Get movie details with full reviews |
| `POST` | `/api/movies/{imdbId}/reviews` | Add a new review to a movie |

## License 📜
This project is licensed under the MIT License.

---
### Contact 📧
For any queries or contributions, feel free to reach out via GitHub Issues.

