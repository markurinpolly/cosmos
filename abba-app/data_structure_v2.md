# Data Structure (v2)

> ## **Discovers**

update note:  
1. module ***resources*** add 2 field:  
    - resources_thumbnail
    - resources_file

2. module **discovers** add new field ***socials_v2*** (list social)
3. new module **socials**

```
{
    title: [string:plain_text],
    title_img: [stirng:img_url],
    galeries: [
        image: [string:img_url], 
        image: [string:img_url], 
        image: [string:img_url], 
    ],
    short_descrition: [string:plain_text],
    description: [string:html_code],
    link: 
    {
        title: [string:plain_text],
        description: [string:plain_text], 
        color: [string:hexa_color],
    },
    socials_v2:
    [
        {
            type: [string: FACEBOOK|INSTAGRAM|YOUTUBE|TWITTER],
            name: [string:plain_text],
            link: [string:plain_text]
        },
        {
            type: [string: FACEBOOK|INSTAGRAM|YOUTUBE|TWITTER],
            name: [string:plain_text],
            link: [string:plain_text]
        }
    ],
    group: [string: GROW|NEXTGEN|SENIOR|EQUIP|WORSHIP],
	resources: [
        { 
			title: [string:plain_text], 
			description: [string:plain_text], 
            resources_thumbnail: [string:file_url],
            resources_file: [string:file_url]
		}, 
		{ 
			title: [string:plain_text], 
			description: [string:plain_text],
            resources_thumbnail: [string:file_url],
            resources_file: [string:file_url]
		}, 
    ]
}
```

> ## **Events**

update note:  
1. add field ***link_text***

```
{
    thumbnail: [string:img_url],
    title: [string],
    link_text: [string],
    date: [datetime],
    venue: [string]
    description: [string:html_code],
    galleries: [
        image: [string:img_url],
        image: [string:img_url], 
        image: [string:img_url] 
    ]
}
```


> ## **Comcells** ****NEW***

```
{
    code: [string] (required, unique),
    name: [string] (required),
    address: [string] (required),
    location: [string] (default: '),
    isactive: [enum: 0, 1] (default: 1),
    leaders: [
        member_id: [string],
        member_id: [string]
    ] (default: []),
    members: [
        member_id: [string],
        member_id: [string]
    ] (default: [])
}
```


> ## **Members** ****NEW*** 

```
{
    phone: [string] (required, unique),
    phone_verified: [number] (default: 0),
    email: [string] (required, unique),
    email_verified: [number] (default: 0),
    password: [string] (required),
    firstname: [string] (required),
    middlenane: [string] (default: ''),
    lastname: [string] (default: ''),
    lastlogin: [Date]
    deviceid: [string],
    avatar: [string] (default: ''),
    comcellid: [string] (required),
    grow_level: [enum: 1, 2, 3] (default: 0),
    isactive: [number] (default: 1)
}
```

> ## **Pending Notifications** ****NEW***

```
{
    timestamp: [string:timestamp],
    title: [string],
    message: [string],
    payload: [json],
    venue: [string]
    issend: [number, default: 0]
}
```

> ## **Socials** ****NEW***

```
{
    module: [string: CONNECTS],
    socials:
    [
        {
            type: [string: FACEBOOK|INSTAGRAM|YOUTUBE|TWITTER],
            name: [string:plain_text],
            link: [string:plain_text]
        },
        {
            type: [string: FACEBOOK|INSTAGRAM|YOUTUBE|TWITTER],
            name: [string:plain_text],
            link: [string:plain_text]
        }
    ]
}
```