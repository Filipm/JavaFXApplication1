#!/usr/bin/perl

# PERL MODULES
use DBI;
use DBD::mysql;

# MYSQL CONFIG VARIABLES
$host = "localhost";
$database = "hotels";
$tablename = "hotels";
$user = "root";
$pw = "root";

#DATA SOURCE NAME
$dsn = "dbi:mysql:$database:localhost:3306";

# PERL DBI CONNECT (RENAMED HANDLE)
$connect = DBI->connect($dsn, $user, $pw) or die "Unable to connect: $DBI::errstr\n";