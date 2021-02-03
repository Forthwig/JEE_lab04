# Lab 04

### Prénom, Nom

* Thomas DUBOIS
* Matthieu Desmarescaux

####Login / password

* user1 / 12345
* junia / isen
* hei / isa

### Base de données supplémentaire
```

--
-- Table structure for table `ingenieur`
--

DROP TABLE IF EXISTS `ingenieur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingenieur` (
`id` bigint(20) NOT NULL,
`login` varchar(255) DEFAULT NULL,
`password` varchar(255) DEFAULT NULL,
`enable` int(1) DEFAULT NULL,
`role` varchar(255) DEFAULT NULL,
`creationDate` datetime DEFAULT NULL,
`updateDate` datetime DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingenieur`
--

LOCK TABLES `ingenieur` WRITE;
/*!40000 ALTER TABLE `ingenieur` DISABLE KEYS */;
INSERT INTO `ingenieur` VALUES (1,'junia','isen',1,'ROLE_USER','2019-09-16 10:00:38',NULL),(2,'hei','isa',1,'ROLE_USER','2019-09-16 10:00:38',NULL);
/*!40000 ALTER TABLE `ingenieur` ENABLE KEYS */;
UNLOCK TABLES;
```

## Intro
Several goals for this homework:
* It is based on the previous practice (code + database)
* You will create a MVC architecture with Spring WebMVC 
* You will write some logs

## DB 
* Reuse the schema named `junia_lab03`
* We assume that your DB credentials are `root:root`

## lab04-web
### Dependencies
Create a new Maven module called **lab04-web**. Its packaging is `war`

For this module, you have to declare, in the `pom.xml` file, the following dependencies.

|groupId   |artifactId      |  version | 
|----------|-------------|------|
| ${project.groupId} | lab04-core | ${project.version}|
| org.springframework | spring-webmvc | 5.1.9.RELEASE | 
| org.springframework | spring-context-support | 5.1.9.RELEASE |
| org.apache.velocity | velocity | 1.7 | 
| com.shield-solutions | spring-velocity-adapter | 1.0.0.RELEASE |
| org.webjars | bootstrap | 3.3.7-1 | 
| ch.qos.logback | logback-classic | 1.2.3 | 


For this module, we won't write any `web.xml`  file, because everything will be configured with Java

### junia.lab04.web.Initializer
In the `junia.lab04.web` package, create a class named `junia.lab04.web.Initializer` which extends `AbstractAnnotationConfigDispatcherServletInitializer` (_hey, that's what I call an accurate name!_)

3 methods to implement:
- `getRootConfigClasses()` which returns an array filled with `AppConfig` and `DBConfig`, theses classes are provided by the core module.
- `getServletConfigClasses()` which returns an array filled with `WebConfig`, a class you will write later.
- `getServletMappings()` which returns a String array with the following entry : `"/"`

If you wonder how to create arrays in Java, check this out : http://mathbits.com/MathBits/Java/arrays/Initialize.htm

### WebConfig
In the `junia.lab04.web.config` package, create the `WebConfig` class which implements `WebMvcConfigurer`.
- Annotate this class with `@EnableWebMVC` in order to start Spring WebMVC.
- Annotate this class with `@Configuration`
- Annotate this class with `@ComponentScan` and configure this annotation to tell Spring to check the `junia.lab04.web.controller` package.
- Override the `addResourceHandlers` with the following code : `registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");`
- Declare a bean of type `VelocityConfigurer`
  - `"/WEB-INF/velocity"` is the path you should pass to the `setResourceLoaderPath` method of that bean.
- Declare a bean of type `VelocityViewResolver`
  - `".vm"` is the suffix configured in that bean (check the available methods of that bean)
  
### CompanyController
In the `junia.lab04.web.controller` package, create the `CompanyController` class.
- Annotate this class with `@Controller`
- Inject the `CompanyService`
- Create a method `getListOfCompanies`
  - it takes a parameter of type `ModelMap`
  - it returns a String
  - its implementation is quite simple, it loads all the companies from the DB with `findAllWithProjects` method from the service, puts it in the modelMap with the key `companies` then returns `"companiesList"` (it will load the provided template in `src/main/webapp/WEB-INF/velocity/companiesList.vm`)
  - annotate this method in order to map this method with the current HTTP Request info:
    - path : `/list` 
    - verb : GET
  
Check the provided files in the `resources` directory of that practice. Copy the files where they should be ;)

## Deployment
Deploy your app in a Tomcat then test your page!

## Let's continue
### CompanyController

Create a `getForm` method which returns a `String` and takes a `ModelMap` parameter
- create a new instance of `Company` then stores it in the map.
- return `"companyForm"`
- add the correct annotation in order to map this method to the `/form` URL.

Create a `submitForm` method
- it returns a `String`
- it takes a `Company` parameter, annotated with `@ModelAttribute("company")`
- it saves the company in the DB
- it returns `"redirect:list` (remember the "redirect after submit" pattern?)
- annotate this method with `@RequestMapping` with the `/form` path and the `POST` HTTP method.

## Deployment
Deploy your app in a Tomcat then test your form.

## Let's continue
### CompanyController
Because you are a smart student, read the HTML template of the "trash" button then implement the deletion of a  company, followed by a refresh of the list.

## Logs
Inside the `src/main/resources` directory of the web module, paste the `logback.xml` file then check how the logs are formatted. Do not hesitate to play with this config to understand the concept of logging. You can also add some logging in your code.
