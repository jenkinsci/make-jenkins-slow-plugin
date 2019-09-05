# Make Jenkins Slow Plugin

Copyright &copy; CloudBees, Inc.
Licensed under [MIT License].
 
## About

This plugin artificially slows down Jenkins at startup when it is loading its configuration.
Slowing Jenkins down can make it easier to find race conditions in plugins / initialisation phases.
It provides a few Extensions that can be used in the global configuration that take an delay option that will block 
Jenkins when its global configuration is loaded from disk.

### Extension points
  
* Cloud
* MarkupFormatter
* ProjectNamingStrategy

## Wiki and Info

As this is not a user facing plugin but is designed for engineers, there is no documentation other than the source code.

[MIT License]: ./LICENSE.md

