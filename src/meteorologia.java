import java.io.IOException;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class meteorologia {

	public static void main(String[] args) throws IOException {
		
		String icao;
		
		icao = JOptionPane.showInputDialog("Digite o ICAO");
		
		Document doc = Jsoup.connect("https://metar-taf.com/pt/"+icao).get();
		
		//Retorna nome da localidade
		Elements nome = doc.selectXpath("//*[@id=\"metar\"]/div/div[2]/div[2]/div[1]/article/p[2]/a");
		//Retorna METAT
		Elements metar = doc.selectXpath("//*[@id=\"metar\"]/div/div[1]/div[3]/div[2]/code");
		//Retorna Vento
		Elements vento = doc.selectXpath("//*[@id=\"metar\"]/div/div[1]/div[2]/div[3]/div/div[1]/h3");
		//Retorna angulo do vento
		Elements angulo = doc.selectXpath("//*[@id=\"metar\"]/div/div[1]/div[2]/div[3]/div/div[2]");
		//Retorna visibilidade do vento
		Elements visibilidade = doc.selectXpath("//*[@id=\"metar\"]/div/div[1]/div[2]/div[4]/div/div[1]/h3");
		//Retorna teto
		Elements teto = doc.selectXpath("//*[@id=\"metar\"]/div/div[1]/div[2]/div[5]/div/div[1]/h3");
		//Retorna temperatura
		Elements temperatura = doc.selectXpath("//*[@id=\"metar\"]/div/div[1]/div[2]/div[2]/div/div/div[1]/p");
		//Retorna QNH
		Elements qnh = doc.selectXpath("//*[@id=\"metar\"]/div/div[1]/div[2]/div[6]/div/div[1]/h3")	;
		
		
		JOptionPane.showMessageDialog(null,nome.text()+""
				+ "\n"+metar.text()+"\n"
				+ "\nVENTO: "+vento.text()+" - "+angulo.text()+""
				+ "\nVISIBILIDADE: "+visibilidade.text()+""
				+ "\nTETO: "+teto.text()+""
				+ "\nTEMPERATURA: "+temperatura.text()+""
				+ "\nQNH: "+qnh.text());
	}

}
