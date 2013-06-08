##skrypt wyciągający liste hoteli dla danej miejscowosci

##noclegopinie
use strict;
use warnings;

use WWW::Mechanize;
my $mech = WWW::Mechanize->new();

my $site = "http://www.noclegopinie.pl/";
$mech->get( $site );
sleep 1;

$mech->submit_form(
    form_number => 0,
    fields      => {
        q       => $ARGV[0],
    }
);

my $file = "noclegopinie_$ARGV[0]";
my $filehtml = "$file.html";
my $filetxt = "$file.txt";

$mech->save_content($filehtml);

open FILE, ">$filetxt" or die $!;
print FILE $mech->text();
close FILE;
