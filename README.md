product-review-service
======================
This is the sample REST Spring boot microservice application written to run in the Pivotal Cloud Foundry. This application uses the Spring Cloud for different services required in microservice based architecture. This application connects to the database and returns the basic product reviews.

This application uses following features / services in the Pivotal Cloud Foundry:

### Database 
This application uses the MongoDb database.

### Service Discovery 
This application uses Service Discovery service of Pivotal Cloud Foundry which internally uses the Netflix Eureka and provides the rich features for example service registration method (registrationMethod) of direct which registers the container’s IP address in the service registry instead of public route for direct service to service (container to container) communication. This feature is handy for the internal service communication instead of service call go out to the public internet and back to the service. 

### Distributed Tracing
This application uses the Spring Cloud Sleuth to enable the Zipkin distributed tracing. 

### Container to Container Networking
For service to service call, this application uses the direct container to container communication for the service calls with the Cloud Foundry. This communication is useful for service to service call inside Cloud Foundry instead of call going out through internet. 

## Running application inside Pivotal Cloud Foundry
### Service Binding
Service binding is defined in the manifest.yml file. Create the following services inside the Cloud Foundry with the name provided as below:

* Bind it to the MongoDB service either inside (`mLab`) or outside of Cloud Foundry using the service broker. Service name: `ostore-mongodb`
* `Service Registry` service name: `ostore-service-registry`
* `CloudAMQP` service name: `ostore-rabbitmq`

### Route
Service doesn’t have the public route defined as service is intended to be called by the API Gateway. To create the route, enable the route in the manifest.yml file or in the push command. 

### Push the application
After creating the services push the application using the `cf push` command. 
