# Connect Module

> ### **Connect**
```
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
```

### **Form description**

| Type | Description|
|-------------------|------------------------------------------|
|NEW				|Form 1 -- I am new to Christianity|
|COMMIT				|Form 2 -- I am commiting my life to Christ|
|My Decission		|Pakai kolom note !|
|BAPTIZED			|Form 3 -- I want to be Baptized|
|My Commitment		|Pakai kolom note !|
|SERVE				|Form 4 -- I am ready to serve|
|Music Instrument 	|Pakai kolom note !|
|PCR				|Form 5 -- I have a prayer/counseling request|
|Message 			|Pakai kolom note !|
|status 			|Tidak perlu diisi dari client(iOS, android), defaultnya : NEW

