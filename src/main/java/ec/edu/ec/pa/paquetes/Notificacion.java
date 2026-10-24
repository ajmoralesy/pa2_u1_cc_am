package ec.edu.ec.pa.paquetes;

public interface Notificacion {
    public void enviar(String destino, String mensaje);

    public Integer getCantidad();

    public void setCantidad(Integer cantidad);

    public String getNombre();

    public void setNombre(String nombre);
}
