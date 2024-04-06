package javinha;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Doencas {
    private Doenca[] doencas;

    @XmlElement
    public Doenca[] getDoencas() {
        return doencas;
    }
    public void setDoencas(Doenca[] doencas) {
        this.doencas = doencas;
    }
}
