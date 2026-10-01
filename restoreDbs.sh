export PATH=$HOME/programs/usql/$USQL_VERSION:$ORIGINAL_PATH
printf "Restoring for $POSTGRES_DB\n"

usql "postgres://$POSTGRES_USER:$POSTGRES_PASSWORD@$POSTGRES_IP:$POSTGRES_PORT/postgres" -c "CREATE DATABASE $POSTGRES_DB;" > /dev/null 2>&1

usql "postgres://$POSTGRES_USER:$POSTGRES_PASSWORD@$POSTGRES_IP:$POSTGRES_PORT/$POSTGRES_DB" -f /data/dbBackups/$POSTGRES_DB.sql > /dev/null 2>&1
