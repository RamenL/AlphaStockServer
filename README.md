# AlphaStockServer
  AlphaStockServer is a server that keeps track of a ticker. Every five minutes, it makes a Get Request to the Alpha Advantage Api to get the most recent information, the uses Jackson to deserialize the Json, the stores everything in a Singleton object. REST Api requests can then be made to the server to get information about the current tracked ticker. 

# Goals
  The goal of this project was to learn Spring MVC as well as further my familiarity with Jackson, Gradle, and Postman. 
  
# Improvements
1. A better design would be to make a websocket connection and have the server automatically push when updates are received. 

2. Another flaw in the current design is the time frame of the ticker update. While the AlphaApi might update at 1:00PM, the server may not get the most recent update until 1:04PM. This improvement could be achieved by looking at the "Last Refreshed" field in the Meta Data and adding five minutes. Then the server would check if the local time passed the time before making its next call. 
