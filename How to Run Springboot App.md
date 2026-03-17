How to Run Springboot App:



* cd "C:\\Users\\AA258HS\\OneDrive - EY\\Desktop\\Bootcamp\\Week 4 Java and Springboot\\demo"
* .\\gradlew.bat bootRun
* Open split terminal and run the following tests:

  * GET all videos

    * curl.exe: curl.exe http://localhost:8080/api/videos
    * PowerShell: Invoke-RestMethod http://localhost:8080/api/videos -UseBasicParsing
  * GET available videos

    * curl.exe: curl.exe http://localhost:8080/api/videos/available
    * PowerShell: Invoke-RestMethod http://localhost:8080/api/videos/available -UseBasicParsing
  * POST add a movie

    * curl.exe: curl.exe -X POST http://localhost:8080/api/videos/add/movie -H "Content-Type: application/json" -d "{\\"title\\":\\"Interstellar\\",\\"genre\\":\\"Sci-Fi\\"}"
    * PowerShell: Invoke-RestMethod -Method Post -Uri http://localhost:8080/api/videos/add/movie -ContentType "application/json" -Body '{"title":"Interstellar","genre":"Sci-Fi"}'
  * PUT rent a video

    * curl.exe: curl.exe -X PUT http://localhost:8080/api/videos/Inception/rent
    * PowerShell: Invoke-RestMethod -Method Put -Uri http://localhost:8080/api/videos/Inception/rent
  * PUT return a video

    * curl.exe: curl.exe -X PUT http://localhost:8080/api/videos/Inception/return
    * PowerShell: Invoke-RestMethod -Method Put -Uri http://localhost:8080/api/videos/Inception/return





