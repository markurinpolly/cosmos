# Postgres Backup

### source: https://stackoverflow.com/questions/5799690/backing-up-a-db-with-git-a-good-idea/12516565

<br>

## Backup a Single Database

This dumps a specific database.

backup.sh

```
pg_dump dbname -U backup > backup.sql
git add .
git commit -m "backup"
git push origin master
```

<i><b>Note:</b> you probably don't want to use any file splitting options for the DB dump since any insertion/deletion will cause a 'domino' effect and change all files creating more deltas/changes in git.</i>

<br>

## Backup all Databases on this machine

This script will dump the entire database cluster (all databases):

```
pg_dumpall -U backup > backup.sql
git add .
git commit -m "backup"
git push origin master
```

<i><b>Note:</b> you probably don't want to use any file splitting options for the DB dump since any insertion/deletion will cause a 'domino' effect and change all files creating more deltas/changes in git.</i>

<br>

## Schedule it to Run

The final step is to add this to a cron job. So, 'crontab -e' and then add something like the following (runs every day at midnight)

```
# m h  dom mon dow   command
# run postgres backup to git
0 0 * * * /home/ubuntu/backupdbtogit/backup.sh
```

<br>

## Restore

If you need to restore the database, you'll checkout the version you want to restore then pass to pg. (more details on that here http://www.postgresql.org/docs/8.1/static/backup.html#BACKUP-DUMP-RESTORE )

for a single database:

```
psql dbname < infile 
```

for the entire cluster

```
psql -f infile postgres
```

<i>None of this was particularly complicated, but it's always tedious looking up all the parts.</i>

<br>

## Crashing on Server with limited RAM

I experienced an issue with git failing on a push. This was due to git using a lot of memory - several commits had backed up. I resolved the failure by mounting the server git repo on my local machine (which has plenty of RAM). I mounted the server disk using sshfs and then committed from my workstation machine. After I did this, the low memory server resumed commits without a problem.

A better alternative is to limit the memory usage of g

```
git config --global pack.windowMemory "100m"
git config --global pack.packSizeLimit "100m"
git config --global pack.threads "1"
```

<i><b>Note:</b> I have not tried setting a memory limit yet, since I have not had the push failure problem again.</i>