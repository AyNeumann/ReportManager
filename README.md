# ReportManager
This is a simple test project to get started on:
  - Java 1.8
  - Spring Boot
  - Maven
  - Spring Data JPA
  - PostGreSQL database
  - Logback
  - Swagger with springfox library

***
## JSON sample to create basic datas:
### Create a Customer with an adress and a report:
**URL**: http://localhost:8080/customer
```json
{
    "lastName": "Dupont",
    "firstName": "Pierre",
    "dateOfBirth": "1986-10-01T09:54:00.000+00:00",
    "address": [
        {
            "streetNumbers": "886",
            "streetName": "Rue des Mercières",
            "zipCode": "69140",
            "city": "Rillieux-la-Pape",
            "country": "France",
            "details": "Batiment A"
        }
    ],
    "reports": [
        {
            "creationDate": "2015-01-22T10:22:00.000+00:00",
            "modificationDate": "2015-01-23T15:13:00.000+00:00",
            "title": "Rpt-Dupont_Pierre_2020-01-22",
            "domain": "DISEASE",
            "status": "REFUSED",
            "comment": [
            ],
            "documents": [
            ]
        }
    ]
}
```
