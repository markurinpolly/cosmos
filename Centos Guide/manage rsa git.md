## Syntax

```
# vxYat7R348

eval "$(ssh-agent -s)" && ssh-add /home/pollymarkurin/.ssh/id_ed25519
```

</br>

source: https://www.digitalocean.com/community/tutorials/how-to-set-up-ssh-keys-on-centos7

</br>

## 1. Checking for existing SSH keys

```
$ ls -al ~/.ssh
# Lists the files in your .ssh directory, if they exist
```

<br>

## 2. Generating a new SSH key and adding it to the ssh-agent

```
$ ssh-keygen -t ed25519 -C "your_email@example.com"
```

<i>Note: If you are using a legacy system that doesn't support the Ed25519 algorithm, use:</i>

```
$ ssh-keygen -t rsa -b 4096 -C "your_email@example.com"
```

<br>

## 3. Create .ssh/config

```
$ touch ~/.ssh/config
```

```
Host *
  AddKeysToAgent yes
  UseKeychain yes
  IdentityFile ~/.ssh/id_ed25519
```

<i>Note: If you see an error like this

/Users/USER/.ssh/config: line 16: Bad configuration option: usekeychain</i>

```
Host *
  AddKeysToAgent yes
  IgnoreUnknown UseKeychain
  IdentityFile ~/.ssh/id_ed25519
```

```
chmod 600 ~/.ssh/config
```

<br>

## 4. add ssh-agent

```
1. eval "$(ssh-agent -s)" && ssh-add /home/pollymarkurin/.ssh/id_ed25519
```

<br>

## 5. add SSH key to your GitHub account

```
$ pbcopy < ~/.ssh/id_ed25519.pub
# Copies the contents of the id_ed25519.pub file to your clipboard
# Then add to https://github.com/settings/keys -- New SSH keys
```

<br>

## 6. Testing your SSH connection
```
$ ssh -T git@github.com
```

<br>

## 7. Adding or changing a passphrase

```
$ ssh-keygen -p -f ~/.ssh/id_ed25519
> Enter old passphrase: [Type old passphrase]
> Key has comment 'your_email@example.com'
> Enter new passphrase (empty for no passphrase): [Type new passphrase]
> Enter same passphrase again: [Repeat the new passphrase]
> Your identification has been saved with the new passphrase.
```