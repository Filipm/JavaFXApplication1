open(FILE, '>', 'result2.txt' ) or die "Nie można otworzyć pliku: $!";

while($linia = <>) {
        
        if($linia =~ m/\<span\sclass="rating"\s\>.*\<\/span\>/) {
               $linia =~ s/title=".*"\>//;
                $linia =~ s/\<\/a\>//;
				$linia =~ s/\<a\s{1,}href="(.*)"/$1\n/;
          
			   
			   $linia =~ s/\<span\s{1,}\>([0123456789]+)(\.[0123456789]+)*\<\/span\>/$1$2/g;
			   $linia =~ s/\<\/span>//;
			   $linia =~ s/\<span\s{1,}class="rating"\s{1,}\>//;
                %tab=("ocena" => $linia);
                print FILE "Opinie: ".$tab{"ocena"}."\n";
        }
       
		if($linia =~ m/\"64.50\s{1}PLN\s{1}\"/) {
			print FILE "cena ".$linia ;
		}
                
}