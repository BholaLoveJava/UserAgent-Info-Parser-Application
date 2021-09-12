# UserAgent-Info-Parser-Application
UserAgent-Info-Parser

http://localhost:9999/api/useragent/v1/info

HTTP Method : POST

Input JSON Request
{
    "userAgent":"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36"
}

Output JSON Response
{
    "os": "Mac OS X",
    "osVersion": "Mac OS X",
    "browser": "Chrome 48",
    "browserVersion": "48.0.2564.116",
    "device": "Computer",
    "deviceType": "Desktop"
}


http://localhost:9999/api/useragent/v2/info

HTTP Method : POST

{
    "userAgent":"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36"
}

Output JSON Response
{
    "os": "OS X 10.10 Yosemite",
    "osVersion": "10.10.5",
    "browser": "Chrome",
    "browserVersion": "48.0.2564.116",
    "device": "Personal computer",
    "deviceType": "PERSONAL_COMPUTER"
}
