# MicroServices - Cloud Computing Course

Main Components: `Spring, Docker, MongoDB, RSocket`

# Prerequisites:

- Docker
- Java 11

# Using Docker:

1. `docker-compose -f .\RSocket_service\docker-compose.yaml build`
2. `docker-compose -f .\RSocket_service\docker-compose.yaml up`

# The RSocket GUI

For this project, we built a small GUI to make the RSocket communication easier.

The GUI provides a simple interface to create the boundaries objects and pass them as a JSON formatted data to the
RSocket client.

## The GUI's sections:

### Data:

![image](https://user-images.githubusercontent.com/73391391/169661054-b22d45cb-f489-4c62-8719-fdf80c8dd6ee.png)

In this part you can select if you want to send data (by checking the checkbox), and which data you want to send.

You have 3 options for data:

- `Order` - Create an order boundary object with ID, user's email and a list of products.
- `User` - Create a user boundary object with user's email.
- `Raw JSON` - A JSON formatted string that represents the object you want to send.
  Note: you can't send a non-JSON string nor an array - the text must represent an object.

The application will send the data from the selected tab only, convert this data to a compact JSON formatted string and
send it to the service.

### Connection Info:

![image](https://user-images.githubusercontent.com/73391391/169653946-4740bd13-b217-4a9a-ae62-eafef51e2632.png)

In this part you enter the following information about the connection:

1. The type of transmission:
    1. request-response - Send a request to the service and listens to a response from the server.
    2. fire-and-forget - Send a request to the service and close the connection.
    3. stream - Send a request to the service and listens to every data the server sends, until no more data is sent (or
       an empty data).
    4. channel - Open a communication channel with the service and sends data to it as long as the process is running.

2. Check this box if you wish to run in a debug mode (i.e., more verbose printing).
3. A path to the RSocket client JAR file (this file can be downloaded from [here](https://github.com/making/rsc/releases)).
4. One of the following routes in the service:
    1. `order-req-resp` - Creates and stores an order in the database based on the provided input.
       If the order already exists and open, the quantity of each product in its list will be updated based on the
       provided input.
    2. `fulfill-fire-and-forget` - Marks an order as a fulfilled order (if it exists).
    3. `getOpenOrderItems-stream` - Retrieves all the products that haven't been supplied to the specified user's email.
    4. `getOrders-stream` - Retrieves all the orders registered under the given user's email (the products list is not
       retrieved).
    5. `getItemsByOrder-channel` - Retrieves all the products associated with the given orders.
    6. `cleanup-fire-and-forget` - Deletes all the data in the database.
5. The URL to the service.
6. A kill button to kill the connection to the service (mostly useful in channel transmission).
7. A send button to start the connection with the service.

### Output

![image](https://user-images.githubusercontent.com/73391391/169654622-1e09fb28-156f-4756-aa1e-f200a8869536.png)

Shows the output from the connection.

## Example usage:

![image](https://user-images.githubusercontent.com/73391391/169661307-5a4ef85d-2b7d-4713-92b9-7a53b67b734f.png)

In this above example, we send the following JSON to the service:

```json
{
  "orderId": "A11",
  "userEmail": "sagi@email.com",
  "products": [
    {
      "productId": "p1",
      "quantity": 3
    },
    {
      "productId": "p2",
      "quantity": 1
    }
  ]
}
```

This JSON is sent to route `order-req-resp` at URL `tcp://localhost:7000` with request-response transmission.