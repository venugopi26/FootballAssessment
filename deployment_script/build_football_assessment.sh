#Project directory
cd git/assessment/
#git with brachname ($1 need to pass)
git checkout $1
git stash
git pull origin $1
#mvn package
cp ./assessment-0.0.1-SNAPSHOT.jar /home/ubuntu/servicejars/FootballAssessment.jar
cd ~
sudo chmod +x servicejars/FootballAssessment.jar
# run as a system service
sudo systemctl stop FootballAssessment.service
sudo systemctl start FootballAssessment.service