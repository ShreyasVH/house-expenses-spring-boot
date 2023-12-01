#if [[ ! $(lsof -i:5432 -t | wc -l) -gt 0 ]]; then
#	echo "Starting postgres"
#	pg_ctl start > postgres.log 2>&1 &
#fi
#
#while [[ ! $(lsof -i:5432 -t | wc -l) -gt 0 ]];
#do
#	echo "Waiting for postgres"
#done

mvn spring-boot:run