# Introduction #

In web applications usually data come from services. Testing front end with actual services are some time not possible because they are not ready. Or one don't want to test with them because each time page is refreshed some time is taken to fetch the data from development servers which are always very slow. This API will allow one to test the front end by generating TO/VO with dummy data. One just have to pass the POJO name of the class and it will return fully populated object. If the POJO has it self has another POJO declared in it as field then it will also create that and populate it. And so on.

Supported field type for POJO are java native types and List. Maps, Set fields are ignored for now. I will be adding support for them soon.

This package contains the API source: org\opensrc\utility\dummydata
This package contains how to use this API:org\test\dummydata

# TODO #
<ol>
<li> Detail help </li>
<li> Add support for Map and Set </li>
<li> Remove System.out.println and use some Logging frame work </li>
</ol>