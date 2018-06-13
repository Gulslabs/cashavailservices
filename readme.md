**CashAvailServices** is a sample project that demonstrate building micro-services with Netfix OSS. This project uses two microservices **adjusment-service** & **variance-service** to showcase: 

- Use of Spring Cloud Eureka (**discovery-service**) 
- Use of Spring Cloud Ribbon and Fiegn to locate  **variance-service** from **adjustment-service**
- Use of Spring Cloud Zuul to build a gate way(**gateway-service**)for RESTP API calls onto **variance-service** &  **adjustment-service**

