#!/bin/bash

# Color codes for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Configuration
BASE_URL="http://localhost:8080"
TIMESTAMP=$(date +%s)

# Test counters
TESTS_PASSED=0
TESTS_FAILED=0

# Helper function to print test results
print_test() {
    local test_name=$1
    local status=$2

    if [ "$status" = "PASS" ]; then
        echo -e "${GREEN}✓${NC} $test_name"
        ((TESTS_PASSED++))
    else
        echo -e "${RED}✗${NC} $test_name"
        ((TESTS_FAILED++))
    fi
}

# Helper function to make requests and parse responses
make_request() {
    local method=$1
    local endpoint=$2
    local data=$3
    local description=$4

    echo -e "\n${BLUE}→${NC} $description"

    if [ -z "$data" ]; then
        response=$(curl -s -X $method "$BASE_URL$endpoint" \
            -H "Content-Type: application/json")
    else
        response=$(curl -s -X $method "$BASE_URL$endpoint" \
            -H "Content-Type: application/json" \
            -d "$data")
    fi

    echo "$response" | jq '.' 2>/dev/null || echo "$response"
    echo "$response"
}

# Main test execution
echo -e "${YELLOW}════════════════════════════════════════${NC}"
echo -e "${YELLOW}   Spring Boot API Test Suite${NC}"
echo -e "${YELLOW}════════════════════════════════════════${NC}"
echo -e "Base URL: ${BLUE}$BASE_URL${NC}"
echo -e "Timestamp: $(date)\n"

# ============== TEST 1: Create User ==============
echo -e "\n${YELLOW}[TEST 1]${NC} Create User"
user_response=$(curl -s -X POST "$BASE_URL/users" \
    -H "Content-Type: application/json" \
    -d '{
        "name": "John Doe"
    }')

user_id=$(echo "$user_response" | jq -r '.data.id' 2>/dev/null)
user_name=$(echo "$user_response" | jq -r '.data.name' 2>/dev/null)

echo "$user_response" | jq '.'

if [ -n "$user_id" ] && [ "$user_id" != "null" ]; then
    print_test "Create User: $user_name (ID=$user_id)" "PASS"
else
    print_test "Create User" "FAIL"
    echo "Error: Could not create user"
    exit 1
fi

# ============== TEST 2: Create Bill ==============
echo -e "\n${YELLOW}[TEST 2]${NC} Create Bill for User"
bill_response=$(curl -s -X POST "$BASE_URL/bills" \
    -H "Content-Type: application/json" \
    -d "{
        \"userId\": $user_id
    }")

bill_id=$(echo "$bill_response" | jq -r '.data.id' 2>/dev/null)

echo "$bill_response" | jq '.'

if [ -n "$bill_id" ] && [ "$bill_id" != "null" ]; then
    print_test "Create Bill for User $user_id (Bill ID=$bill_id)" "PASS"
else
    print_test "Create Bill" "FAIL"
    echo "Error: Could not create bill"
    exit 1
fi

# ============== TEST 3: Create Product 1 ==============
echo -e "\n${YELLOW}[TEST 3]${NC} Create Product 1 (Laptop)"
prod1_response=$(curl -s -X POST "$BASE_URL/products" \
    -H "Content-Type: application/json" \
    -d '{
        "prodName": "Laptop",
        "prodQty": 50,
        "prodMrp": 50000,
        "prodTax": 18
    }')

prod1_id=$(echo "$prod1_response" | jq -r '.data.id' 2>/dev/null)
prod1_name=$(echo "$prod1_response" | jq -r '.data.prodName' 2>/dev/null)

echo "$prod1_response" | jq '.'

if [ -n "$prod1_id" ] && [ "$prod1_id" != "null" ]; then
    print_test "Create Product: $prod1_name (ID=$prod1_id)" "PASS"
else
    print_test "Create Product 1" "FAIL"
    echo "Error: Could not create product 1"
    exit 1
fi

# ============== TEST 4: Create Product 2 ==============
echo -e "\n${YELLOW}[TEST 4]${NC} Create Product 2 (Mouse)"
prod2_response=$(curl -s -X POST "$BASE_URL/products" \
    -H "Content-Type: application/json" \
    -d '{
        "prodName": "Mouse",
        "prodQty": 200,
        "prodMrp": 500,
        "prodTax": 12
    }')

prod2_id=$(echo "$prod2_response" | jq -r '.data.id' 2>/dev/null)
prod2_name=$(echo "$prod2_response" | jq -r '.data.prodName' 2>/dev/null)

echo "$prod2_response" | jq '.'

if [ -n "$prod2_id" ] && [ "$prod2_id" != "null" ]; then
    print_test "Create Product: $prod2_name (ID=$prod2_id)" "PASS"
else
    print_test "Create Product 2" "FAIL"
    echo "Error: Could not create product 2"
    exit 1
fi

# ============== TEST 5: Create Product 3 ==============
echo -e "\n${YELLOW}[TEST 5]${NC} Create Product 3 (Keyboard)"
prod3_response=$(curl -s -X POST "$BASE_URL/products" \
    -H "Content-Type: application/json" \
    -d '{
        "prodName": "Keyboard",
        "prodQty": 100,
        "prodMrp": 2000,
        "prodTax": 12
    }')

prod3_id=$(echo "$prod3_response" | jq -r '.data.id' 2>/dev/null)
prod3_name=$(echo "$prod3_response" | jq -r '.data.prodName' 2>/dev/null)

echo "$prod3_response" | jq '.'

