# akme
This is repository for testing and practising different aspects of Java Spring framework. As of this moment this repository consist of following technology modules:
## caching
In this part I have three different Spring cache implementantions done by:
- SimpleCacheManager (basic Spring cache)
- Ehcache 2.x
- Caffeine

One example of @cachable method works in interface and one is done at method in normal bean with addition of simple usage of SpEL.
To work, app must be started with one of spring profiles: basic, eh, caffeine.

##database(ing)

In this module I practise various jpa and jdbc techniques - in progress. 