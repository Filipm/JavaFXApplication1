##skrypt wyciągający liste hoteli dla danej miejscowosci

##http://www.booking.com/
use strict;
use warnings;

use WWW::Mechanize;
my $mech = WWW::Mechanize->new();

my $site = "http://www.booking.com/";
$mech->get( $site );
sleep 1;

$mech->form_id('frm');
$mech->tick( 'idf', true );
$mech->submit_form(
    form_id => 'frm',
    fields      => {
         ss      => $ARGV[0],
    }
);

my $file = "booking_$ARGV[0]";
my $filehtml = "$file.html";
my $filetxt = "$file.txt";

$mech->save_content($filehtml);

open FILE, ">$filetxt" or die $!;
print FILE $mech->text();
close FILE;