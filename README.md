# ♻️ Waste Sorting API – Enviro365  

**Project Name:** Waste Sorting API  
**Developed By:** Sphesihle Mhlongo  
**Technology Stack:** Java, Spring Boot, H2 Database, RESTful APIs  

## 📌 Project Overview  
The **Waste Sorting API** is a RESTful web service designed to help users categorize waste and follow proper disposal guidelines. This API supports waste management applications by providing endpoints for retrieving, updating, and deleting waste categories while also offering recycling tips.  

### ✨ **Key Features**  
✅ **CRUD operations for waste categories**  
✅ **Retrieve disposal guidelines for a specific waste type**  
✅ **Access general recycling tips**  
✅ **Custom error handling for bad requests and missing resources**  

---

## 📂 Project Structure  
```
waste-sorting-api/
│── src/main/java/com/enviro/assessment/grad001/sphesihlemhlongo/wastesortingapi/
│   ├── controller/        # Handles API requests
│   ├── model/             # Defines data models
│   ├── repository/        # Database interactions
│   ├── service/           # Business logic
│   ├── dto/               # Data Transfer Objects
│   ├── exception/         # Custom error handling
│   ├── config/            # Configuration settings
│── src/main/resources/
│   ├── application.properties  # Database & server settings
│── pom.xml                # Maven dependencies
```

---

## 🚀 How to Run the Project  

### 1️⃣ **Prerequisites**  
- **Java 17+**  
- **Maven**  
- **Postman or PowerShell for API Testing**  
- **Spring Boot (Embedded H2 Database)**  

### 2️⃣ **Clone the Repository**  
```bash
git clone https://github.com/your-repo/waste-sorting-api.git
cd waste-sorting-api
```

### 3️⃣ **Build and Run the Application**  
```bash
mvn clean install
mvn spring-boot:run
```

---

## 📡 API Endpoints  

### 🟢 1. Retrieve All Waste Categories  
**GET** `/api/waste-categories`  
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/waste-categories" -Method Get
```

### 🟢 2. Retrieve a Specific Waste Category by ID  
**GET** `/api/waste-categories/{id}`  
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/waste-categories/1" -Method Get
```

### 🟢 3. Retrieve Disposal Guidelines by Waste Category  
**GET** `/api/waste-categories/{id}/guidelines`  
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/waste-categories/1/guidelines" -Method Get
```

### 🟢 4. Retrieve All Recycling Tips  
**GET** `/api/recycling-tips`  
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/recycling-tips" -Method Get
```

### 🟡 5. Add a New Waste Category  
**POST** `/api/waste-categories`  
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/waste-categories" 
    -Headers @{ "Content-Type" = "application/json" } 
    -Method Put 
    -Body '{"name":"Updated Plastic","disposalGuidelines":"Recycle in the updated bin."}'
```

### 🔴 7. Delete a Waste Category  
**DELETE** `/api/waste-categories/{id}`  
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/waste-categories/1" -Method Delete
```

---

## 🔧 Error Handling & Validations  
- **400 Bad Request** → When required fields are missing.  
- **404 Not Found** → When a resource (waste category) does not exist.  
- **500 Internal Server Error** → For unhandled server errors.  

✅ Implemented in `GlobalExceptionHandler.java` using `@ExceptionHandler`.  

---

## 📌 Future Improvements  
- 🔹 **User authentication** (e.g., JWT-based security).  
- 🔹 **Integration with external waste management systems.**  
- 🔹 **More advanced sorting recommendations using AI.**  

---

### 📢 Final Notes  
- The API is **stateless** and follows **RESTful principles**.  
- **H2 Database** is used for local development, but it can be switched to PostgreSQL or MySQL.  
- Designed for **scalability** and can be deployed on **Cloud platforms** like AWS/GCP.  

---

🚀 **Happy Coding & Keep the Environment Clean!** ♻️  
