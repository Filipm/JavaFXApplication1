open(FILE, '>', 'opinions.txt' ) or die "Nie można otworzyć pliku: $!";

use utf8;

while($linia = <>) {

		if($linia =~ m/\<div\s{1,}class\=\"opis2_box\"\>.*\<\/div\>/) {
				$linia =~ s/\<div\s{1,}class\=\"opis2_box\"\>(.*)\<\/div\>/$1\n/;
				$linia =~ s/\s{2,}//g;
				print FILE "".$linia."\n\n";
		}
        
       
                
}