if [ -n "$prod3_id" ] && [ "$prod3_id" != "null" ]; then
    print_test "Create Product: $prod3_name (ID=$prod3_id)" "PASS"
else
    print_test "Create Product 3" "FAIL"
fi

# ============== TEST 6: Add Bill Item 1 ==============
echo -e "\n${YELLOW}[TEST 6]${NC} Add Bill Item 1 (Laptop to Bill)"
item1_response=$(curl -s -X POST "$BASE_URL/bill-items" \
    -H "Content-Type: application/json" \
    -d "{
        \"billId\": $bill_id,
        \"productId\": $prod1_id,
        \"qty\": 2
    }")

item1_id=$(echo "$item1_response" | jq -r '.data.id' 2>/dev/null)
item1_total=$(echo "$item1_response" | jq -r '.data.total' 2>/dev/null)

echo "$item1_response" | jq '.'

if [ -n "$item1_id" ] && [ "$item1_id" != "null" ]; then
    print_test "Add Bill Item: Product $prod1_id, Qty=2 (Item ID=$item1_id, Total=$item1_total)" "PASS"
else
    print_test "Add Bill Item 1" "FAIL"
fi

# ============== TEST 7: Add Bill Item 2 ==============
echo -e "\n${YELLOW}[TEST 7]${NC} Add Bill Item 2 (Mouse to Bill)"
item2_response=$(curl -s -X POST "$BASE_URL/bill-items" \
    -H "Content-Type: application/json" \
    -d "{
        \"billId\": $bill_id,
        \"productId\": $prod2_id,
        \"qty\": 5
    }")

item2_id=$(echo "$item2_response" | jq -r '.data.id' 2>/dev/null)
item2_total=$(echo "$item2_response" | jq -r '.data.total' 2>/dev/null)

echo "$item2_response" | jq '.'

if [ -n "$item2_id" ] && [ "$item2_id" != "null" ]; then
    print_test "Add Bill Item: Product $prod2_id, Qty=5 (Item ID=$item2_id, Total=$item2_total)" "PASS"
else
    print_test "Add Bill Item 2" "FAIL"
fi

# ============== TEST 8: Add Bill Item 3 ==============
echo -e "\n${YELLOW}[TEST 8]${NC} Add Bill Item 3 (Keyboard to Bill)"
item3_response=$(curl -s -X POST "$BASE_URL/bill-items" \
    -H "Content-Type: application/json" \
    -d "{
        \"billId\": $bill_id,
        \"productId\": $prod3_id,
        \"qty\": 1
    }")

item3_id=$(echo "$item3_response" | jq -r '.data.id' 2>/dev/null)
item3_total=$(echo "$item3_response" | jq -r '.data.total' 2>/dev/null)

echo "$item3_response" | jq '.'

if [ -n "$item3_id" ] && [ "$item3_id" != "null" ]; then
    print_test "Add Bill Item: Product $prod3_id, Qty=1 (Item ID=$item3_id, Total=$item3_total)" "PASS"
else
    print_test "Add Bill Item 3" "FAIL"
fi

# ============== TEST 9: Get All Products ==============
echo -e "\n${YELLOW}[TEST 9]${NC} Get All Products"
all_products=$(curl -s -X GET "$BASE_URL/products" \
    -H "Content-Type: application/json")

prod_count=$(echo "$all_products" | jq '.data | length' 2>/dev/null)

echo "$all_products" | jq '.'

if [ -n "$prod_count" ] && [ "$prod_count" -gt 0 ]; then
    print_test "Get All Products: Retrieved $prod_count products" "PASS"
else
    print_test "Get All Products" "FAIL"
fi

# ============== TEST 10: Get Bill Items ==============
echo -e "\n${YELLOW}[TEST 10]${NC} Get Bill Items for Bill $bill_id"
bill_items=$(curl -s -X GET "$BASE_URL/bill-items/bill/$bill_id" \
    -H "Content-Type: application/json")

items_count=$(echo "$bill_items" | jq '.data | length' 2>/dev/null)

echo "$bill_items" | jq '.'

if [ -n "$items_count" ] && [ "$items_count" -gt 0 ]; then
    print_test "Get Bill Items: Retrieved $items_count items for Bill $bill_id" "PASS"
else
    print_test "Get Bill Items" "FAIL"
fi

# ============== TEST 11: Get Bills by User ==============
echo -e "\n${YELLOW}[TEST 11]${NC} Get Bills for User $user_id"
user_bills=$(curl -s -X GET "$BASE_URL/bills/user/$user_id" \
    -H "Content-Type: application/json")

bills_count=$(echo "$user_bills" | jq '.data | length' 2>/dev/null)

echo "$user_bills" | jq '.'

if [ -n "$bills_count" ] && [ "$bills_count" -gt 0 ]; then
    print_test "Get Bills for User: Retrieved $bills_count bills for User $user_id" "PASS"
else
    print_test "Get Bills for User" "FAIL"
fi

# ============== Test Summary ==============
echo -e "\n${YELLOW}════════════════════════════════════════${NC}"
echo -e "${YELLOW}   Test Summary${NC}"
echo -e "${YELLOW}════════════════════════════════════════${NC}"
echo -e "${GREEN}✓ Passed: $TESTS_PASSED${NC}"
echo -e "${RED}✗ Failed: $TESTS_FAILED${NC}"

if [ $TESTS_FAILED -eq 0 ]; then
    echo -e "\n${GREEN}All tests passed! 🎉${NC}"
    exit 0
else
    echo -e "\n${RED}Some tests failed!${NC}"
    exit 1
fi
