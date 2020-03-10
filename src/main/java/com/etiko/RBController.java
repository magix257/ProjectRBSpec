package com.etiko;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RBController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
		
	}
	
	
	@RequestMapping("check")
	public String check(@RequestParam File file, Model m) throws IOException {
		
		//String filePath = file.getPath();
	
		
		String[] specyfikacjaA = {"D0025873", "D0025876", "D8324258", "D8114311", "D0327096", 
								 "D0211314", "D8114310", "D8324257", "0062980", "D0261554", 
								 "D0209553", "D0024168", "D0024311", "D8058348", "D8056020",
								 "D8058361", "D8058362", "D8361571"};
		String[] nazwaA = 		{"Resolve", "VANISH OXI 1 KG single", "VANISH OXI 1 KG folia", "VANISH OXI 1 KG (Silvervac)", "Vanish 750g nowe pudełko", 
								 "VANISH OXY 500g/600g  (MC Primecoat)", "VANISH ZING 500g/600g  (Silvervac)", "VANISH OXY 500g/600g  (PE 85 Top White)", "Vitroclean 250ml", "DESTOP 1,25 L KOMPLET", 
								 "SUNSHINE 4L  FRONT + BACK", "CMC / Finish 250ml", "TIRET / DESTOP 1L", "Titan 1,5L", "Titan 2L",
								 "Titan 3L", "Titan 4L", "Horizon 4L"};
		String[] wykrojnikA = {"4", "5", "55", "5 GOLD", "222", 
				 "33", "33 GOLD", "333", "9", "12", 
				 "211", "41", "45", "50", "51",
				 "52", "53", "57"};
		String[] materialA = {"MC FASSON MC PRIMECOAT S2000N", "MC FASSON MC PRIMECOAT S2000N", "FOLIA FASSON PE 85 TOP WHITE S692N", "SREBRNY Raflatac SILVERVAC RP 51", "MC FASSON MC PRIMECOAT S2000N", 
				 "MC FASSON MC PRIMECOAT S2000N", "SREBRNY Raflatac SILVERVAC RP 51", "FOLIA FASSON PE 85 TOP WHITE S692N", "MC FASSON MC PRIMECOAT S2000N", "MC FASSON MC PRIMECOAT S2045", 
				 "FOLIA FASSON PE 85 TOP WHITE S692N", "FOLIA FASSON PE 85 TOP WHITE S692N", "MC FASSON MC PRIMECOAT S2000N", "FOLIA Raflatac PE WHITE FTC 85 RP 37", "FOLIA FASSON PE 85 TOP WHITE S4700",
				 "FOLIA FASSON PE 85 TOP WHITE S4700", "FOLIA FASSON PE 85 TOP WHITE S4700", "FOLIA Raflatac PE WHITE FTC 85 RP 37"};
		String[] szerokoscMaterialuA = {"285", "260", "265", "260", "370", 
				 "300", "300", "300", "228", "331", 
				 "415", "310", "325", "333", "338",
				 "365", "395", "390"};
		String[] wymiarEtykietyA = {"85 x 347 mm", "116 x 347 mm", "116 x 347 mm", "116 x 347 mm", "116 x 283 mm", 
				 "90 x 283 mm", "90 x 283 mm", "90 x 283 mm", "104 x 70,5 mm", "154 x 82 mm", 
				 "195 x 130 mm", "70  x 86,9 mm", "148 x 74,47 mm", "151 x 89 mm", "157 x 92,35 mm",
				 "171 x 113,6 mm", "185 x 113,60 mm", "182,5 x 146 mm"};

				BufferedReader fileReader = null;
				String specyfikacja = "";
				String nazwa = "";
				String wykrojnik = "";
				String material = "";
				String szerokoscMaterialu = "";
				String wymiarEtykiety = "";
				
				String koniec = "";
				
				    
					fileReader = new BufferedReader(new FileReader(file));
					//koniec= fileReader.readLine();
					main_loop:
				    	while (koniec != null) {
				    	koniec= fileReader.readLine();   
				    	for (int a=0; a<specyfikacjaA.length; a++) {
				    		if (koniec.contains(specyfikacjaA[a])) {
				    			specyfikacja = 	specyfikacjaA[a];
				    			nazwa = nazwaA[a];
				    			wykrojnik = wykrojnikA[a];
				    			material = materialA[a];
				    			szerokoscMaterialu = szerokoscMaterialuA[a];
				    			wymiarEtykiety = wymiarEtykietyA[a];
				    			
				    			break main_loop;
					    	}	
				    		
				    	}
				    }
				if (fileReader != null) {
			        fileReader.close();
			    }
				else if (fileReader == null) {
	    			specyfikacja = "";
	    			nazwa = "";
	    			wykrojnik = "";
	    			material = "";
	    			szerokoscMaterialu = "";
	    			wymiarEtykiety = "";
	    		
	    		}
				m.addAttribute("specyfikacja", specyfikacja);
    			m.addAttribute("nazwa", nazwa);
    			m.addAttribute("wykrojnik", wykrojnik);
    			m.addAttribute("material", material);
    			m.addAttribute("szerokoscMaterialu", szerokoscMaterialu);
    			m.addAttribute("wymiarEtykiety", wymiarEtykiety);
    			
    			
			return "result.jsp";
}
	
}
