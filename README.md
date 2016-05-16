# cdi-tx-sample
A sample project to illustrate the usage of @Transactional for declarative transaction management within lightweight CDI components.

#### Package structure
* `de.wern.infakt.cdi.transactions` contains the main example
* `de.wern.infakt.cdi.transactions.qualifier` contains the qualifieres used in the example
* `de.wern.infakt.cdi.transactions.stereoype` contains the stereotypes used in the example
* `de.wern.infakt.cdi.transactions.rs` contains the restful JAX-RS facade to enable remote access

#### Build and run
1. Clone the repository
2. Build the project using Maven (`mvn clean install´)
3. Get yourself a wildfly server installed and deploy the resulting war
4. Use your favorite REST client to call the webservice
