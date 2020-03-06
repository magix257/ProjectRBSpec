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
		
		String[] specyfikacja = new String[20];
		String[] nazwa = new String[20];
		String[] wykrojnik = new String[20];
		String[] material = new String[20];
		String[] szerokoscMaterialu = new String[20];
		String[] wymiarEtykiety = new String[20];

				BufferedReader fileReader = null;
				String linia = "";
				String koniec = "";
				try {
				    fileReader = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8));
			
				    	while (koniec != null) {
				    		if ((koniec.contains("0211314"))&&(koniec.contains("<egLay:name>"))){
				    			linia = "true";	
				    			m.addAttribute("result", linia);
				    			break;
				    		}
				    		else {
				    			linia = "false";
				    			m.addAttribute("result", linia);
				    		}
				    	koniec= fileReader.readLine();
				    }
			
				} finally {
				    if (fileReader != null) {
				        fileReader.close();
				    }
				}

			return "result.jsp";
}
	
}
