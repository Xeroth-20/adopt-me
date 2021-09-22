package dev.jx.app.util.pdf;

import java.util.Collection;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.awt.Color;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import dev.jx.app.entity.Owner;
import dev.jx.app.entity.Adoption;

public class OwnerPDFExporter implements PDFExporter<Owner> {

    @Override
    public void export(Owner object, HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        document.addTitle("owner" + System.currentTimeMillis());

        Paragraph pAdoptMe = new Paragraph("ADOPT ME",
                FontFactory.getFont(FontFactory.HELVETICA_BOLD, 36, new Color(0x0070C0))
        );
        pAdoptMe.setSpacingAfter(20f);
        Paragraph pOwnerReport = new Paragraph("OWNER REPORT",
                FontFactory.getFont(FontFactory.HELVETICA, 14, new Color(0, 0, 0, 0.84f))
        );
        pOwnerReport.setSpacingAfter(6f);
        Paragraph pAdoptionList = new Paragraph("ADOPTION LIST",
                FontFactory.getFont(FontFactory.HELVETICA, 14, new Color(0, 0, 0, 0.84f))
        );
        pAdoptionList.setSpacingBefore(6f);

        document.add(pAdoptMe);
        document.add(pOwnerReport);
        document.add(this.userFieldParagraph("FIRSTNAME", object.getFirstname()));
        document.add(this.userFieldParagraph("LASTNAME", object.getLastname()));
        document.add(this.userFieldParagraph("AGE", object.getAge().toString()));
        document.add(this.userFieldParagraph("PHONE", object.getPhone()));
        document.add(pAdoptionList);

        Table adoptionTable = new Table(4);
        adoptionTable.setWidth(100f);
        adoptionTable.setWidths(new float[]{0.5f, 3f, 3f, 3f});
        adoptionTable.setPadding(2f);
        this.writeAdoptionTableHeader(adoptionTable);
        this.writeAdoptionTableData(adoptionTable, object.getAdoptions());
        document.add(adoptionTable);

        document.close();
    }

    private Paragraph userFieldParagraph(String field, String value) {
        Paragraph pUserField = new Paragraph();
        pUserField.setFont(FontFactory.getFont(FontFactory.HELVETICA, 10, new Color(0, 0, 0, 0.84f)));
        pUserField.add(new Chunk(field, FontFactory.getFont(FontFactory.HELVETICA, 10, new Color(0, 0, 0, 0.92f))));
        pUserField.add(" : " + value);

        return pUserField;
    }

    private void writeAdoptionTableHeader(Table table) {
        table.addCell(this.th("#"));
        table.addCell(this.th("PET NAME"));
        table.addCell(this.th("PET AGE"));
        table.addCell(this.th("ADOPTION DATE"));
    }

    private void writeAdoptionTableData(Table table, Collection<Adoption> adoptions) {
        List<Adoption> sortedAdoptions = adoptions.stream()
                .sorted(Comparator.comparing(Adoption::getAdoptionDate))
                .collect(Collectors.toList());

        for (int i = 1; i <= sortedAdoptions.size(); i++) {
            Adoption adoption = sortedAdoptions.get(i - 1);
            table.addCell(this.td(String.valueOf(i)));
            table.addCell(this.td(adoption.getPet().getName()));
            table.addCell(this.td(adoption.getPet().getAge().toString()));
            table.addCell(this.td(adoption.getAdoptionDate().toString()));
        }
    }

    private Cell th(String name) {
        Cell cell = new Cell(new Phrase(name,
                FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, new Color(1f, 1f, 1f, 0.92f)))
        );
        cell.setBackgroundColor(new Color(0x212423));

        return cell;
    }

    private Cell td(String name) {
        return new Cell(new Phrase(name,
                FontFactory.getFont(FontFactory.HELVETICA, 10, new Color(0, 0, 0, 0.72f)))
        );
    }
}
