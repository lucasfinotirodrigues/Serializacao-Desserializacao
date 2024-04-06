package javinha;

// import com.thoughtworks.xstream.XStream;

public class Jason {
    public static void main(String[] args) {
        Informacoes informacoes = new Informacoes();
        informacoes.setFamilia("Picornaviridae");
        informacoes.setGenero("Aphthovirus");
        informacoes.setReino("Virus");
        informacoes.setAnoDescoberta(1895);

        Curiosidades curiosidades = new Curiosidades();
        curiosidades.setResumo(
                "A febre aftosa é uma doença altamente contagiosa desencadeada por um vírus. Ela afeta bovinos, ovinos, caprinos, suínos, camelídeos, elefantes e ruminantes silvestres. Em casos raros, o ser humano pode também ser acometido pela doença. A febre aftosa ocorre em diferentes partes do mundo, sendo conhecidos casos na África, parte da Europa, Ásia, e em grande parte da América do Sul, incluindo o Brasil. Vale salientar, no entanto, que o último caso de febre aftosa no Brasil foi registrado em 2006.");
        curiosidades.setFontePrimaria(
                "https://www.defesa.agricultura.sp.gov.br/educacao-sanitaria/files/cards/link_doencas_aftosa.pdf");
        curiosidades.setFonteSecundaria("https://brasilescola.uol.com.br/doencas/febre-aftosa.htm");

        Doenca doenca = new Doenca();
        doenca.setNome("Febre Aftosa");
        doenca.setInformacoes(informacoes);
        doenca.setCuriosidades(curiosidades);

        Doencas doencas = new Doencas();
        doencas.setDoencas(new Doenca[] { doenca });

        Doenca[] listaDoencas = doencas.getDoencas();
        System.out.println("Febre Aftosa: " + listaDoencas[0].getNome());

        // ObjectMapper objectMapper = new objectMapper();
    }
}
