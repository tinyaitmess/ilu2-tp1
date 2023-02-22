package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	Marche marche;

	public Village(String nom, int nbVillageoisMaximum, Marche marche) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
		this.marche = marche;
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef " + chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom() + " vivent les légendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}

	public String installerVendeur(Gaulois villageois, String produit, int nbProduit) {
		StringBuilder chaine = new StringBuilder();
		chaine.append(villageois.getNom() + "cherche un endroit pour vendre " + nbProduit + " " + produit + ".\n");
		int numeroEtal = marche.trouverEtalLibre();
		if (numeroEtal!=-1) {
			marche.utiliserEtal(numeroEtal, villageois, produit, nbProduit);
			chaine.append("Le vendeur "+villageois.getNom()+" vend des "+produit+" à l'étal n°"+ numeroEtal+".\n");
		}
		return chaine.toString();
	}
	
	public String rechercherVendeursProduit (String produit) {
		StringBuilder chaine = new StringBuilder();
		chaine.append("Les vendeurs qui proposent des "+produit+" sont :");
		Etal[] vendeursProduit = marche.trouverEtals(produit); 
		for (int i=0; i<vendeursProduit.length;i++) {
			chaine.append("- "+vendeursProduit[i].getVendeur()+"\n");
		}
		return chaine.toString();
	}
	
	public Etal rechercherEtal (Gaulois vendeur) {
		for (int i=0;i<marche.etals.length;i++) {
			if
		}
	}

//     PARTIE MARCHE ---------------------------------------- PARTIE MARCHE
//  PARTIE MARCHE ---------------------------------------- PARTIE MARCHE
//  PARTIE MARCHE ---------------------------------------- PARTIE MARCHE
//  PARTIE MARCHE ---------------------------------------- PARTIE MARCHE
//  PARTIE MARCHE ---------------------------------------- PARTIE MARCHE
//  PARTIE MARCHE ---------------------------------------- PARTIE MARCHE

	public class Marche {
		private int nbEtals;
		private Etal[] etals;

		Marche(int nbEtals) {
			super();
			this.nbEtals = nbEtals;
			this.etals = new Etal[nbEtals];
			for (int i = 0; i < nbEtals; i++) {
				this.etals[i] = new Etal();
			}
		}

		private void utiliserEtal(int indiceEtal, Gaulois vendeur, String produit, int nbProduit) {
			etals[indiceEtal].occuperEtal(vendeur, produit, nbProduit);
		}

		public int trouverEtalLibre() {
			for (int i = 0; i < nbEtals; i++)
				if (!etals[i].isEtalOccupe()) {
					return i;
				}
			return -1;
		}

		private Etal[] trouverEtals(String produit) {
			int etalsTrouves = 0;
			for (int i = 0; i < nbEtals; i++) {
				if (etals[i].contientProduit(produit)) {
					etalsTrouves++;
				}
			}
			Etal[] etalsVendantPrd = new Etal[etalsTrouves];
			int indiceEtal = 0;
			for (int i = 0; i < nbEtals; i++) {
				if (etals[i].contientProduit(produit)) {
					etalsVendantPrd[indiceEtal] = etals[i];
					indiceEtal++;
				}
			}
			return etalsVendantPrd;
		}

		private Etal trouverVendeur(Gaulois gaulois) {
			for (int i = 0; i < nbEtals; i++) {
				if (etals[i].getVendeur() == gaulois) {
					return etals[i];
				}
			}
			return null;
		}

		public String afficherMarche() {
			int nbEtalVide = 0;
			for (int i = 0; i < nbEtals; i++) {
				if (etals[i].isEtalOccupe()) {
					etals[i].afficherEtal();
				} else {
					nbEtalVide++;
				}
			}
			return ("Il reste " + nbEtalVide + " etals non utilises dans le marche. \n");
		}
	}

}