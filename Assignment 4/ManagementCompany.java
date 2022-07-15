import java.util.String;

// Class
public class ManagementCompany()
{
  private String name;
  private String taxID;
  private Property[] properties;
  private double mgmFeePer;
  private final double MAX_PROPERTY = 5;
  private final double MGMT_WIDTH = 10;
  private final double MGMT_HEIGHT = 10;
  private Plot plot;
  
  // Constructor
  public ManagementCompany()
  { 
    name = "";
    taxID = "";
    properties = new Property[MAX_PROPERTY];
    mgmFeePer = 0.0;
  }
  
  // Constructor 2
  public ManagementCompany(String name, String taxID, double mgmFee)
  {
    this.name = name;
    this.taxID = taxID;
    this.mgmFeePer = mgmFee;
    plot = new Plot();
    properties = new Property[MAX_PROPERTY];
  }
  
  // Constructor 3
  public ManagementCompany(String name, String taxID, double mgmFee,
                           int x, int y, int width, int depth)
  {
    this.name = name;
    this.taxID = taxID;
    this.mgmFeePer = mgmFee;
    plot = new Plot();
    properties = new Property[MAX_PROPERTY];
  }
  
  // Copy Constructor
  public ManagementCompany(ManagementCompany otherCompany)
  {
    this.properties = otherCompany.properties;
  }
  
  // Method addProperty Version 1
  public void addProperty(Property object)
  {
    properties = object.ManagementCompany();
  }
  
  // Method addProperty Version 2
  public void addProperty(String propertyName, String city, double rent, String ownerName)
  {
      
  }
  
  // Method addProperty Version 3
  public void addProperty(String propertyName, String city, double rent, String ownerName,
                          int x, int y, int width, int depth)
  {
    
  }
}
