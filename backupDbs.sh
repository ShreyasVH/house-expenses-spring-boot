ORIGINAL_PATH=$PATH

POSTGRES_SPRINGBOOT_SOURCE_NAME=$POSTGRES_DB
rm $HOME/dbBackups/$POSTGRES_SPRINGBOOT_SOURCE_NAME.sql

POSTGRES_SPRINGBOOT_SOURCE_VERSION=$POSTGRES_VERSION
POSTGRES_SPRINGBOOT_SOURCE_PORT=$(grep 'port = ' $HOME/programs/postgres/$POSTGRES_VERSION/data/postgresql.conf | awk '{print $3}')
POSTGRES_SPRINGBOOT_SOURCE_PASSWORD=password
POSTGRES_SPRINGBOOT_SOURCE_USER=shreyas
printf "Creating backup for $POSTGRES_SPRINGBOOT_SOURCE_NAME\n"
export PATH=$HOME/programs/postgres/$POSTGRES_SPRINGBOOT_SOURCE_VERSION/bin:$ORIGINAL_PATH
PGPASSWORD=$POSTGRES_SPRINGBOOT_SOURCE_PASSWORD pg_dump -p $POSTGRES_SPRINGBOOT_SOURCE_PORT -U $POSTGRES_SPRINGBOOT_SOURCE_USER -d $POSTGRES_SPRINGBOOT_SOURCE_NAME --inserts -f $HOME/dbBackups/$POSTGRES_SPRINGBOOT_SOURCE_NAME.sql
