Feature: This API is to create a record in DB with the Geo location position of the vehicle  

	Scenario: Successful Vehicle Profile Creation 
    Given app/browser post to  with below request:
    """
   			 {
 					 "latitude":"54.67",
					 "longitude":"-76.67",
					 "licensePlate":"ANY-6789",
					 "vehicleType":"ECONOMY",
					 "vehicleBrand":"NISAN"
				}
    """ 
    When consumer calls "/api/v1/gps/track/location" api
    Then consumer gets 200 with below response 
 