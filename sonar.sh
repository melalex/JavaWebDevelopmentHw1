sudo /etc/init.d/sonar start
sudo mvn -X clean verify sonar:sonar
sudo /etc/init.d/sonar stop
