**notifymeMailApi**


> /notifymeMailApi/src/main/java/com/javamail/notifymeMailApi contains the source codes for the project. 

The above path have:
1) Mailer - Function implementation for push notification using java mail API.
2) Notify - Main class for executing the project.
3) RestAPi - RestController functions and their API's.


**RestApi: **

1) Push notification for message only:
    (POST) url:'/sendmail/v1/message'
	*Expected parameters:  *
	"recipient": String recipient,
       	"sub": String subject,
	"msg": String msg,
       	"name": String name
    
    
2) Push notification using HTML content:
    (POST) url: '/sendmail/v1/html'
    *Expected parameters:  *
       "recipient": String recipient,
       "sub": String subject,
	"msg": String msg,
       "name": String name,
	"url": String url

3) Push notification with message and file
	(POST) url: '/sendmail/v1/message/file'
    	*Expected parameters:  *
       "recipient": String recipient,
       "sub": String subject,
       "html": String html,
       "name": String name
 
4) Push notification for file only
    (POST) url: '/sendmail/v1/file'
	"recipient": String recipient,
      	"sub": String subject,
       	"name": String name,
	"url": String url
