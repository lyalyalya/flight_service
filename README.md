To test the application build jar in target folder and run
`docker-compose up`

Load employees:
POST http://localhost:8080/employees

Load flights:
POST http://localhost:8080/flights

Load pairings & assignments:
POST http://localhost:8080/rosters

Get pairings by employee:
GET http://localhost:8080/pairings?employeeId=111523

Get flights by employee:
GET http://localhost:8080/flights?employeeId=111523


Get details

GET http://localhost:8080/pairings/details

GET http://localhost:8080/flights/detailes

GET http://localhost:8080/employees/details

GET http://localhost:8080/assignments/details
