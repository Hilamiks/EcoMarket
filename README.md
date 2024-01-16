E-Commerce backend app contains the following endpoints:
1) GET /categories -> returns all existing categories of products and their images
2) GET /products/{categoryId} -> returns all existing products(id, name, picture, price) in category with the provided Id
3) GET /products/info/{productId} -> returns info about product from it's id
4) POST /order -> saves new order (to be provided in the request body) into the database
    * Format: JSON object order with:

   {
      
         "phoneNumber":"String",
         "address":"String",
         "referenceLocation":"String",
         "comment":"String",
         "products": [
         1,
         2,
         2
         ]
         "status":"ACTIVE/COMPLETED/CANCELLED"
      
   }


5) GET /order/{phone} -> returns number(id) of the latest order connected to the provided phone number
6) GET /history/{phone} -> returns list of orders associated with the provided phone number
7) GET /order/info/{id} -> returns details of the order under provided id

***
NOTES for controlling data:
***
creating new categories: 

POST /new/category/{name}

(with attached image png or jpg in the body, under key "image") *note that this will save image to the server and return the created category object.
***
creating new products:

POST /products/new

make sure to attach the following params:
String name
String description
int price
Long categoryId (make sure the categoryId belongs to existing category)

in the body attach image as png or jpg
***
deleting categories:

DELETE /category/{id}

deleting products:

DELETE /product/{id}