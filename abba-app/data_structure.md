#	UPDATE NOTES 22/06/2020 -- 01

1.	add field[wa, galleries] module locations
2.	add parameter "page" module devotions
3.	add parameter "filter" module devotions 
	ex: {"verse": "Mazmur"} -- verse like '%Mazmur%' (case insensitive)
4.	New Module "Roles"

## 	Module Structure:

Settings
{
    thumbnail: [string:img_url], 
	short_description: [string:plain_text],
    link_text: [string: WATCH NOW | READ NOW | VIEW MORE | FIND OUT MORE ],
    type: [string: DEVOTION|DOWNLOAD],
}
News
{
    thumbnail: [string:img_url],
    title: [string],
    date: [datetime],
    short_description: [string:plain_text],
    description: [string:html_code],
    galleries: [
        { image: [string:img_url] }, 
        { image: [string:img_url] }, 
        { image: [string:img_url] }, 
    ]
}
Sermons
{
    thumbnail: [string:img_url],
    title: [string],
    date: [date],
    link: [string: url_youtube],
    description: [string:plain_text],
    highlight: [bool:false as default],
}
Resources -- METHOD:[GET ONLY]
[
	thumbnail: [string:img_url],
	link_text: [string],
	type: [string],
	menu: [string],
	description: [string],
]
Devotions
{
    title: [string],
    date: [date],
    verse: [string: plain_text],
    reflection: [string:html_code],
    sharing: [string:html_code],
}
Downloads
{
    thumbnail: [string:img_url],
    title: [string],
    description: [string: verse],
    link: [string:file_url],
}
Events
{
    thumbnail: [string:img_url],
    title: [string],
    date: [datetime],
    venue: [string]
    description: [string:html_code],
    galleries: [
        { image: [string:img_url] }, 
        { image: [string:img_url] }, 
        { image: [string:img_url] }, 
    ]
}
Discover
{
    title: [string:plain_text],
    title_img: [stirng:img_url],
    galleries: [
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
Location
{
    title: [string:plain_text], 
    address1: [string:plain_text], 
    address2: [string:plain_text], 
    phone: [string:plain_text],
	wa: [string:plain_text],	
    description: [string:html_code],
    map: [string: lat,lng],
	galleries: [
        { image: [string:img_url] }, 
        { image: [string:img_url] }, 
        { image: [string:img_url] }, 
    ]
}
Online
{
	title: [string:plain_text],
	date: [datetime:format(yyyy-MM-dd)],
    link: [string:youtube_url], 
    description: [string:html_code],
	thumbnail: [string:img_url],
	notification : {
		title : "",
		message : "",
	},
	prenotification : {
		title : "",
		message : "",
	}
}
Giving
{
    background: [string:img_url],
    description: [string:html_code],
}
Connect
{
	status : [string: NEW|READ|PROCEED],
	form : [string: NEW|COMMIT|BAPTIZED|SERVE|PCR],
    full_name: [string:plain_text],
    phone: [string:plain_text],
	gender: [string: M|F],
	pob: [string:plain_text],
	dob: [string:yyyy-mm-dd],
	address: [string:plain_text],
	pcr_type: [string: Prayer|Counseling],
	note: [string:plain_text],
	service: [string: Usher|Event management|Multimedia operator|Lightning operator|Cameraman|Worship leader|Singer|Music]
}
Roles
{
    name: [string:plain_text],
    access: [
		{
			module: [string:plain_text],
			can_create: [number:0|1, default:0],
			can_read: [number:0|1, default:0],
			can_ update: [number:0|1, default:0],
			can_delete: [number:0|1, default:0],
		},
		{
			module: [string:plain_text],
			can_create: [number:0|1, default:0],
			can_read: [number:0|1, default:0],
			can_ update: [number:0|1, default:0],
			can_delete: [number:0|1, default:0],
		}
    ]
}