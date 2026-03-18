# Postman Testing Guide - Billing System

## Base URL
```
http://localhost:8080
```

## Testing Sequence (Follow this order)

### 1. CREATE USER
**Method:** POST  
**URL:** `http://localhost:8080/api/users`  
**Headers:** Content-Type: application/json  
**Body (raw JSON):**
```json
{
    "name": "John Doe"
}
```
**Expected Response:**
```json
{
    "message": "User created successfully",
    "success": true,
    "data": {
        "id": 1,
        "name": "John Doe"
    }
}
```

### 2. GET ALL USERS
**Method:** GET  
**URL:** `http://localhost:8080/api/users`  
**Headers:** None needed

### 3. CREATE BILL
**Method:** POST  
**URL:** `http://localhost:8080/api/bills`  
**Headers:** Content-Type: application/json  
**Body (raw JSON):**
```json
{
    "userId": 1
}
```
**Expected Response:**
```json
{
    "message": "Bill created successfully",
    "success": true,
    "data": {
        "id": 1,
        "user": {
            "id": 1,
            "name": "John Doe"
        }
    }
}
```

### 4. ADD PRODUCT TO BILL
**Method:** POST  
**URL:** `http://localhost:8080/api/products`  
**Headers:** Content-Type: application/json  
**Body (raw JSON):**
```json
{
    "billId": 1,
    "prodName": "Laptop",
    "prodQty": 2,
    "prodMrp": 50000.00,
    "prodTax": 9000.00
}
```
**Expected Response:**
```json
{
    "message": "Product added successfully",
    "success": true,
    "data": {
        "id": 1,
        "prodName": "Laptop",
        "prodQty": 2,
        "prodMrp": 50000.00,
        "prodTax": 9000.00,
        "prodTotal": 109000.00
    }
}
```

### 5. ADD ANOTHER PRODUCT
**Method:** POST  
**URL:** `http://localhost:8080/api/products`  
**Body (raw JSON):**
```json
{
    "billId": 1,
    "prodName": "Mouse",
    "prodQty": 1,
    "prodMrp": 1500.00,
    "prodTax": 270.00
}
```

### 6. GET BILL WITH PRODUCTS
**Method:** GET  
**URL:** `http://localhost:8080/api/bills/1`

### 7. GET PRODUCTS BY BILL
**Method:** GET  
**URL:** `http://localhost:8080/api/products/bill/1`

### 8. GET USER'S BILLS
**Method:** GET  
**URL:** `http://localhost:8080/api/bills/user/1`

## Additional Test Cases

### Create Another User
```json
POST /api/users
{
    "name": "Jane Smith"
}
```

### Create Bill for Second User
```json
POST /api/bills
{
    "userId": 2
}
```

### Get All Bills
```
GET /api/bills
```

### Get All Products
```
GET /api/products
```

### Delete User
```
DELETE /api/users/1
```

## Important Notes

1. **Start the application first:** Run `BillingSystemApplication.java`
2. **Database:** Make sure MySQL is running and `billing_db` database exists
3. **Order matters:** Create users before bills, create bills before adding products
4. **Auto-calculation:** `prod_total` is automatically calculated as `(prod_mrp × prod_qty) + prod_tax`
5. **IDs:** Use the actual IDs returned from previous requests

## Expected Behavior

- ✅ Users can be created and retrieved
- ✅ Bills are linked to users
- ✅ Products are linked to bills
- ✅ Product totals are auto-calculated
- ✅ Relationships work properly (user → bills → products)
- ✅ JSON responses are clean (no circular references)

## Troubleshooting

- **404 Error:** Check if application is running on port 8080
- **500 Error:** Check database connection and credentials
- **400 Error:** Check JSON format and required fields
- **Foreign Key Error:** Make sure referenced IDs exist

**Ready to test! Start with creating a user and follow the sequence above.**