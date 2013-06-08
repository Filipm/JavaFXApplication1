##skrypt wyciągający liste hoteli dla danej miejscowosci

##http://www.nocowanie.pl/
use strict;
use warnings;

use WWW::Mechanize;
my $mech = WWW::Mechanize->new();

my $site = "http://www.nocowanie.pl/noclegi/$ARGV[0]";
$mech->get( $site );
sleep 1;

my $file = "nocowanie_$ARGV[0]";
my $filehtml = "$file.html";
my $filetxt = "$file.txt";

$mech->save_content($filehtml);

open FILE, ">$filetxt" or die $!;
print FILE $mech->text();
close FILE;
