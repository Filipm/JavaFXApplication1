use utf8;

while($linia = <>) {

		if($linia =~ m/\<div\s{1,}class\=\"opis2_box\"\>.*\<\/div\>/) {
				$linia =~ s/\<div\s{1,}class\=\"opis2_box\"\>(.*)\<\/div\>/$1\n/;
				$linia =~ s/\s{2,}//g;
				print "Opinia: ".$linia."\n\n";
		}
        
       
                
}