# API CONFIGURATION ABBA APPS

wavecell
abbalovebarat.it@gmail.com  
Admin1234!

## **URL GUIDE for verioning:** <br/>
abbalovechurch.org/api/[version]/[module]_[version]

Example:  
abbalovechurch.org/api/v1/sermon  
abbalovechurch.org/api/v1/sermon_v1  
abbalovechurch.org/api/v1/sermon_v2  
abbalovechurch.org/api/v1/devotion  

___ 

## **Server**  

|key|val|note|
|---|---|---|
|url				| http://dev.abbalovebarat.org:3003			|		
|SSH Connection		| ssh polly@dev.abbalovechurch.org -p 185	|
|domain				| abbalovechurch.org						|
|public ip			| 147.139.161.252							|
|port				| 185										|
|user				| polly (sudo du)							|
|password			| rare1234! (perlu ganti!!)					|

Convert key rsa [KALO PERLU] : 
https://www.alextsang.net/articles/20180701-042600/index.html

Connect via Putty with rsa  
|key|val|note|
|---|---|---|
|Host Name			| abbalovechurch.org		|
|port				| 185						|
|Input rsa key		|Connection -> SSH -> Auth -> private key : [Browse] Masukin private key yang sudah diconvert
|ssh            | ssh -p 185 -i /Users/pollymarkurin/project/cosmos/abba-app/id_rsa_polly_vxYat7R348.txt polly@147.139.161.252
|password 			| vxYat7R348


Connect via WinSCP  
|key|val|note|
|---|---|---|
|Host Name			| abbalovechurch.org 	|
|port				| 185					|
|Input rsa key		| [Login Page] Advanced -> SSH -> Authentication -> [Browse] private key file (yang sudah diconvert)
|password 			| vxYat7R348			|

---

DEV SERVER
dev.abbalovebarat.org
admindev.abbalovebarat.org
147.139.132.199



## **GITHUB**
PRE:: sudo su

1. eval "$(ssh-agent -s)" && ssh-add /home/polly/.ssh/id_rsa

2. sudo su

3. Connect git:
	1. eval "$(ssh-agent -s)" 					--> lock agent id
	2. ssh-add /home/polly/.ssh/id_rsa 			--> open private key
	3. password			: [NEW]vxYat7R348
	4. git command		
		- Kalo aman			: git pull
		- Kalo ada conflict	: 
			- git fetch --all 
			- git reset --hard origin/master

---

## **MongoDB Connection**

**MongoDB Compass Connection via NodeJS or Application Server** 
|   |   |
|---|---| 
|ON LOCAL MACHINE 	| mongodb://rare:4bbaL0v3@147.139.161.252:2717/ 	abbalove	  
|ON Server			| mongodb://rare:4bbaL0v3@127.0.0.1:2717/abbalove  	|
|LOCALHOST			| mongodb://127.0.0.1:27017/abbalove  				|

**Config File**
```
//SERVER
{
  "APP_NAME": "api",
  "mongodb": {
    "_CON_PRO": "mongodb://rare:4bbaL0v3@localhost:2717/abbalove"
  },
  "X_API_KEY": "81b8df3e8aaa597f7b77d565ad713b3d",
  "jwt_sign_options": {
    "expiresIn": "24h",
    "algorithm": "RS256"
  },
  "jwt_verify_options": {
    "expiresIn": "24h",
    "algorithm": ["RS256"]
  },
    "onesignal": {
    "appId": "b3835da7-ac5b-4109-8727-65419b7d38eb",
    "apiKey": "NjExOTNlNDUtMDI2Zi00NDI3LWE1MDMtYTc3NGM0YjgxMTc0"
  },
  "_FILE_DIRECTORY": "/home/polly/api_attachments",
  "_PATH_TO_DOWNLOAD": "https://app.abbalovebarat.org/api/v1/files",
  "_LOGGING": true
}
```

```
//LOCAL
{
  "APP_NAME": "api",
  "mongodb": {
    "_CON_PRO": "mongodb://127.0.0.1:27017/abbalove"
  },
  "X_API_KEY": "81b8df3e8aaa597f7b77d565ad713b3d",
  "jwt_sign_options": {
    "expiresIn": "24h",
    "algorithm": "RS256"
  },
  "jwt_verify_options": {
    "expiresIn": "24h",
    "algorithm": ["RS256"]
  },
    "onesignal": {
    "appId": "b3835da7-ac5b-4109-8727-65419b7d38eb",
    "apiKey": "NjExOTNlNDUtMDI2Zi00NDI3LWE1MDMtYTc3NGM0YjgxMTc0"
  },
  "_FILE_DIRECTORY": "D:/web-attachment/files",
  "_PATH_TO_DOWNLOAD": "localhost:3000/api/v1/files",
  "_LOGGING": true
}
```

---

## **Application Server**

**NodeJS** : ExpressJS, Mongoose

No | PORTS
---|---
public				| 80
admin				| 3002
api					| 3001

ON LOCAL MACHINE 	: localhost:3000/api  
ON Server			: http://www.abbalovechurch.org:3003/api

Admin FrontEnd (Super Admin)  
username 			: admin@abbalove.com  
password			: @dm1n:Lv3+  
md5(pasword)		: 7f9c36169026788a04d0e227940acd43  

Header  
x-api-key			: token dari login  
x-api-key			: r@r3 | nantinya mau md5(r@r3+Timestamp)  
md5(r@r3) 			: 81b8df3e8aaa597f7b77d565ad713b3d  

node version on server  
node before v10.16.3  
node newest v14.4.0

v12.17.0

nvm install v12.17.0 --reinstall-packages-from=v12.17.0
Jadi setiap org yg install apps akan terima notifikasi :
1. Devotion tiap pagi pk.06.00
2. Church Online ada konten baru tiap sabtu sore/mlm
3. News feed/events ada konten baru.

http://dev.abbalovebarat.org:3003/api/v1/files/settings/thumbnail-23413180-a6e8-11ea-9df7-25363117e894.jpeg


grep 'Running task every 6AM & 17PM:' /root/.pm2/logs/server-out.log

propinsi.json
kabupaten/[id propinsi].json
kecamatan/[id kabupaten].json
kelurahan/[id kecamatan].json

bind *:443 ssl crt /etc/ssl/certs/star_abbalovebarat_org.pem

bind *:443 ssl crt /etc/ssl/certs/2023/star_abbalovebarat_org.pem