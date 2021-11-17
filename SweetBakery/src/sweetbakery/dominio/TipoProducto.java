package sweetbakery.dominio;


public enum TipoProducto {
    
    TARTAGRANDE("Tarta grande",1),
    TARTAMEDIANA("Tarta mediana",2),
    CUPCAKES("Cupcakes",3),
    ALFAJORES("Alfajores",4),
    MESADULCE("Mesa dulce",5);
    
    private String nombreProducto;
    private int claveProducto;

    
    //Constructor

    private TipoProducto(String nombreProducto, int claveProducto) {
        this.nombreProducto = nombreProducto;
        this.claveProducto = claveProducto;
    }

    //Getter and Setter

    public int getClaveProducto() {
        return claveProducto;
    }

    public void setClaveProducto(int claveProducto) {
        this.claveProducto = claveProducto;
    }
    
    
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    
    
    
    
    
}
