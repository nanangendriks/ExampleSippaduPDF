import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

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
			addSectionNomorSurat(document);
			addContent(document);
			addSectionTtd(document);
			document.close();
			Desktop.getDesktop().open(new File(FILE));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void addMetaData(Document document) {
		document.addTitle("My first PDF");
		;
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
		// set the paragraph to align center & middle
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);

		// pass image to cell table
		PdfPCell cell2 = new PdfPCell(image);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER);

		// pass cell to the table
		table.addCell(cell2);
		table.addCell(cell);
		document.add(table);
	}

	private static void addSectionNomorSurat(Document document)
			throws DocumentException, MalformedURLException, IOException {
		PdfPTable table = new PdfPTable(new float[] { 3, 1 });
		table.setWidthPercentage(100);

		Paragraph p = new Paragraph();
		p.setFont(smallFont);
		p.add("Nomor : 660/ /438.5.10/2018 \n");
		p.add("Sifat : Penting\n");
		p.add("Lampiran : 1 (satu) berkas\n");
		p.add("Perihal : Rekomendasi Teknis Izin Pengelolaan Limbah B3 untuk Kegiatan Penyimpanan Limbah B3\n");

		Paragraph p2 = new Paragraph();
		p2.setFont(smallFont);
		p2.add("Sidoarjo, \n");
		p2.add("Kepada: \n");
		p2.add("Yth. Sdr\n\n\n");
		p2.add("di\n");
		p2.add(" Sidoarjo\n");

		PdfPCell cell = new PdfPCell(p);
		cell.setPaddingTop(30);

		PdfPCell cell2 = new PdfPCell(p2);

		table.addCell(cell);
		table.addCell(cell2);
		document.add(table);
	}

	private static void addContent(Document document) throws DocumentException {
		// create table
		PdfPTable table = new PdfPTable(1);
		table.setWidthPercentage(90); // set width table
		table.setPaddingTop(10);

		Paragraph p = new Paragraph();
		p.setFirstLineIndent(20);
		p.setAlignment(Element.ALIGN_JUSTIFIED);
		p.setFont(smallFont);
		p.add("Direkomendasikan untuk diberikan Izin Pengelolaan Limbah Bahan Berbahaya dan Beracun (B3) untuk Kegiatan Penyimpanan Limbah Bahan Berbahaya dan Beracun (B3) dengan mengacu pada persyaratan teknis sebagaimana terlampir. Persyaratan Teknis dimaksud merupakan ketentuan-ketentuan teknis yang harus dipatuhi dan merupakan satu kesatuan yang tidak terpisahkan dari rekomendasi teknis ini.\n\n");
		p.add("Apabila terjadi perubahan terhadap ketentuan-ketentuan teknis sebagaimana terlampir dan/atau ketentuan-ketentuan sebagaimana yang diatur dalam Peraturan Pemerintah Republik Indonesia Nomor 101 Tahun 2014 tentang Pengelolaan Limbah Bahan Berbahaya dan Beracun, Saudara wajib mengajukan perubahan Izin.\n\n");
		p.add("Rekomendasi Teknis ini bukan merupakan Izin Pengelolaan Limbah Bahan Berbahaya dan Beracun (B3) dan berlaku selama 90 (sembilan puluh) hari sejak tanggal diterbitkan untuk menjadi persyaratan pengajuan Izin Pengelolaan Limbah Bahan Berbahaya dan Beracun (B3) untuk Kegiatan Penyimpanan Limbah Bahan Berbahaya dan Beracun (B3) ke Dinas Penanaman Modal dan Pelayanan Terpadu Satu Pintu Kabupaten Sidoarjo.\n\n");
		p.add("Hal-hal lain yang belum tercantum dalam rekomendasi teknis ini agar dilaksanakan sesuai dengan peraturan perundang-undangan yang berlaku.\n\n");
		p.add("Demikian untuk menjadikan perhatian pelaksanaannya.\n\n");

		PdfPCell cell2 = new PdfPCell(p);
		table.addCell(cell2);
		document.add(table);

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

		Paragraph note = new Paragraph();
		note.setFont(xsFont);
		note.add("TEMBUSAN :\n");
		note.add("Yth\n");
		note.add("1. Bupati Sidoarjo (sebagai laporan);\n");
		note.add("2. Kepala Dinas Penanaman Modal dan Pelayanan Terpadu Satu Pintu Kabupaten Sidoarjo.\n");

		// pass paragraph to table cell
		PdfPCell cellNote = new PdfPCell(note);

		// pass cell to table
		table2.addCell(cellQRCode);
		table2.addCell(cellNote);

		// left cell table
		PdfPCell cellLeft = new PdfPCell(table2);

		Paragraph p2 = new Paragraph();
		p2.setFont(smallFont);
		p2.add("KEPALA DINAS LINGKUNGAN HIDUP\n");
		p2.add("DAN KEBERSIHAN\n");
		p2.add("KABUPATEN SIDOARJO\n");

		// image signature
		Image imageTtd = Image.getInstance(Ttd);
		// image stamp
		Image imageStamp = Image.getInstance(Stampel);

		// table right
		PdfPTable table3 = new PdfPTable(1);

		// pass paragraph to table cell
		PdfPCell cell2 = new PdfPCell(p2);
		cell2.setHorizontalAlignment(Element.ALIGN_CENTER); // set align to center

		// pass cell to table right
		table3.addCell(cell2);

		Paragraph pNew = new Paragraph();
		imageStamp.scalePercent(10); // scale image stamp
		imageTtd.scalePercent(20); // scale image signature

		// set to horizontal with chunk
		pNew.add(new Chunk(imageStamp, 0, 0, true));
		pNew.add(new Chunk(imageTtd, 0, 0, true));

		PdfPCell cell = new PdfPCell();
		cell.addElement(pNew);

		table3.addCell(cell);

		table.addCell(cellLeft);
		table.addCell(table3);
		document.add(table);
	}

}