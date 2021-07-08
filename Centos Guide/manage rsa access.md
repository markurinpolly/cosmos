## Configuration
1. Configuration File  : vi /etc/ssh/sshd_config
2. Restart Service     : service sshd restart

<i><b>Note: </b>If firewall is running, allow the new port on through it.</i>
```
firewall-cmd --add-port=185/tcp --permanent
firewall-cmd --reload
semanage port -a -t ssh_port_t -p tcp 185
```

install semanage
source: https://www.tecmint.com/fix-semanage-command-not-found-in-centos-rhel/
```
yum provides /usr/sbin/semanage
yum install policycoreutils-python
 
# man semanage
OR
# semanage --help

```

</br>

## Standard Setting Geniora Server
- Port 185
- PermitRootLogin yes
- AllowUsers root pollymarkurin sen.geniora
- PasswordAuthentication no

</br>

source: https://www.digitalocean.com/community/tutorials/how-to-set-up-ssh-keys-on-centos7

</br>

## Step 1 :  Generate Client RSA Key Pair
```
ssh-keygen
```

## Step 2 : Copy the Public Key to CentOS Server
</br>

### 1. for root user use ssh-copy-id 

```
ssh-copy-id -p 185 -i .ssh/id_rsa_vxYat7R348 root@58.65.241.122
ssh-copy-id -p 185 -i .ssh/id_rsa_vxYat7R348 root@58.65.241.123
ssh-copy-id -p 185 -i .ssh/id_rsa_vxYat7R348 root@58.65.241.124
```

### 2. for normal user (request rsa public key then upload to server using root user)
```
# pollymarkurin
cat .ssh/id_rsa_vxYat7R348.pub | ssh -p 185 -i .ssh/id_rsa_vxYat7R348 root@58.65.241.124 "mkdir -p /home/pollymarkurin/.ssh && touch /home/pollymarkurin/.ssh/authorized_keys && chown -R pollymarkurin:pollymarkurin /home/pollymarkurin/.ssh && cat >> /home/pollymarkurin/.ssh/authorized_keys"

# sen.geniora
cat .ssh/id_rsa_sen.pub | ssh -p 185 -i .ssh/id_rsa_vxYat7R348 root@58.65.241.124 "mkdir -p /home/sen.geniora/.ssh && touch /home/sen.geniora/.ssh/authorized_keys && chown -R sen.geniora:sen.geniora /home/sen.geniora/.ssh && cat >> /home/sen.geniora/.ssh/authorized_keys"

```