comcell_members

|comcellid|memberid|
|---|---|
|com-1|polly|

comcell_leader

|comcellid|leader_id|
|---|---|
|com-1|polly|

area_leader

|comcellid|area_leader_id|
|---|---|
|com-1|polly|

+62 langsung kosongin

kode unik (:tar tanya format nya apa pas kemaren meeting)
kode komsel (tidak bisa diisi)

TODO:
1. member register api (pks /non)
2. member login
3. edit member api

> ## 1. POST members
1. post members
2. insert comcell_members

> ## 2. PUT members
1. delete comcell_members WHERE memberid
2. put members
3. insert comcell_members

> ## 3. DELETE:ID members
1. delete members:id
2. delete comcell_members WHERE memberid

> ## 4. DELETE members
1. delete members
2. delete comcell_members
2. delete area_members

> ## 1. GET members
1. virtual "comcells"


|id|member|comcell|isleader|
|---|---|---|---|
|5f5eed27f9943505dfd90bda|alpha|CM01|1|
|5f5eed27f9943505dfd90bda|beta|CM02|1|
|5f5eeda7f9943505dfd90be4|charlie|CM03|1|

|5f5eedb6f9943505dfd90be8|delta|CM01|0|
|5f5eedc4f9943505dfd90bec|echo|CM01|0|
|5f5eedcff9943505dfd90bee|fanta|CM02|0|
|5f5eede2f9943505dfd90bf0|garry|CM02|0|
|5f5eee09f9943505dfd90bf2|hotel|CM01|0|



{
    "code": "CM04",
    "name": "CM04",
    "address": "address four",
    "leaders": [
        "5f3a94cb5ef85f24c5addfe9",
    ]
}


{
    "code": "CM01",
    "name": "COM01",
    "address": "address one",
    "leaders": [
        "5f3a930d2ff0a124397b91a5"
    ],
    "members": [
        "5f3a930d2ff0a124397b91a5",
        "5f3a931b2ff0a124397b91a7",
        "5f3a93282ff0a124397b91a9",
        "5f3a93322ff0a124397b91ab",
        "5f3a94cb5ef85f24c5addfe9",
        "5f3a95fe6d134525390b0f4d",
        "5f3a96a55b02272549e88628"
    ]
}

1VMY
32D6
FUN4
ZS7Q

TODO:
1. Buat template excel untuk:
    - upload master comcells
    - upload member (pks)