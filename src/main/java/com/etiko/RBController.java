package com.etiko;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

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
		
		String filePath = file.getAbsolutePath();
		
		String[] specyfikacjaA = {"D0025873", "D0025876", "D8324258", "D8114311", "D0327096", 
								 "D0211314", "D8114310", "D8324257", "0062980", "D0261554", 
								 "D0209553", "D0024168", "D0024311", "D8058348", "D8058320",
								 "D8058361", "D8058362", "D8361571"};
		String[] nazwaA = 		{"Resolve", "VANISH OXI 1 KG single", "VANISH OXI 1 KG folia", "VANISH OXI 1 KG (Silvervac)", "Vanish 750g nowe pudełko", 
								 "VANISH OXY 500g/600g  (MC Primecoat)", "VANISH ZING 500g/600g  (Silvervac)", "VANISH OXY 500g/600g  (PE 85 Top White)", "Vitroclean 250ml", "DESTOP 1,25 L KOMPLET", 
								 "SUNSHINE 4L  FRONT + BACK", "CMC / Finish 250ml", "TIRET / DESTOP 1L", "Titan 1,5L", "Titan 2L",
								 "Titan 3L", "Titan 4L", "Horizon 4L"};
		String[] wykrojnikA = new String[20];
		String[] materialA = new String[20];
		String[] szerokoscMaterialuA = new String[20];
		String[] wymiarEtykietyA = new String[20];

				BufferedReader fileReader = null;
				String linia = "";
				String specyfikacja = "";
				String nazwa = "";
				String koniec = "";
				
				    
					fileReader = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8));
					//koniec= fileReader.readLine();
					main_loop:
				    	while (koniec != null) {
				    	koniec= fileReader.readLine();   
				    	for (int a=0; a<specyfikacjaA.length; a++) {
				    		if (koniec.contains(specyfikacjaA[a])) {
				    			specyfikacja = 	specyfikacjaA[a];
				    			nazwa = nazwaA[a];
				    			break main_loop;
					    	}	
				    	}
				    }
				if (fileReader != null) {
			        fileReader.close();
			    }
				m.addAttribute("specyfikacja", specyfikacja);
    			m.addAttribute("nazwa", nazwa);
    			
			return "result.jsp";
}
	
}

//if ((koniec.contains(specyfikacjaA[a]))&&(koniec.contains("<egLay:name>"))){
//	specyfikacja = specyfikacjaA[a];
//	nazwa = nazwaA[a];
//	break main_loop;
//	
//}
//else {
//	linia = "false";
//	m.addAttribute("nazwa", linia);
//}
//for (int a=0; a<specyfikacjaA.length; a++) {
//}
//main_loop: