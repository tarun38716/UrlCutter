#  Assignment-springboot for InfoBip

## Application
URL Cutter is an application to shorten the long URLs. The following are the features-

- Account Service -
This Rest endpoint is used to create an account and it generates the random 8 digit Alphanumeric password, which can be used for authentication to use other services.
URL- /account
Sample request JSON - { 'AccountId' : 'myAccountId'}
Sample response JSON - {success: 'true', description: 'Your account is opened', password: 'xC345Fc0'}

- Registration Service
This Rest endpoint is to register the Long URL with an application and it generates  its shortened URL which can be used to redirect to the Long URL. This has basic authentication. account ID and password is needed to access this end point
URL- /register
Sample request JSON -
{
url:'http://stackoverflow.com/questions/1567929/website-safe-data-access-architecture-question?rq=1',
redirectType : 301
}
Sample response JSON - { shortUrl: '<host>:<port>/redirect/xYswlE'}

- Statistics Service
This Rest endpoint is to provide statistics for a particular account.This has basic authentication. account ID and password is needed to access this end point.
URL- /statistic/{AccountId}
Sample request JSON - N/A
Sample response JSON -
{
'http://myweb.com/someverylongurl/thensomedirectory/: 10,
'http://myweb.com/someverylongurl2/thensomedirectory2/: 4,
'http://myweb.com/someverylongurl3/thensomedirectory3/: 91,
}

- Redirect Service
This Rest end point is the generated SHORT URL in Registration Service. These short URLS can be used to access the real URL.

## References
- Understanding about problem algorithm   --> http://www.vikasing.com/2010/11/simple-url-shortening-algorithm-in-java.html


## Author
Tarun Agarwal 
tatarunaggarwal@gmail.com

Demo Setup:
------------------------------
1. Checkout project from https://github.com/tarun38716/UrlCutter.git
2. Maven build application - mvn clean install.
3. Run java -jar urlcutter-0.0.1-SNAPSHOT.jar
4. API can be accessed using any REST Client
