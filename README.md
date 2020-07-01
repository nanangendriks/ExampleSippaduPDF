# SIPPADU PDF GENERATOR
Version 1.0

Untuk kostumisasi text lakukan perubahan pada file `PDFServlet.java`

## KONFIGURASI
Sesuaikan lokasi direktori Website dengan mengubah isi dari Parameter `PATH` 

	private static String PATH = "C:\\Users\\ASUS\\eclipse-workspace\\ServletSippaudPDF\\";
    
Untuk merubah `ID QRCode`

	private static String QRCodeString = "ID1234567";

## KONTEN
Untuk mengumpulkan semua tulisan menjadi satu halaman, dengan fungsi" yang sudah di bentuk
	
    private static void contentText(Document document) throws DocumentException {
        ...
    }

## META DATA
Untuk menabhakan meta data pada hasil pdf

    private static void addMetaData(Document document) {
        ...
	}

## KOP SURAT
Untuk merubah tulisan dari KOP SURAT

    private static void addSectionKop(Document document) throws DocumentException, MalformedURLException, IOException {
        ...
    }

## PENOMORAN SURAT
Untuk merubah Penomoran Surat

    private static void addSectionNomorSurat(Document document)
			throws DocumentException, MalformedURLException, IOException {
                ...
    }

# GENERATOR 
Fungsi untuk mengkonversi semua konten yang di bentuk ke dalam PDF

    public static void generate() {
        ...
    }

# FORMATER

## textFormater
Untuk memformat text dengan `1 variable` dinamis atau statis dengan posisi `1 kolom`
    
    private static PdfPTable textFormater(Document document, String text) throws DocumentException {
		PdfPTable table = new PdfPTable(1);
        ...
    }

## textFormater2
Untuk memformat text dengan `2 parameter text1 dan text 2` dinamis atau statis dengan posisi kiri kanan `2 kolom`
    
	private static PdfPTable textFormater2(Document document, String text1, String text2) throws DocumentException {
		PdfPTable table = new PdfPTable(new float[] { 5, 95 });
        ...
    }

## textFormater3
Untuk memformat text dengan `2 parameter text1 dan text 2` dinamis atau statis dengan posisi kiri kanan `3 kolom` dan lebar kolom yang berbeda
    
	private static PdfPTable textFormater2(Document document, String text1, String text2) throws DocumentException {
		PdfPTable table = new PdfPTable(new float[] { 40, 3, 58 });
        ...
    }

## textFormater3Nomor
Untuk memformat text dengan `2 parameter text1 dan text 2` dinamis atau statis dengan posisi kiri kanan `3 kolom` dan lebar kolom yang berbeda dan digunakan untuk format nomor surat
    
	private static PdfPTable textFormater2(Document document, String text1, String text2) throws DocumentException {
		PdfPTable table = new PdfPTable(new float[] { 20, 3, 78 });
        ...
    }

## addConent
Untuk memformat text tulisan rata kanan kiri, dengan parameter `text` yang dibutuhkan

	private static void addContent(Document document, String text) throws DocumentException {
        ...
    }

## addSectionTtd
Untuk memformat bagian TTD dan QR Code

	private static void addSectionTtd(Document document) throws DocumentException, MalformedURLException, IOException {
        ...
    }