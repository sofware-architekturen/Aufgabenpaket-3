package model.util;

import java.util.List;

import model.Artikel;
import model.Kunde;

public class Sortierer
{
  public void sortiereArtikel(List<Artikel> artikelListe)
  {
    boolean swapped = true;
    int len = artikelListe.size();

    do
    {
      swapped = false;
      for (int i = 0; i < len - 1; ++i)
      {
        if (  artikelListe.get(i).getArtikelId().compareTo( artikelListe.get(i+1).getArtikelId() ) > 0 )
        {
          swapArtikel(i, i + 1, artikelListe);
          swapped = true;
        } 
      } 
      len = len - 1;
    } while (swapped == true);
  }

  public void sortiereKunden(List<Kunde> kundenListe)
  {
    boolean swapped = true;
    int len = kundenListe.size();

    do
    {
      swapped = false;
      for (int i = 0; i < len - 1; ++i)
      {
        if (  kundenListe.get(i).getKundeId() > kundenListe.get(i+1).getKundeId() )
        {
          swapKunde(i, i + 1, kundenListe);
          swapped = true;
        } 
      } 
      len = len - 1;
    } while (swapped == true);
  }

  private void swapArtikel(int i1, int i2, List<Artikel> artikelListe)
  {
    Artikel artikel = artikelListe.get(i2);
    artikelListe.set(i2, artikelListe.get(i1));
    artikelListe.set(i1, artikel);
  }
  
  private void swapKunde(int i1, int i2, List<Kunde> kundeListe)
  {
    Kunde kunde = kundeListe.get(i2);
    kundeListe.set(i2, kundeListe.get(i1));
    kundeListe.set(i1, kunde);
  }
}
