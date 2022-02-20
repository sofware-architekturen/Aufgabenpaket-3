package model;

public class Artikel
{
  private String artikelId = null;
  
  public Artikel(String id)
  {
    super();
    this.artikelId = id;
  }
  

  public String getArtikelId()
  {
    return this.artikelId;
  }

  public void setArtikelId(String artikelId)
  {
    this.artikelId = artikelId;
  }
}
