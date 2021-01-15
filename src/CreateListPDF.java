import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class CreateListPDF {

	private List<Inventory> inventory2;
	
	public CreateListPDF(List<Inventory> inventory2) {
		super();
		this.inventory2 = inventory2;
	}

	private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setPadding(3);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);

        cell.setPhrase(new Phrase("Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Rating", font));
        table.addCell(cell);

    }
	
	private void writeTableData(PdfPTable table) {
		for(Inventory inventory:inventory2) {
			
			table.addCell(inventory.getName());
	        table.addCell(String.valueOf(inventory.getRating()));
		}
    }
	
	public void export(HttpServletResponse response) throws DocumentException, IOException {
		com.itextpdf.text.Document document = new com.itextpdf.text.Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);

        Paragraph p = new Paragraph("Product List", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {5.0f, 5.0f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();
    }
}
