# KhepriConnectorJava

Khepri-Connector will let you access easily with the Khepri technology It ease the access of the ask / success 

Version 0.0.1

### Dependence: 
           
The package need to handle Json Object so you will have to import org.json 

You can fetch the org.json Jar here: 
> https://mvnrepository.com/artifact/org.json/json

In order to simplify the integration the 2 jar needed to use the KhepriApi can be fetch with:
 
> git clone https://github.com/khepri-dev/KhepriConnectorJava.git

### How to use it:

You need to reference the librairies in your project and in your assembly deployement, be sure that the jar can be found by your application
 
 
> import tech.khepri.KhepriAnswer;

> import tech.khepri.KhepriApi; 

> ...

>  // Khepri URL (sandbox environment)

> String url = "http://sb.khepri.tech";

> // Initialize the client with your  API-Key. You can find it on your Khepri account.

> String passwd = "MY_API_KEY";

> // you can create your instance with your khepri account here we select the instance 1

> Integer instanceId = 3; 

>  // init

> KhepriApi.init(url, passwd);

>  // Simple ask

>  KhepriAnswer answer = KhepriApi.ask(instanceId);

>  // Simple success

>  KhepriAnswer chkSuccess = KhepriApi.success(instanceId, answer.Solution);

> ...
