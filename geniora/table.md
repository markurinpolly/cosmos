> ##  TODO

|no|todo|check|
|---:|---|:---:|
|1|showcase hanya muncul pertama kali, tambah column showcase di m_user|✅|
|2|update showcase = 0, setelah update 1.2.4 naik ke playstore||
|3|tanggal ulang tahun register tidak boleh melebihi hari ini||
|4|ubah password admin panel||
|5|Admin carousel||
|6|api carousel @login|✅|
|7|consume api carousel||
|8|api inbox|✅|
|9|consume api inbox||

<br/><br/>

> ##  t_notification

|column|value|description|
|---|---|---|
|_id||uuid
|username||
|date|default: now()| 
|type|enum:[ info, inbox ]| info: cannot open message
||| inbox: can open message
|title|String|
|body|String|
|url|Link (String)|content message dari dari web, open pakai webview
|content|html (String)|
|action|enum:[HOME, SUBSCRIBE, VIDEO, QUIZ, BANKQUIZ, BOOK]|
|id|String|untuk module, bisa input id dari module

<br/><br/>

> ## m_carousell
|column|value|description|
|---|---|---|
|page|enum:[HOME]|
|no|Number|
|image_code|Link (String)|
|redirect_url|Link (String)|choose one either redirect_url or activity
|activity|enum:[BOL,SUBSCRIBE,PURCHASE,CONTACTUS,CHANGEPROFILE,FILE,VIDEO,BOOK,QUIZ,BANKQUIZ,INBOX,HOME]|
|id|String|
|description|String|
