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
### Create a Customers with adresses, reports and commennts:
**URL**: http://localhost:8080/customer

*Notes*: 
  - Each customer must be created separately.
  - This does not link the report to the customer. This must be done manually by updating the 'customer_customer_number' column in the 'report' table, see next section.
```json
{
    "lastName": "Durand",
    "firstName": "Jeanne",
    "dateOfBirth": "1988-05-14T05:33:00.000+00:00",
    "address": [
        {
            "streetNumbers": "886",
            "streetName": "Rue des Mercières",
            "zipCode": "69140",
            "city": "Rillieux-la-Pape",
            "country": "France",
            "details": "Batiment C"
        }
    ],
    "reports": [
        {
            "creationDate": "2017-02-26T13:13:00.000+00:00",
            "modificationDate": "",
            "title": "Rpt-Durand_Jeanne_2017-02-26",
            "domain": "DAMAGE",
            "status": "ACCEPTED",
            "comment": [
                {
                    "creationDate": "2017-02-26T13:13:00.000+00:00",
                    "commentText": "This is a comment made on the Rpt-Durand_Jeanne_2017-02-26"
                }
            ],
            "documents": [
                {
                    "url": "http://file-storage.com/123456789"
                }
            ]
        }
    ]
}
```
```json
{
    "lastName": "Dupont",
    "firstName": "Jean",
    "dateOfBirth": "1975-04-22T10:45:00.000+00:00",
    "address": [
        {
            "streetNumbers": "86",
            "streetName": "Rue Paul Bert",
            "zipCode": "69003",
            "city": "Lyon",
            "country": "France"
        }
    ],
    "reports": [
        {
            "creationDate": "2012-08-13T15:20:00.000+00:00",
            "modificationDate": "",
            "title": "Rpt-Dupont_Jean_2012-08-13",
            "domain": "DISEASE",
            "status": "ACCEPTED",
            "comment": [
                {
                    "creationDate": "2012-08-13T15:20:00.000+00:00",
                    "commentText": "This is a comment made on the Rpt-Dupont_Jean_2012-08-13"
                }
            ],
            "documents": [
                {
                    "url": "http://file-storage.com/456789123"
                }
            ]
        },
        {
            "creationDate": "2020-08-20T08:12:00.000+00:00",
            "modificationDate": "2020-08-20T10:45:00.000+00:00",
            "title": "Rpt-Dupont_Jean_2020-08-20",
            "domain": "ACCIDENT",
            "status": "PENDING",
            "comment": [
                {
                    "creationDate": "2020-08-20T10:45:00.000+00:00",
                    "commentText": "This is a comment made on the Rpt-Dupont_Jean_2020-08-20"
                }
            ],
            "documents": [
                {
                    "url": "http://file-storage.com/789456123"
                }
            ]
        }
    ]
}
```
```json
{
    "lastName": "Dupont",
    "firstName": "Pierre",
    "dateOfBirth": "1984-05-27T00:12:00.000+00:00",
    "address": [
        {
            "streetNumbers": "122",
            "streetName": "Avenue Roche",
            "zipCode": "75000",
            "city": "Paris",
            "country": "France"
        }
    ],
    "reports": [
        {
            "creationDate": "2018-09-17T16:02:30.000+00:00",
            "modificationDate": "",
            "title": "Rpt-Dupont_Pierre_2018-09-17",
            "domain": "DAMAGE",
            "status": "REFUSED",
            "comment": [
                {
                    "creationDate": "2018-09-17T16:02:31.000+00:00",
                    "commentText": "This is a comment made on the Rpt-Dupont_Pierre_2018-09-17"
                }
            ],
            "documents": [
                {
                    "url": "http://file-storage.com/8462157484"
                }
            ]
        }
    ]
}
```

## SQL Queries to link entities:
```sql
UPDATE report SET customer_customer_number = 1 WHERE id = 1;
UPDATE report SET customer_customer_number = 2 WHERE id = 2;
UPDATE report SET customer_customer_number = 2 WHERE id = 3;
UPDATE report SET customer_customer_number = 3 WHERE id = 4;
```

## URLs:
### Swagger URLs:
- See api endpoints as JSON: http://localhost:8080/v2/api-docs
- See api endpoints with Swagger UI: http://localhost:8080/swagger-ui/
