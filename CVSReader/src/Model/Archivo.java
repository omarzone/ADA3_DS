package Model;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.Path;
import com.itextpdf.text.pdf.parser.clipper.Paths;
import com.itextpdf.text.pdf.parser.clipper.Paths;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Archivo {
    private final static String RUTA_ARCHIVO = "CVSReader/src/Docs/Lista.csv";
    private final static String SEPARADOR = ",";
    private BufferedReader lectorDocumento = null;

    public void deteleTailTrash(Alumno alumno) {
        String data = alumno.getMatricula();
        alumno.setMatricula(data.replaceAll("ï»¿", ""));
    }

    public void leerDocumento(ArrayList<Alumno> listaAlumnos) throws Exception {
        try {
            this.lectorDocumento = new BufferedReader(new FileReader(RUTA_ARCHIVO));
            String linea = lectorDocumento.readLine();
            while (linea != null) {
                String[] datosArchivo = linea.split(SEPARADOR);
                listaAlumnos.add(new Alumno(datosArchivo[0], datosArchivo[1], datosArchivo[2], datosArchivo[3]));
                linea = lectorDocumento.readLine();
            }

        } catch (Exception ex) {
            System.out.println("problema detectado " + ex);

        } finally {
            if (null != lectorDocumento) {
                lectorDocumento.close();
            }

        }
    }

    private void generarArchivoSalida(ArrayList<Alumno> listaCalificaciones) throws IOException {
        String MATERIA = "Diseño de software";
        FileOutputStream archivoCsv = new FileOutputStream("CVSReader/src/Docs/salida.csv");
        OutputStreamWriter salida = new OutputStreamWriter(archivoCsv, "UTF-8");

        for (Alumno alumno : listaCalificaciones) {
            try {
                salida.write(
                        alumno.getMatricula() + "," + MATERIA + "," + String.valueOf(alumno.getCalificacion() + "\n"));
            } catch (IOException ex) {
                System.out.print(ex);
            }

        }

        salida.close();

    }

    public void opcionSalida(ArrayList<Alumno> listaCalificaciones) throws IOException {
        char caracter = 'S';
        Scanner entrada = new Scanner(System.in);

        try {
            if (caracter == 's' || caracter == 'S') {
                this.generarArchivoSalida(listaCalificaciones);
                System.out.println("Archivo generado en salida.csv");
            } else if (caracter == 'n' || caracter == 'N') {

                System.out.println("Programa terminado");
            } else {

                throw new IOException();
            }
        } catch (Exception e) {
            System.out.println("Ingrese una opcion correcta");
            opcionSalida(listaCalificaciones);
        }
    }

    public void generarPdf(ArrayList<Alumno> listaCalificaciones) throws URISyntaxException, IOException {
        Document document = new Document();
        FileOutputStream archivoPDF = new FileOutputStream("HelloWorld.pdf");
        try {
            PdfWriter writer = PdfWriter.getInstance(document, archivoPDF);
            document.open();
            //Insertamos la cabecera o titulo del pdf
            Paragraph cabecera = new Paragraph("Diseño de Software");
            cabecera.setAlignment(Element.ALIGN_CENTER);
            document.add(cabecera);
            //Salto de linea
            document.add( Chunk.NEWLINE );

            //Creamos la tabla
            PdfPTable table = new PdfPTable(3);

            //seteamos el diseno header de la tabala
            addTableHeader(table);
            

            //agregamos las filas
            for(Alumno alumno : listaCalificaciones){

                addRow(table, alumno, archivoPDF);

            }
           

            document.add(table);
            document.close();
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    private void addTableHeader(PdfPTable table) {
        Stream.of("Matrícula", "Nombre", "Calificación")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    private void addRow(PdfPTable table, Alumno alumno, FileOutputStream archivoPDF) throws UnsupportedEncodingException {
        String nombreCompleto = alumno.getNombres() + " " + alumno.getPApellido() + " " +alumno.getSApellido();
        ByteBuffer buffer = StandardCharsets.UTF_8.encode(nombreCompleto) ;
        String nombreCompletoEncoded = StandardCharsets.UTF_8.decode(buffer).toString();
        table.addCell(alumno.getMatricula());
        table.addCell(nombreCompletoEncoded);
        table.addCell(String.valueOf(alumno.getCalificacion()));
    }




}
