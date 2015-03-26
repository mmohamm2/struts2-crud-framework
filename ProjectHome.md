# Description #

Provides Struts 2 developers with easy to use framework for building CRUD (Create, read, update, delete) applications using conventions over configuration. Includes several utility classes to facilitate quick Struts 2 app development.

# Usage #

**Maven (recommended)** - Coordinates are located at oss.sonatype.org. You may need to add the Releases repository here https://oss.sonatype.org/content/repositories/releases/.
```
<dependency>
  <groupId>com.dakuupa</groupId>
  <artifactId>struts2-crud-framework</artifactId>
  <version>1.0</version>
</dependency>
```

**Download** - Download the JAR and add it to your web project's libraries.

# Example #

Check the downloads section for an example application.
The table script for the example is:
```
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `last_update` datetime NOT NULL,
  PRIMARY KEY (`id`)
 ) 
```
**Persistence** - Configure the persistence.xml to your database.