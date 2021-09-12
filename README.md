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

#Input JSON Request

{
    "userAgent":"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36"
}

#Output JSON Response
{
    "os": "OS X 10.10 Yosemite",
    "osVersion": "10.10.5",
    "browser": "Chrome",
    "browserVersion": "48.0.2564.116",
    "device": "Personal computer",
    "deviceType": "PERSONAL_COMPUTER"
}


http://localhost:9999/api/useragent/v3/info

HTTP Method : POST

#Input JSON Request

{
    "userAgent":"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36"
}

#Output JSON Response

{
    "os": "Mac OS X",
    "osVersion": "10.10.5",
    "browser": "Chrome",
    "browserVersion": "48.0.2564.116",
    "device": "Desktop",
    "deviceType": "Apple Macintosh"
}

## UserAgentAnalyzer Output Data
DeviceClass                           : 'Desktop'                  #       20
      DeviceName                            : 'Apple Macintosh'          #       20
      DeviceBrand                           : 'Apple'                    #       20
      DeviceCpu                             : 'Intel'                    #      105
      DeviceCpuBits                         : '32'                       #      105
      OperatingSystemClass                  : 'Desktop'                  #       20
      OperatingSystemName                   : 'Mac OS X'                 #       20
      OperatingSystemVersion                : '10.10.5'                  #       20
      OperatingSystemVersionMajor           : '10'                       #       20
      OperatingSystemNameVersion            : 'Mac OS X 10.10.5'         #       20
      OperatingSystemNameVersionMajor       : 'Mac OS X 10'              #       20
      LayoutEngineClass                     : 'Browser'                  #      999
      LayoutEngineName                      : 'Blink'                    #      999
      LayoutEngineVersion                   : '48.0'                     #      999
      LayoutEngineVersionMajor              : '48'                       #      999
      LayoutEngineNameVersion               : 'Blink 48.0'               #      999
      LayoutEngineNameVersionMajor          : 'Blink 48'                 #      999
      AgentClass                            : 'Browser'                  #     2014
      AgentName                             : 'Chrome'                   #     2014
      AgentVersion                          : '48.0.2564.116'            #     2014
      AgentVersionMajor                     : '48'                       #     2014
      AgentNameVersion                      : 'Chrome 48.0.2564.116'     #     2014
      AgentNameVersionMajor                 : 'Chrome 48'                #     2014
