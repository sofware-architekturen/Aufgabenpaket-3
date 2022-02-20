package demo;

import java.util.LinkedList;
import java.util.List;

import model.Artikel;
import model.Kunde;
import model.util.Sortierer;

public class TestDriver
{

  public static void main(String[] args)
  {
    demoArtikel();
    demoKunde();
  }
  
  private static void demoKunde()
  {
    Sortierer sortierer = new Sortierer();
    
    List<Kunde> kundeListe = new LinkedList<>();
    
    kundeListe.add( new Kunde(20) );
    kundeListe.add( new Kunde(2) );
    kundeListe.add( new Kunde(0) );
    kundeListe.add( new Kunde(12) );
    kundeListe.add( new Kunde(12) );
    kundeListe.add( new Kunde(1) );
    
    
    sortierer.sortiereKunden(kundeListe);
    
    for( Kunde k : kundeListe )
    {
      System.out.println( k.getKundeId() );
    }
  }  
  
  private static void demoArtikel()
  {
    Sortierer sortierer = new Sortierer();
    
    List<Artikel> artikelListe = new LinkedList<>();
    
    artikelListe.add( new Artikel("zzz") );
    artikelListe.add( new Artikel("xyz") );
    artikelListe.add( new Artikel("abc") );
    artikelListe.add( new Artikel("xzz") );
    artikelListe.add( new Artikel("xyz") );
    artikelListe.add( new Artikel("aaa") );
    
    sortierer.sortiereArtikel(artikelListe);
    
    for( Artikel a : artikelListe )
    {
      System.out.println( a.getArtikelId() );
    }
  }
}
