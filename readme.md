**CashAvailServices** is a sample project that demonstrate building micro-services with Netfix OSS. This project uses two microservices **adjusment-service** & **variance-service** to showcase: 
- Use of Slueth(generate traceId and spanId) and Zipkin(enable distributed tracing). 
	- Adding **log-trace-service** that simply enables Zipkin Server
	- Adding Slueth-Sampler to **adjustment-srevice** & **variance-service**

**Note** Refer `Master Branch` for the basic setup.   