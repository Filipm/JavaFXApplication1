use strict;
use warnings;

use WWW::Mechanize;
my $mech = WWW::Mechanize->new();

print "$ARGV[0]\n";

my $site = "http://www.noclegopinie.pl/";
$mech->get( $site );
sleep 1; ## be nice

$mech->submit_form(
    form_number => 0,
    fields      => {
        q       => $ARGV[0],
    }
);

print $mech->content;