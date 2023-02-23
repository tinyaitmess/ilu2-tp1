package histoire;
import personnages.Gaulois;
import villagegaulois.*;


public class ScenarioCasDegrade {
	
	public static void main(String[] args) throws IllegalArgumentException,IllegalStateException {
		int quantiteAcheter=-2;
		Gaulois acheteur =null;
		Etal etal = new Etal();
		if(!etal.isEtalOccupe()) {
			throw new IllegalStateException ("l'etal doit etre occupe");
		}else if (quantiteAcheter<1) {
			throw new IllegalArgumentException("quantite doit etre positive");
		}
		etal.acheterProduit(quantiteAcheter,acheteur);
		System.out.println("Fin du test");
	}
}
