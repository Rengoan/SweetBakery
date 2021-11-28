package sweetbakery.dominio;


public enum TipoProducto {
    
    TARTAPEQUENIA("Tarta pequeña"),
    TARTAMEDIANA("Tarta mediana"),
    TARTAGRANDE("Tarta grande"),
    TARTAEVENTO("Tarta de evento");
    
    
    private String producto;

    
    //Constructor

    private TipoProducto(String producto) {
        this.producto = producto;
        
    }

    //Getter and Setter

 
    public String getNombreProducto() {
        return producto;
    }

    public void setNombreProducto(String producto) {
        this.producto = producto;
    }
    
    
    
    
    
}
