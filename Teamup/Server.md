GenHA-123 (Centos 7.6.1810)
vps2
58.65.241.123
Model Name : Intel(R) Xeon(R) CPU E5-2650 v2 @ 2.60GHz
HD : 500GB
CPU : 2 (1 x 2 X 1)
RAM : 16GB
user : root
password : p@ssGeniora:D2kali
Thread(s) per core : 1
Core(s) per socket : 2
Socket(s) : 1
root disabled: yes

p@ssGeniora:D2kali

-------------------------------------------------------
MongoDB
user    : "mdbadminTeamUp",
pwd     : "p4ssMongoDB123",
database: teamup
port    : 27017 [Default: 27017]

connection:
mongodb://mdbadminTeamUp:p4ssMongoDB123@58.65.241.123:27017/teamup

syntax: mongo

db.createUser({ user: "mdbadminTeamUp" , pwd: "p4ssMongoDB123", roles: ["userAdminAnyDatabase", "dbAdminAnyDatabase", "readWriteAnyDatabase"]})

db.dropUser("mdbadminTeamUp", {w: "majority", wtimeout: 4000})

db.auth('mdbadminTeamUp', 'p4ssMongoDB123')

turn on authentication:
sudo nano /lib/systemd/system/mongod.service

configuration:
sudo nano /etc/mongod.conf

restart mongodb:
sudo systemctl daemon-reload
sudo systemctl restart mongod

check service mongodb:
sudo systemctl status mongod

open port: 
(semanage instalation guide)
sudo semanage port -a -t mongod_port_t -p tcp 27017
sudo firewall-cmd --permanent --add-port=27017/tcp
sudo firewall-cmd --reload

others:
sudo lsof -i | grep mongo

Instalation Guide: https://phoenixnap.com/kb/install-mongodb-on-centos-8

-------------------------------------------------------

https://www.a2hosting.com/kb/getting-started-guide/accessing-your-account/disabling-ssh-logins-for-root

port 185

vi /etc/ssh/sshd_config
service sshd restart

ssh user
pollymarkurin
vxYat7R348

ssh-copy-id root@58.65.241.123

ssh-copy-id -p 185 -i /Users/pollymarkurin/.ssh/id_rsa_vxYat7R348 root@58.65.241.123

ssh -p 185 -i /Users/pollymarkurin/.ssh/id_rsa_vxYat7R348 pollymarkurin@58.65.241.123

ssh -p 185 pollymarkurin@58.65.241.123

Connection + GITHUB

p@ssGeniora:D2kali

eval "$(ssh-agent -s)" && ssh-add /root/.ssh/pollymarkurin

markurin.polly@gmail.com
Ngeeeng3214626

port ssh: 185
firewall-cmd --add-port=185/tcp --permanent
firewall-cmd --reload
semanage port -a -t ssh_port_t -p tcp 185

chown -R pollymarkurin:pollymarkurin ~/.ssh