package sweetbakery.dominio;


public enum TipoProducto {
    
    TARTAGRANDE("Tarta grande"),
    TARTAMEDIANA("Tarta mediana"),
    CUPCAKES("Cupcakes"),
    ALFAJORES("Alfajores"),
    MESADULCE("Mesa dulce");
    
    private String nombreProducto;

    
    //Constructor
    private TipoProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    
    //Getter and Setter

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    
    
    
    
    
}
