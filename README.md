***NOTE: DOES NOT WORK WITH IMAGES YET, USES STRING AS PLACEHOLDER***
E-Commerce backend app contains the following endpoints:
1) GET /categories -> returns all existing categories of products and their images (work in progress, now it is only a string)
2) GET /products/{categoryId} -> returns all existing products(id, name, picture, price) in category with the provided Id
3) GET /products/info/{productId} -> returns info about product from it's id
4) POST /order -> saves new order (to be provided in the request body) into the database
5) GET /order/{phone} -> returns number of the latest order connected to the provided phone number
6) GET /history/{phone} -> returns list of orders associated with the provided phone number
7) GET /order/info/{id} -> returns details of the order under provided id


***TODO:
1) 
2) 
3) sort orders in history by creation date
4) remove test endpoints that will not be necessary in the final version

Object Structure EXAMPLES:

category:
  {
    "categoryId":1,
    "name":"Fruit",
    "picture":"Fruit Image"
  }

product:
  {
    "productId":1,
    "name":"Apple",
    "picture":"Apple Image",
    "price":20,
    "category":
    {
      "categoryId":1,
      "name":"Fruit",
      "picture":
      "Fruit Image"
    }
  }

order:
{
  "orderId":1,
  "phoneNumber":"+123 456 789",
  "creationDate":"2024-01-13T17:14:59.21313",
  "address":"123 Random St",
  "referenceLocation":"Random house",
  "comment":"please, don't be late",
  "products":[1,2],
  "status":"COMPLETE"
}




