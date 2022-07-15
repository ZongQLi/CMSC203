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
    this.name = otherCompany.name;
    this.taxID = otherCompany.taxID;
    this.mgmFeePer = otherCompany.mgmFeePer;
    properties = new Property[MAX_PROPERTY];
  }
  
  // The getMAX_PROPERTY method returns the MAX_PROPERTY constant that represents the size of
  // the properties array
  public int getMAX_PROPERTY()
  {
    return MAX_PROPERTY;
  }
  
  // The first version of the addProperty method performs the following:
  // Adds the property object to the "properties" array
  // Returns either -1 if the array is full, -2 if the property is null,
  //                -3 if the plot is not contained by the MgmtCo plot,
  //                -4 of the plot overlaps any other property, or 
  //                the index in the array where the property was added successfully
  // Method addProperty Version 1
  public int addProperty(Property property)
  {
    int value = null;
    
    if(property.length == MAX_PROPERTY)
      value = -1;
    if(property.lenth == null)
      value = -2;
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
