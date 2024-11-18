# 🛳️ Titanic Passenger API
A Spring Boot-based RESTful API to retrieve data about Titanic passengers. This project demonstrates clean code practices, modern Kotlin techniques, and API validation.

---

## **📜 Features**
- **Retrieve Passengers**: Fetch a paginated list of Titanic passengers based on survival status and class.
- **Passenger Details**: Retrieve detailed information about a specific passenger by ID.
- **Validation**: Ensure request parameters conform to expected formats with custom error messages.
- **Pagination**: Supports customizable page size and index for large datasets.

---

## **📂 API Endpoints**

### **1. Get Passengers**
Fetch a paginated list of passengers filtered by survival status and class.

**Endpoint**:  
`GET /passengers`

**Query Parameters**:
| Parameter    | Type    | Description                                  | Constraints                          |
|--------------|---------|----------------------------------------------|--------------------------------------|
| `survived`   | Boolean | (Optional) Filter passengers by survival     | `true` or `false`                   |
| `pclass`     | Int     | (Optional) Filter by passenger class         | Min: `1`, Max: `3`                  |
| `page`       | Int     | (Optional) Pagination page index (default: 0)| `>= 0`                              |
| `size`       | Int     | (Optional) Page size (default: 5)            | `> 0`                               |

**Response**:
- `200 OK`: Returns the list of passengers if data is available.
- `204 No Content`: If no passengers match the filter criteria.

---

### **2. Get Passenger By ID**
Fetch detailed information about a specific passenger.

**Endpoint**:  
`GET /passengers/{passenger_id}`

**Path Parameter**:
| Parameter        | Type   | Description                  |
|------------------|--------|------------------------------|
| `passenger_id`   | Long   | ID of the passenger to fetch |

**Response**:
- `200 OK`: Returns a `PassengerDto` object containing passenger details.

---

## **🛠️ Setup & Usage**

### **Prerequisites**
- **Java 21+**
- **Kotlin 2.0+**
- **Maven 3.9+**

### **1. Clone the Repository**
```bash
git clone https://github.com/your-repo/titanic-passenger-api.git
cd titanic-passenger-api
```
### **2. Install the app**
```bash
mvn clean install
```

### **3. Run the application**
```bash
mvn clean install
```


# 🧪 Sample Request

## Fetch Passengers
```bash
curl -X GET "http://localhost:8080/passengers?survived=true&pclass=2&page=0&size=5" -H "accept: application/json"
```

## Fetch Passengers By ID
```bash
curl -X GET "http://localhost:8080/passengers/1" -H "accept: application/json"```
```

# 🚢 Passenger DTO Example

```
{
	"id": 5,
	"survived": false,
	"pclass": 3,
	"name": "Allen, Mr. William Henry",
	"sex": "male",
	"age": 35.0,
	"sibSp": 0,
	"parch": 0,
	"ticket": "373450",
	"fare": 8.05,
	"embarked": "S"
}
```

# 💻 Technologies Used
- Kotlin: For clean and concise code.
- Spring Boot: Backend framework for REST API.
- H2 Database: In-memory database for development.
- Jakarta Validation: Ensures request integrity with annotations.
- Maven: Build and dependency management.


# Made with ❤️ by Jhonatan Suardi