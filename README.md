Project is consist of services and repositories. The project database side was developed on MySQL server. 
All data is coming from MySQL server to repository inside of models. 
Then repository is collect all data and show them as interface
There are services class that are representative of all actions that came from database
On the project used two controller - Controller and RestController
Controllers are connecting uri links and within uri link it try to find appropriate jsp file.
RestController is get data from database and send it uri link as JSON format within GET MAPPING.
Product is representative of full system that you can sell your product.
