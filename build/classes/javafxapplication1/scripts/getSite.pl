##skrypt wyciągający stronę po adresie do pliku txt
use utf8;
use strict;
use warnings;

use WWW::Mechanize;
my $mech = WWW::Mechanize->new();

my $site = "$ARGV[0]";
$mech->get( $site );
sleep 1;

my $file = "$ARGV[1]";
my $filetxt = "$file.txt";

$mech->save_content($filetxt);