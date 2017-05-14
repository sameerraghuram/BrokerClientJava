# Messsage Broker

## Introduction
This is a basic implementation of the Advanced Message Queueing Protocol (AMQP) popularized by projects 
like RabbitMQ. 

A message exchange system provides an asynchronous system of sending and receiving messages, so app 
developers don't have to write verbose socket code in order to communicate between different services
or parts of an application. 

### A few terms :
* Publisher : A process publishing a message to a queue.
* Subscriber : A process subscribing to messages from a queue.
* Broker :  A server that receives all messages from the processes in the system.
* Exchange : A collection of message queues present at the Broker. There are different types of exchanges:
  * Direct Exchange:  Messages sent only to queues with matching routing key's. 
  * Fanout Exchange: Messages sent to all queues present on the exchange.
* Message Queue : Associated with an exchange by a routing key. A simple data structure to hold messages.

### Visual Overview of the architecture of an AMQP system:
<img src="https://github.com/sameerraghuram/MessageBroker/blob/master/img/2016-09-27%2023_12_38-Photos.png"> </img>

### Examples

First we must run an instance of the broker on our system. We can do that simply by:
```bash 
python3 broker.py
```
Next, in order to create message queues and subscribe to them, we use the connection module
functions. 
```Python
import connection
import sys

if __name__ == '__main__':

    #To create a connection, pass in the address of the
    # server where the broker instance is running.
    conn = connection.Connection('example.com')

    #Create an exchange with the name 'topic' and of type direct or fanout.
    conn.create_exchange(name='topic', type='DIRECT')

    #Create a message queue which resides on
    conn.create_queue(name='topic1',exchane_name='topic')

    try:
        while True:
            print("Type the message you want to send to queue1")
            msg = input()
            conn.publish(msg, name='topic1', exchange='topic')
    except KeyboardInterrupt:
        print("Closing...")
        sys.exit(2)
 ```
 Here we use the connection module to subscribe to a queue residing on an exchange.

```Python
import connection

def print_message(msg):
    print(msg)
    print('\n\n\n')

if __name__ == '__main__':

    conn = connection.Connection('example.com')
    #Subscribe to the default queue by not providing details
    #like queue name
    conn.subscribe(callback=print_message)
```

## Steps to deploy
To deploy this broker, perform the following steps in the project folder
1. Create a virtual environment
```
virtualenv venv
```

2. Activate the virtual environment
```
source venv/bin/activate
```

3. Install Gevent
```
pip install gevent
```



