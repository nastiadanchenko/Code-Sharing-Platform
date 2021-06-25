# Code_Sharing_Platform

## API /api

### GET/code/{UUID}

Get code snippet by UUID  

Returns JSON:

    {
      "code": "class Code { ...", // Code snippet
      "date": "2021/06/05 12:01:45", // The date it was posted
      "time": 0, // Time left to view the snippet
      "views": 0 // Number of views left for the snippet
    }


### GET /code/latest

Get 10 latest unrestricted code snippets

Returns JSON array:

    [
      {
        "code": "class Code { ...",  // Code snippet
        "date": "2020/05/05 12:01:45", // The date it was posted
        "time": 0, // Time left to view the snippet (0 - unlimited)
        "views": 0 // Number of views left for the snippet (0 - unlimited)
      },
      ...
      {
        "code": "public static void ...",
        "date": "2020/05/05 11:59:01",
        "time": 0, // Time left to view the snippet (0 - unlimited)
        "views": 0 // Number of views left for the snippet (0 - unlimited)
      }
    ]

### POST /code/new

Post a code snippet

Consumes JSON:

    {
      "code": "Secret code", // Must not be null
      "time": 5000, // Time left to view the snippet 
      "views": 5 // Number of views left for the snippet
    }

Returns JSON:

    {
       "id" : "2187c46e-03ba-4b3a-828b-963466ea348c"
    }
    
## Web Interface /

### GET /code/{UUID}

Get code snippet by UUID

![Responce: ](https://ucarecdn.com/236ce1cf-524c-49be-909c-eeccee0ffa53/)

### GET /code/latest

Get 10 latest unrestricted code snippets

![Responce: ](https://ucarecdn.com/8b62a89d-3cb8-4093-a7e8-8e63cadbf1fd/)

### GET /code/new

Get the html page for updating the code snippet

![Responce: ](https://ucarecdn.com/a6ff06f0-ed0a-43d9-8893-2b0cd68b694b/)
