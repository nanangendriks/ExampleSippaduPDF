import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;

public class PDF {
	private static String LogoSDA = "resources/logo.png";
	private static String Ttd = "resources/ttd.png";
	private static String Stampel = "resources/stempel.png";
	private static String FILE = "results/example.pdf";
	private static String QRCodeString = "ID1234567";
	private static Font mediumBold = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
	private static Font smallFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
	private static Font xsFont = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.NORMAL);

	public static void main(String[] args) {
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();
			addMetaData(document);
			addSectionKop(document);
			// add sparator
			Paragraph p = new Paragraph();
			LineSeparator line = new LineSeparator();
	        line.setOffset(-1);
	        p.add(line);
	        p.add("\n");
	        document.add(p);
	        // end sparator
			addSectionNomorSurat(document);
			contentText(document);
			addSectionTtd(document);
			document.close();
			Desktop.getDesktop().open(new File(FILE));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void contentText(Document document) throws DocumentException {
		PdfPTable table = new PdfPTable(1);
		table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		table.setWidthPercentage(92);
		
		PdfPTable table2 = new PdfPTable(1);
		table2.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		table2.setWidthPercentage(82);
		
		
		addContent(document, "Mendasari ;");
		PdfPTable pp1, pp2, pp3, pp4;
		pp1 = textFormater2(document, "1. ","Surat Saudara tanggal <> Nomor <> perihal <> ;");
		pp2 = textFormater2(document, "2. ","Hasil verifikasi teknis di lapang oleh Tim Verifikasi Izin Penyimpanan Sementara Limbah B3 pada <>;");
		pp3 = textFormater2(document, "3. ","Surat Saudara tanggal <> Nomor <> perihal <> ;");
		pp4 = textFormater2(document, "4. ","Peraturan Bupati Sidoarjo Nomor 14 Tahun 2016 tentang Pengelolaan Limbah Bahan Berbahaya dan Beracun di Kabupaten Sidoarjo, maka bersama ini disampaikan bahwa :");
		
		PdfPTable p1, p2, p3, p4;
		p1 = textFormater3(document, "a) Nama Perusahaan", "<>");
		p2 = textFormater3(document, "b) Bidang Usaha", "<>");
		p3 = textFormater3(document, "c) Lokasi", "<>");
		p4 = textFormater3(document, "d) Telepon/Fax", "<>");
		
		
		PdfPCell cell = new PdfPCell();
		cell.setBorder(0); // remove border
		cell.addElement(pp1);
		cell.addElement(pp2);
		cell.addElement(pp3);
		cell.addElement(pp4);
		
		PdfPCell cell2 = new PdfPCell();
		cell2.setBorder(0); // remove border
		cell2.addElement(p1);
		cell2.addElement(p2);
		cell2.addElement(p3);
		cell2.addElement(p4);
		
		
		table.addCell(cell);
		table2.addCell(cell2);
		document.add(table);
		addContent(document, " ");
		document.add(table2);
		addContent(document, " ");
		
		addContent(document, "Direkomendasikan untuk diberikan Izin Pengelolaan Limbah Bahan Berbahaya dan Beracun (B3) untuk Kegiatan Penyimpanan Limbah Bahan Berbahaya dan Beracun (B3) dengan mengacu pada persyaratan teknis sebagaimana terlampir. Persyaratan Teknis dimaksud merupakan ketentuan-ketentuan teknis yang harus dipatuhi dan merupakan satu kesatuan yang tidak terpisahkan dari rekomendasi teknis ini.");
		addContent(document, "Apabila terjadi perubahan terhadap ketentuan-ketentuan teknis sebagaimana terlampir dan/atau ketentuan-ketentuan sebagaimana yang diatur dalam Peraturan Pemerintah Republik Indonesia Nomor 101 Tahun 2014 tentang Pengelolaan Limbah Bahan Berbahaya dan Beracun, Saudara wajib mengajukan perubahan Izin.");
		addContent(document, "Rekomendasi Teknis ini bukan merupakan Izin Pengelolaan Limbah Bahan Berbahaya dan Beracun (B3) dan berlaku selama 90 (sembilan puluh) hari sejak tanggal diterbitkan untuk menjadi persyaratan pengajuan Izin Pengelolaan Limbah Bahan Berbahaya dan Beracun (B3) untuk Kegiatan Penyimpanan Limbah Bahan Berbahaya dan Beracun (B3) ke Dinas Penanaman Modal dan Pelayanan Terpadu Satu Pintu Kabupaten Sidoarjo.");
		addContent(document, "Hal-hal lain yang belum tercantum dalam rekomendasi teknis ini agar dilaksanakan sesuai dengan peraturan perundang-undangan yang berlaku");
		addContent(document, "Demikian untuk menjadikan perhatian pelaksanaannya.");
	}
	
	private static void addMetaData(Document document) {
		document.addTitle("My first PDF");
		document.addSubject("Using iText");
		document.addKeywords("Java, PDF, iText");
		document.addAuthor("Lars Vogel");
		document.addCreator("Lars Vogel");
	}

	private static void addSectionKop(Document document) throws DocumentException, MalformedURLException, IOException {

		// create table with two columns
		PdfPTable table = new PdfPTable(2);

		// set width ratio
		table.setWidths(new float[] { 1, 3 });
		table.setWidthPercentage(100);

		// create paragraph
		Paragraph p = new Paragraph();
		p.setFont(smallFont); // set for small text
		p.add("PEMERINTAH KABUPATEN SIDOARJO\n");
		p.add("DINAS LINGKUNGAN HIDUP DAN KEBERSIHAN\n");
		p.add("Jl. Raya Siwalanpanji No.36 Buduran. Telp.(031) 8963184 Fax.(031) 8946551\n");
		p.add("Website : dlhk.sidoarjokab.go.id Email : dlhk@sidoarjokab.go.id\n");
		p.setFont(mediumBold); // set for medium text
		p.add("S I D O A R J O - 6 1 2 5 2\n");

		Image image = Image.getInstance(LogoSDA);
		image.scalePercent(90); // to scale image size

		// pass paragraph to cell table
		PdfPCell cell = new PdfPCell(p);
		cell.setBorder(0); // remove border
		// set the paragraph to align center & middle
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);

		// pass image to cell table
		PdfPCell cell2 = new PdfPCell(image);
		cell2.setBorder(0); // remove border
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);

		// pass cell to the table
		table.addCell(cell2);
		table.addCell(cell);
		document.add(table);
	}

	private static void addSectionNomorSurat(Document document)
			throws DocumentException, MalformedURLException, IOException {
		// create table with ratio
		PdfPTable table = new PdfPTable(new float[] { 3, 1 });
		table.setWidthPercentage(100);
		
		PdfPTable p1, p2, p3, p4;
		p1 = textFormater3Nomor(document, "Nomor", "660/ /438.5.10/2018");
		p2 = textFormater3Nomor(document, "Sifat", "Penting");
		p3 = textFormater3Nomor(document, "Lampiran", "1 (satu) berkas");
		p4 = textFormater3Nomor(document, "Perihal", "Rekomendasi Teknis Izin Pengelolaan Limbah B3 untuk Kegiatan Penyimpanan Limbah B3");
		
		
		PdfPTable pp1, pp2, pp3, pp4, pp5;
		pp1 = textFormater(document, "Sidoarjo");
		pp2 = textFormater(document, "Kepada:");
		pp3 = textFormater(document, "Yth. Sdr");
		pp4 = textFormater(document, "di");
		pp5 = textFormater(document, " Sidoarjo");
	
		PdfPCell cell = new PdfPCell();
		cell.setBorder(0); // remove border
		cell.addElement(p1);
		cell.addElement(p2);
		cell.addElement(p3);
		cell.addElement(p4);
		
		PdfPCell cell2 = new PdfPCell();
		cell2.setBorder(0); // remove border
		cell2.addElement(pp1);
		cell2.addElement(pp2);
		cell2.addElement(pp3);
		cell2.addElement(new Paragraph("\n"));
		cell2.addElement(pp4);
		cell2.addElement(pp5);
		

		table.addCell(cell);
		table.addCell(cell2);
		document.add(table);
	}
	
	private static PdfPTable textFormater(Document document, String text) throws DocumentException {
		PdfPTable table = new PdfPTable(1);
		table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		table.setWidthPercentage(100);
		Paragraph p = new Paragraph();
		p.setFont(smallFont);
		p.add(text+"\n");
		table.addCell(p);
		return table;
	}
	private static PdfPTable textFormater2(Document document, String text1, String text2) throws DocumentException {
		PdfPTable table = new PdfPTable(new float[] { 5, 95 });
		table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		table.setWidthPercentage(100);
		Paragraph p = new Paragraph();
		p.setFont(smallFont);
		p.add(text1);
		
		Paragraph p2 = new Paragraph();
		p2.setFont(smallFont);
		p2.add(text2);
		table.addCell(p);
		table.addCell(p2);
		return table;
	}
	private static PdfPTable textFormater3(Document document, String text1, String text2) throws DocumentException {
		PdfPTable table = new PdfPTable(new float[] { 40, 3, 58 });
		table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		table.setWidthPercentage(100);
		Paragraph p = new Paragraph();
		p.setFont(smallFont);
		p.add(text1);
		
		Paragraph p2 = new Paragraph();
		p2.setFont(smallFont);
		p2.add(text2);
		table.addCell(p);
		table.addCell(":");
		table.addCell(p2);
		return table;
	}
	
	private static PdfPTable textFormater3Nomor(Document document, String text1, String text2) throws DocumentException {
		PdfPTable table = new PdfPTable(new float[] { 20, 3, 78 });
		table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
		table.setWidthPercentage(100);
		Paragraph p = new Paragraph();
		p.setFont(smallFont);
		p.add(text1);
		
		Paragraph p2 = new Paragraph();
		p2.setFont(smallFont);
		p2.add(text2);
		table.addCell(p);
		table.addCell(":");
		table.addCell(p2);
		return table;
	}

	private static void addContent(Document document, String text) throws DocumentException {
		Paragraph p = new Paragraph();
		p.setPaddingTop(30);
		p.setAlignment(Element.ALIGN_JUSTIFIED);
		p.setSpacingAfter(0);
		p.setFont(smallFont);
		p.setFirstLineIndent(30); // set indent
		p.setIndentationLeft(20);
		p.setIndentationRight(20);
		p.add(text);
		p.add("\n\n");
		document.add(p);
	}

	private static void addSectionTtd(Document document) throws DocumentException, MalformedURLException, IOException {
		// create table with ratio 1:1
		PdfPTable table = new PdfPTable(new float[] { 1, 1 });
		table.setWidthPercentage(100);
		table.setPaddingTop(10);
		// create table for qrcode & text note
		PdfPTable table2 = new PdfPTable(1);

		// create qrcode
		BarcodeQRCode barcodeQRCode = new BarcodeQRCode(QRCodeString, 300, 300, null);
		Image codeQrImage = barcodeQRCode.getImage();
		codeQrImage.scaleAbsolute(100, 100); // scale qrcode size

		// pass qrcode image to cell table
		PdfPCell cellQRCode = new PdfPCell(codeQrImage);
		cellQRCode.setBorder(0); // remove border

		Paragraph note = new Paragraph();
		note.setFont(xsFont);
		note.add("TEMBUSAN :\n");
		note.add("Yth\n");
		note.add("1. Bupati Sidoarjo (sebagai laporan);\n");
		note.add("2. Kepala Dinas Penanaman Modal dan Pelayanan Terpadu Satu Pintu Kabupaten Sidoarjo.\n");

		// pass paragraph to table cell
		PdfPCell cellNote = new PdfPCell(note);
		cellNote.setBorder(0); // remove border

		// pass cell to table
		table2.addCell(cellQRCode);
		table2.addCell(cellNote);

		// left cell table
		PdfPCell cellLeft = new PdfPCell(table2);
		cellLeft.setBorder(0); // remove border

		Paragraph p2 = new Paragraph();
		p2.setFont(smallFont);
		p2.setAlignment(Element.ALIGN_CENTER);
		p2.add("KEPALA DINAS LINGKUNGAN HIDUP\n");// set align to center
		p2.add("DAN KEBERSIHAN\n");
		p2.add("KABUPATEN SIDOARJO\n");

		// image signature
		Image imageTtd = Image.getInstance(Ttd);
		// image stamp
		Image imageStamp = Image.getInstance(Stampel);

		// pass paragraph to table cell
		PdfPCell cellRight = new PdfPCell();
		cellRight.addElement(p2);
		cellRight.setBorder(0); // remove border

		Paragraph pNew = new Paragraph();
		imageStamp.scalePercent(10); // scale image stamp
		imageTtd.scalePercent(20); // scale image signature

		// set to horizontal with chunk
		pNew.add(new Chunk(imageStamp, 60, 0, true)); // value 60 set the X position
		pNew.add(new Chunk(imageTtd, 0, 0, true));

		cellRight.addElement(pNew);

		table.addCell(cellLeft);
		table.addCell(cellRight);
		document.add(table);
	}

}