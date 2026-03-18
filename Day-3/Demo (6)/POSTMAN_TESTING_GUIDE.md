# Complete Postman Testing Guide

## Controller Analysis

### 1. DepartmentController
- **Base URL**: `/departments`
- **Method**: POST
- **Purpose**: Create new departments
- **Input**: DepartmentRequest (departmentName)
- **Output**: ApiResponse<DepartmentResponse>

### 2. TeacherController  
- **Base URL**: `/teachers`
- **Method**: POST
- **Purpose**: Create new teachers
- **Input**: TeacherRequest (name, phone, departmentId)
- **Output**: ApiResponse<TeacherResponse>

### 3. StudentController
- **Base URL**: `/students` 
- **Method**: POST
- **Purpose**: Create new students
- **Input**: StudentRequest (name, phone, address, dob, departmentId)
- **Output**: ApiResponse<StudentResponse>

---

## How to Run the Application

### Prerequisites:
1. MySQL server running on localhost:3306
2. Database named 'spring' created
3. MySQL credentials: username=root, password=Adi@758493

### Steps to Run:
1. Open terminal in project directory: `D:\SpringBoot\Day-3\Demo (5)`
2. Run command: `mvn spring-boot:run`
3. Or run `DemoApplication.java` from IDE
4. Application starts on: `http://localhost:8080`

---

## Postman Testing Guide

### STEP 1: Create Department (MUST DO FIRST)

**Request Configuration:**
- **Method**: POST
- **URL**: `http://localhost:8080/departments`
- **Headers**: 
  - Key: `Content-Type`
  - Value: `application/json`

**Body (raw JSON):**
```json
{
    "departmentName": "Computer Science"
}
```

**Expected Response:**
```json
{
    "status": "success",
    "data": {
        "departmentId": 1,
        "departmentName": "Computer Science"
    }
}
```

### STEP 2: Create More Departments (Optional)

**Body Examples:**
```json
{
    "departmentName": "Mathematics"
}
```

```json
{
    "departmentName": "Physics"
}
```

### STEP 3: Create Teacher

**Request Configuration:**
- **Method**: POST
- **URL**: `http://localhost:8080/teachers`
- **Headers**: 
  - Key: `Content-Type`
  - Value: `application/json`

**Body (raw JSON):**
```json
{
    "name": "Dr. John Smith",
    "phone": "9876543210",
    "departmentId": 1
}
```

**Expected Response:**
```json
{
    "status": "success",
    "data": {
        "id": 1,
        "name": "Dr. John Smith",
        "phone": "9876543210",
        "departmentName": "Computer Science"
    }
}
```

### STEP 4: Create Student

**Request Configuration:**
- **Method**: POST
- **URL**: `http://localhost:8080/students`
- **Headers**: 
  - Key: `Content-Type`
  - Value: `application/json`

**Body (raw JSON):**
```json
{
    "name": "Alice Johnson",
    "phone": "1234567890",
    "address": "123 Main Street, New York",
    "dob": "2000-05-15",
    "departmentId": 1
}
```

**Expected Response:**
```json
{
    "status": "success",
    "data": {
        "id": 1,
        "name": "Alice Johnson",
        "phone": "1234567890",
        "address": "123 Main Street, New York",
        "dob": "2000-05-15",
        "departmentName": "Computer Science"
    }
}
```

---

## Sample Test Data

### Multiple Departments:
```json
{"departmentName": "Computer Science"}
{"departmentName": "Mathematics"}  
{"departmentName": "Physics"}
{"departmentName": "Chemistry"}
```

### Multiple Teachers:
```json
{"name": "Dr. Sarah Wilson", "phone": "9876543211", "departmentId": 1}
{"name": "Prof. Michael Brown", "phone": "9876543212", "departmentId": 2}
{"name": "Dr. Emily Davis", "phone": "9876543213", "departmentId": 3}
```

### Multiple Students:
```json
{"name": "Bob Smith", "phone": "1234567891", "address": "456 Oak Ave", "dob": "1999-12-10", "departmentId": 1}
{"name": "Carol White", "phone": "1234567892", "address": "789 Pine St", "dob": "2001-03-22", "departmentId": 2}
{"name": "David Lee", "phone": "1234567893", "address": "321 Elm Dr", "dob": "2000-08-05", "departmentId": 1}
```

---

## Important Notes:

1. **Order Matters**: Always create departments first, then teachers/students
2. **departmentId**: Must reference existing department ID
3. **Date Format**: Use "YYYY-MM-DD" format for dob
4. **Phone**: String format, can include any characters
5. **Error Handling**: If departmentId doesn't exist, you'll get "Department not found" error

---

## Common Errors and Solutions:

### Error: "Department not found"
- **Cause**: Using non-existent departmentId
- **Solution**: Create department first or use correct departmentId

### Error: Connection refused
- **Cause**: Application not running
- **Solution**: Start the Spring Boot application

### Error: Database connection failed  
- **Cause**: MySQL not running or wrong credentials
- **Solution**: Start MySQL and verify database 'spring' exists

### Error: 400 Bad Request
- **Cause**: Invalid JSON format or missing required fields
- **Solution**: Check JSON syntax and ensure all required fields are present