cat /config/id_bionic.pub >> .ssh/authorized_keys
apt-get update && apt-get install -y mysql-server-5.7
cat /config/mysqld.cnf > /etc/mysql/mysql.conf.d/mysqld.cnf
service mysql restart
mysql -e "create user 'phpuser'@'%' identified by 'pass';"