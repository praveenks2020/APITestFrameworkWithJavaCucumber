#Author: 123praveen@gmailcom
		
Feature: Historic Foreign Exchange Rate API Test
   
  Background:
	Given Rates API for Historic Foreign Exchange
	
	 @smoke @regression
  Scenario Outline: Validate response code of Historic Foreign Exchange Rate API Endpoint    
    When This API is available for historic date "<historic>" 
    Then Assert the response for historic
    
    Examples: Valid historic date
	    |  historic   |
      | 2013-12-24  |
      
    Examples: Future date
	    |  historic   |      
      | 2025-03-03  |
      
    Examples: Invalid date
	    |  historic   |      
      | 2000-00-10  |
      
   @smoke @regression
  Scenario Outline: Validate response of Historic Rates for given date and base
    When This API is available for date "<historic>" and base "<base>"
    Then Assert the response for historic
    
    Examples: Valid historic date and base 
    |  historic   | base  |
    | 2010-07-03  | USD   |
    
    Examples: Future date and base
    |  historic   | base  |
    | 2025-11-20  | GBP   |
    
    Examples: Invalid date and base
    |  historic   | base  |
    | 2000-17-33  | AUD   | 

    Examples: Valid date and Invalid base
    |  historic   | base  |         
    | 2010-07-03  | U!D   |

    Examples: Future date and Invalid base
    |  historic   | base  |     
    | 2025-11-20  | G^P   |

    Examples: Invalid date and Invalid base
    |  historic   | base  |     
    | 2000-17-33  | A-D   |
    
  @smoke @regression
  Scenario Outline: Validate response of Historic Rates for given symbols
    When This API is available for date "<historic>" and symbols "<symbols>"
    Then Assert the response for historic

    Examples: Valid historic date and single symbols 
    |  historic   | symbols      |
    | 2010-07-03  |   USD        |
    | 2010-07-03  |   EUR        |
 
    Examples: Future date and single symbols 
    |  historic   | symbols      |    
    | 2025-11-20  |   USD        |
		
    Examples: Invalid date and single symbols
    |  historic   | symbols      |
    | 2000-17-33  |   USD        |

    Examples: Valid historic date and invalid single symbols 
    |  historic   | symbols      |
    | 2010-07-03  |   U^D        |
 
    Examples: Future date and invalid single symbols 
    |  historic   | symbols      |    
    | 2025-11-20  |   U!D        |
		
    Examples: Invalid date and invalid single symbolss
    |  historic   | symbols      |
    | 2000-17-33  |   A@B        |

    Examples: Valid historic date and multiple symbols 
    |  historic   |     symbols                |
    | 2010-07-03  |   USD,CAD,ZWL,AUD,INR,EUR  |
    
    Examples: Future date and multiple symbols 
    |  historic   |     symbols               |
    | 2025-11-20  | USD,CAD,ZWL,AUD,INR,EUR   |
    
    Examples: Invalid date and multiple symbols 
    |  historic   |     symbols               |    
    | 2000-17-33  | USD,CAD,ZWL,AUD,INR,EUR   | 
    
    Examples: Valid historic date and one or more invalid multiple symbols 
    |  historic   |     symbols                |
    | 2010-07-03  |   USD,C$D,Z-L,A^D,INR,EUR  |
    
    Examples: Future date and one or more invalid multiple symbols 
    |  historic   |     symbols                |
    | 2025-11-20  | USD,C$D,Z-L,A^D,INR,EUR    |
    
    Examples: Invalid date and one or more invalid multiple symbols 
    |  historic   |     symbols                |    
    | 2000-17-33  | USD,C$D,Z-L,A^D,INR,EUR    |     
          
    
  @smoke @regression
  Scenario Outline: Validate response of Historic Rates for given symbols
    When This API is available for date "<historic>" and base "<base>" and symbols "<symbols>"
    Then Assert the response for historic
    
    Examples: Valid historic date and base and one or more symbols
    |  historic   | base |       symbols            |
    | 2010-07-03  | EUR  |         USD              |
    | 2008-11-15  | AUD  |         EUR              |
    | 2011-07-03  | EUR  | USD,CAD,ZWL,GBP,INR,AUD  |
    
    Examples: Future date and base and one or more symbols
    |  historic   | base | symbols        |
    | 2025-11-20  | EUR  |   GBP          |
    | 2125-01-20  | USD  |   EUR          |
    | 2056-10-20  | INR  |   USD,EUR,AUD  |  
      
    Examples: Invalid date and base and one or more symbols
    |  historic    | base |         symbols          |
    | 2000-17-33   | EUR  |           EUR            |    
    | 0000-17-100  | USD  | USD,CAD,ZWL,GBP,INR,AUD  |

    Examples: Valid historic date and invalid base and one or more symbols
    |  historic   | base | symbols       |
    | 2010-07-03  | E!R  |   EUR         |
    | 2005-07-03  | E!R  |   USD,EUR,AUD |
       
    Examples: Future date and invalid base and one or more symbols
    |  historic   | base  | symbols        |
    | 2025-11-20  | U&D   |   EUR          |
    | 2056-10-20  | &^B   |   USD,EUR,AUD  |  
       
    Examples: Invalid date and invalid base and one or more symbols
    |  historic   | base | symbols      |   
    | 2000-17-33  | A!D, |   EUR        | 
    | 2000-17-33  | !NR  | USD,EUR,AUD  | 
    
    Examples: Valid historic date and invalid base and one or more invalid symbols
    |  historic   | base | symbols       |
    | 2010-07-03  | E!R  |   USD         |
    | 2005-07-03  | E!R  |   USD,EUR,AUD |
       
    Examples: Future date and invalid base and one or more invalid symbols
    |  historic   | base  |   symbols     |
    | 2025-11-20  | U&D   |     EUR       |
    | 2125-01-20  | W!`D  |     USD       |
    | 2056-10-20  | &^B   |  USD,EUR,AUD  |  
       
    Examples: Invalid date and invalid base and one or more invalid symbols
    |  historic   | base |     symbols          |   
    | 2000-47-30  | A!D, |       U%D            |
    | 1000-27-33  | A!D, |      EUR,!NR         |  
    | 0000-17-13  | !NR  | U-I,E=R,A+D,INR,EUR  |    