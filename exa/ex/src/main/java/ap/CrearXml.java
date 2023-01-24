package ap;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CrearXml {

    public static void main(String[] args) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();

            Document documento = implementation.createDocument(null, "asignaturas", null);
            documento.setXmlVersion("1.0");

            Element asignaturas = documento.createElement("asignaturas");
            Element asignatura = documento.createElement("asignatura");


            Element id = documento.createElement("Id");
            asignatura.appendChild(id);
            id.appendChild(documento.createTextNode("1000"));

            Element nombre = documento.createElement("nombre");
            asignatura.appendChild(nombre);
            nombre.appendChild(documento.createTextNode("Pepito"));

            Element idCiclo = documento.createElement("idCiclo");
            asignatura.appendChild(idCiclo);
            idCiclo.appendChild(documento.createTextNode("10"));



            asignaturas.appendChild(asignatura);

            documento.getDocumentElement().appendChild(asignaturas);

            Source source = new DOMSource(documento);
            Result result = new StreamResult(new File("datos.xml"));

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException ex) {
            System.out.println(ex.getMessage());
        }

    }

}