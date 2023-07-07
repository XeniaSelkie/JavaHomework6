public class Notebook{
    private String name; 
    private Integer ram; 
    private Integer hd; 
    private String os; 
    private String colour; 

    
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setRam(Integer ram) {
        this.ram = ram;
    }
    public Integer getRam() {
        return ram;
    }
    public void setHd(Integer hd) {
        this.hd = hd;
    }
    public Integer getHd() {
        return hd;
    }
    public void setOs(String os) {
        this.os = os;
    }
    public String getOs() {
        return os;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
    public String getColour() {
        return colour;
    }
        
    public Notebook (String name, Integer ram, Integer hd, String os, String colour){
        this.name = name;
        this.ram = ram;
        this.hd = hd;
        this.os = os;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return name + "; " +
                "OM:" + ram +  "; " +
                "hdd: " + hd + "; " +
                "OS: " + os + "; " +
                "colour:" + colour + "; ";
    }
}