open(FILE, '>', 'result.txt' ) or die "Nie można otworzyć pliku: $!";

while($linia = <>) {

		if($linia =~ m/\<h2\>.*\<\/h2\>/) {
			
			$linia =~ s/\<\/{0,}h2\>//g;
			$linia =~ s/\<a\s{1,}href\=\"(.*)"\s{1,}/$1/g;
			$linia = $linia."\n";
			$linia =~ s/\<\/a\>//g;
			$linia =~ s/title\=\"(.*)\"/\n/g;
			$linia =~ s/\&quot\;//g;
			$linia =~ s/\>//g;
			print $linia;
			print FILE "$linia "."\n"; 
		}
}