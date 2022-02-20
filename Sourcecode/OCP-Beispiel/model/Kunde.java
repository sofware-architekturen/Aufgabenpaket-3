package model;

public class Kunde
{
  private int kundeId = 0;
  
  public Kunde(int id)
  {
    super();
    this.kundeId = id;
  }

  public int getKundeId()
  {
    return this.kundeId;
  }

  public void setKundeId(int kundeId)
  {
    this.kundeId = kundeId;
  }
}
