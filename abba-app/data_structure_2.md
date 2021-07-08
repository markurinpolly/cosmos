# UPDATE NOTES 09/06/2020 -- 01

## Discover Module

### Discover
{
    title: [string:plain_text],
    title_img: [stirng:img_url],
    galeries: [
        { image: [string:img_url] }, 
        { image: [string:img_url] }, 
        { image: [string:img_url] }, 
    ],
    short_descrition: [string:plain_text], ﻿
    description: [string:html_code],
    link: 
    {
        title: [string:plain_text],
        description: [string:plain_text], 
        color: [string:hexa_color],
    },
    socials:
    {
        facebook: [string:plain_text],
        instagram: [string:plain_text],
        youtube: [string:plain_text],
    },
    group: [string: GROW|NEXTGEN|SENIOR|EQUIP|WORSHIP],
	resources: [
        { 
			title: [string:plain_text], 
			description: [string:plain_text] 
		}, 
		{ 
			title: [string:plain_text], 
			description: [string:plain_text] 
		}, 
    ],
	resources_thumbnail: [
        { image: [string:img_url] }, 
        { image: [string:img_url] }, 
    ],
	resources_file: [
        { image: [string:file_url] }, 
        { image: [string:file_url] }, 
    ]
}

###  Location Module
Location
{
    title: [string:plain_text], 
    address1: [string:plain_text], 
    address2: [string:plain_text], 
    phone: [string:plain_text],
	wa: [string:plain_text],	
    description: [string:html_code],
    map: [string: lng,lat],
	galeries: [
        { image: [string:img_url] }, 
        { image: [string:img_url] }, 
        { image: [string:img_url] }, 
    ]
}
### Online
{
	title: [string:plain_text],
	date: [datetime:format(yyyy-MM-dd)],
    link: [string:youtube_url], 
    description: [string:html_code],
	thumbnail: [string:img_url]
}

###  Giving Module
Giving
{
    background: [string:img_url],
    description: [string:html_code],
}

###  General Info
4 table di mongo, yaitu:
1. Discover
2. Location
3. Online
4. Giving

Semua pasti butuh CRUD
Kebutuhan front end ada 5 tambahan, yaitu:
1. Grow 		// METHOD:[GET ONLY] => Array		params - ?index=GROW
2. NextGen 		// METHOD:[GET ONLY] => Array		params - ?index=NEXTGEN
3. Senior 		// METHOD:[GET ONLY] => 1 object	params - ?index=SENIOR 
4. Equip 		// METHOD:[GET ONLY] => Array		params - ?index=EQUIP
5. Worship 		// METHOD:[GET ONLY] => 1 object	params - ?index=WORSHIP