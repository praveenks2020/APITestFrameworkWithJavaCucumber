#Author: Praveen Kumar Singh


Feature: Latest Foreign Exchange Rate API Test
   
  Background:
	Given Rates API for Latest Foreign Exchange
  
 @smoke @regression
  Scenario: Validate response code of Latest Foreign Exchange Rate API Endpoint    
    When This API is available
    Then Assert the status code 200
 
  @smoke @regression
  Scenario: Validate response code of Latest Foreign Rate API response for invalid path    
    When This API is available with invalid path
    Then Verify the response
          
  @smoke @regression
  Scenario Outline: Validate response of latest Rates for given base
    When This API is available for base "<base>"
    Then Assert the response for latest
    
    Examples: Valid base input
	    | base  |
      | USD   |
      | EUR   |
      
    Examples: Invalid base input
	    | base  |
      | !@NB  |
      | A~B   |
	
  @smoke @regression
  Scenario Outline: Validate response of latest Rates for given symbols
    When This API is available for symbols "<symbols>"
    Then Assert the response for latest
    
    Examples: Valid Single Symbols input
	    |   symbols     |
      |   USD         |
      |   EUR         |
      
    Examples: Invalid Single Symbols input
      |   symbols     |
      |   A!B         |
      |   !@NB        | 
      
		Examples: Valid Mutiple Symbols input
		  |   symbols          |
      |   USD,GBP,INR,AUD  |
      |   AUD,INR,GBP      |      
      |   USD,USD,USD      |
      |   EUR,EUR,EUR,EUR  | 
      
    Examples: One or more invalid symbols in Mutiple input 
		  |   symbols          |        
      |   GBP,A!B,AUD,%^$  |
      |   G^P,A!B,B-P      |

      
 @regression
  Scenario Outline: Validate response of latest Rates for given base and symbols
    When This API is available for base "<base>" and symbols "<symbols>"
    Then Assert the response for latest
    
   Examples: Valid base and single symbols input
	    | base |   symbols     |
      | EUR  |   USD         |
      | USD  |   EUR         |
      
   Examples: Valid base and invalid single symbols input  
   	  | base |   symbols     |   
      | USD  |   A!B         |
      | EUR  |   a@!`        |
      
   Examples: Invalid base and valid single symbols input 
      | base |   symbols     |   
      | U!D  |   USD         |
      | U^D  |   EUR         |
      
   Examples: Invalid base and invalid single symbols input 
      | base |   symbols     |        
      | U@D  |   A!B         |
      
   Examples: Valid base and multiple symbols input 
      | base |   symbols         |            
      | GBP  |   USD,GBP,AUD,INR |
      | EUR  |   EUR,EUR,EUR,EUR |
      | USD  |   AUD,INR,GBP     |        
      | USD  |   USD,USD,USD     | 
      
   Examples: Valid base and invalid one or more multiple symbols input 
      | base |   symbols       |
      | GBP  |   U?D,GBP,INR   |
      | INR  |   GBP,A!B,BKP   |  
      | USD  |   G^P,A!B,B-P   |
      
   Examples: Invalid base and valid multiple symbols input 
      | base |   symbols           |                
      | E!R  |   EUR,GBP,INR,AUD   |                        
      | U+D  |   AUD,INR,GBP       |        
      | U-D  |   USD,USD,USD       | 
      
   Examples: Invalid base and invalid one or more multiple symbols input 
      | base |   symbols       |            
      | !NR  |   GBP,X^B,INR   |  
      | U`D  |   G^P,A!B,B-P   |
      
            