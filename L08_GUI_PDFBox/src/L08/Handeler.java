package L08;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Handeler {

	public void Extractor(String location) {
		PDDocument pdf;
		PDFTextStripper stripper;
		File file = new File(location);
		
		
		try {
			pdf = PDDocument.load(file);
			stripper = new PDFTextStripper();	

			Frequency.Frequent(stripper.getText(pdf).trim().toLowerCase().replaceAll("[^A-Za-z0-9 ]", "").split("\\s+"));
			
			if(pdf != null)
				pdf.close();
		
			} catch (IOException e) {
			e.printStackTrace();
			}
		
	}

}
