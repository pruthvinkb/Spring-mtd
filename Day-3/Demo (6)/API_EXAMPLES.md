# API Usage Examples

## 1. Create Department
POST http://localhost:8080/departments
Content-Type: application/json

{
    "departmentName": "Computer Science"
}

Response:
{
    "message": "success",
    "data": {
        "departmentId": 1,
        "departmentName": "Computer Science"
    }
}

## 2. Create Teacher
POST http://localhost:8080/teachers
Content-Type: application/json

{
    "name": "Dr. Smith",
    "phone": "9876543210",
    "departmentId": 1
}

Response:
{
    "message": "success",
    "data": {
        "id": 1,
        "name": "Dr. Smith",
        "phone": "9876543210",
        "departmentName": "Computer Science"
    }
}

## 3. Create Student
POST http://localhost:8080/students
Content-Type: application/json

{
    "name": "John Doe",
    "phone": "1234567890",
    "address": "123 Main St, City",
    "dob": "2000-01-15",
    "departmentId": 1
}

Response:
{
    "message": "success",
    "data": {
        "id": 1,
        "name": "John Doe",
        "phone": "1234567890",
        "address": "123 Main St, City",
        "dob": "2000-01-15",
        "departmentName": "Computer Science"
    }
}

## Database Tables Created:
- departments (department_id, department_name)
- teachers (id, name, phone, department_id)
- students (id, name, phone, address, dob, department_id)