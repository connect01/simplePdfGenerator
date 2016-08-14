package simple.pdf.generator;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * Created by AK on 8/14/2016.
 */
public class PdfGenerator {

    public static final String DEST = "/projects/simpleTable.pdf";

    public static void main(String[] args) throws IOException,
            DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        renderPdf(DEST);
        System.out.println("PDF generated at: "+ file.getAbsolutePath());

    }

    public static void renderPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        FileOutputStream  fileOutputStream = new FileOutputStream(dest);
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfPTable table = new PdfPTable(8);
        table.setWidthPercentage(100);
        setTableHeaders(table);
        for(int aw = 0; aw < 48; aw++){
            table.addCell(String.valueOf(aw));
        }
        document.add(table);
        document.close();
        fileOutputStream.close();
    }

    public static void setTableHeaders(PdfPTable table){

        table.addCell("Header 1");
        table.addCell("Header 2");
        table.addCell("Header 3");
        table.addCell("Header 4");
        table.addCell("Header 5");
        table.addCell("Header 6");
        table.addCell("Header 7");
        table.addCell("Header 8");

    }

}
