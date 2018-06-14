# Customer Service Portal

Creates Accounts,contacts and ServiceRequests for a user. An employee will have details of all customers and from the details employee can create or update the service requests. one user(Customer) can have many contacts, so employee have to create a new contact if user have new contact details.


### Prerequisites

1. Install java and tomcat. make sure both versions are compaitable with each other. 

```
ex: Tomcat v9.0.8 is supported by java8 and later versions.
```
you can see those compaitable versions [here](http://tomcat.apache.org/whichversion.html).

2.  create a hibernate configuration file and place all required properties in it. 

```
    see [hibernate.cfg.xml](https://github.com/saikrishna1214/CustomerServicePortal/blob/master/src/main/resources/hibernate.cfg.xml) for reference. Replace required propeties(ex: database name and password) and their values according to your database properties.
```
    replace  CustomerServicePortal/src/main/resources/hibernate.cfg.xml with newly created file.

### Installing java

Run this Command in your terminal to install java.

```
$ sudo apt-get install oracle-java8-installer
```
replace 8 with newer versions.

### Installing Tomcat

1. Download latest version of [Apache tomcat](http://tomcat.apache.org/)

2. Unzip tomcat and install it.

3. you can start and stop the server from IDE like Eclipse or you can do it from terminal.

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

* Spring Core

* Hibernate

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

 

## Authors


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details



