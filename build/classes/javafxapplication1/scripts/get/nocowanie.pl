##skrypt wyciągający stronę po adresie
use utf8;
use strict;
use warnings;

use WWW::Mechanize;
my $mech = WWW::Mechanize->new();

my $site = "$ARGV[0]";
$mech->get( $site );
sleep 1;

my $file = "result_link";
my $filehtml = "$file.txt";

$mech->save_content($filehtml);
