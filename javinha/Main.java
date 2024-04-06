package javinha;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Main {
    public static void main(String[] args)  throws JAXBException, IOException{
        Informacoes informacoes = new Informacoes();
        informacoes.setFamilia("Picornaviridae");
        informacoes.setGenero("Aphthovirus");
        informacoes.setReino("Virus");
        informacoes.setAnoDescoberta(1895);

        Curiosidades curiosidades = new Curiosidades();
        curiosidades.setResumo("A febre aftosa é uma doença altamente contagiosa desencadeada por um vírus. Ela afeta bovinos, ovinos, caprinos, suínos, camelídeos, elefantes e ruminantes silvestres. Em casos raros, o ser humano pode também ser acometido pela doença. A febre aftosa ocorre em diferentes partes do mundo, sendo conhecidos casos na África, parte da Europa, Ásia, e em grande parte da América do Sul, incluindo o Brasil. Vale salientar, no entanto, que o último caso de febre aftosa no Brasil foi registrado em 2006.");
        curiosidades.setFontePrimaria("https://www.defesa.agricultura.sp.gov.br/educacao-sanitaria/files/cards/link_doencas_aftosa.pdf");
        curiosidades.setFonteSecundaria("https://brasilescola.uol.com.br/doencas/febre-aftosa.htm");

        Doenca doenca = new Doenca();
        doenca.setNome("Febre Aftosa");
        doenca.setInformacoes(informacoes);
        doenca.setCuriosidades(curiosidades);

        Doencas doencas = new Doencas();
        doencas.setDoencas(new Doenca[]{doenca});

        Doenca[] listaDoencas = doencas.getDoencas();
        System.out.println("Febre Aftosa: " + listaDoencas[0].getNome());


        // Retornando de java para .xml
        JAXBContext jaxbContext = JAXBContext.newInstance(Doencas.class);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        File file = new File("doencas.xml");

        marshaller.marshal(doencas, file);

        System.out.println("XML salvo em: " + file.getAbsolutePath());

        // Retornado de .xml para objetos java

        JAXBContext jaxbContext2 = JAXBContext.newInstance(Doencas.class);

        // Criando um unmarshaller JAXB
        Unmarshaller unmarshaller = jaxbContext2.createUnmarshaller();

        // Lendo o arquivo XML e criando o objeto Pessoa
        file = new File("doencas.xml");
        Doencas doencas2 = (Doencas) unmarshaller.unmarshal(file);


        // Exibindo os detalhes da doencas
        
        System.out.println("Doença: " + doencas2.getDoencas()[0].getNome());
    }
}
