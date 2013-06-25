##skrypt wyciągający liste hoteli dla danej miejscowosci

##http://www.nocowanie.pl/
use utf8;
use strict;
use warnings;

use WWW::Mechanize;
my $mech = WWW::Mechanize->new();

my $site = "http://www.nocowanie.pl/noclegi/$ARGV[0]";
$mech->get( $site );
sleep 1;

my $file = "nocowanie_$ARGV[0]";
my $filehtml = "$file.txt";

$mech->save_content($filehtml);
