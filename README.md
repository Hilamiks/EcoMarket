* The app is currently populated with some test items, you can use the end point "DELETE /clear" to get rid of all of them. CAUTION DO NOT USE IN PRODUCTION
* All Images are currently just placeholders (an apple and some food). You can upload your own image in the post mapping, and it will be saved.


E-Commerce backend app contains the following endpoints:
1) GET /categories -> returns all existing categories of products and their images (work in progress, now it is only a string)
2) GET /products/{categoryId} -> returns all existing products(id, name, picture, price) in category with the provided Id
3) GET /products/info/{productId} -> returns info about product from it's id
4) POST /order -> saves new order (to be provided in the request body) into the database
5) GET /order/{phone} -> returns number of the latest order connected to the provided phone number
6) GET /history/{phone} -> returns list of orders associated with the provided phone number
7) GET /order/info/{id} -> returns details of the order under provided id

EXTRA endpoints (to create/delete/populate the db e.g. for tests)
1) GET /populate -> creates some categories and products (just not to have the db empty)
2) GET /populateorders -> does the same, but with orders
3) DELETE /clear -> clears products, categories and orders
4) DELETE /clearorders -> clears orders

***
NOTES for populating with data:

creating new categories: 

POST /categories/new/{name} (with attached image png or jpg in the body, under key "image") *note that this will save image to the server and return the created category object.

creating new products:

POST /products/new/


