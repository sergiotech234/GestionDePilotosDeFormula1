public class Pilotos {
    private String nombre;
    private String escuderia;
    private int puntos;

    public Pilotos(String nombre, String escuderia, int puntos) {
        this.nombre = nombre;
        this.escuderia = escuderia;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    @Override
    public String toString() {
        return nombre + " " + escuderia + " " + puntos;
    }
    public String toFile(){
        return nombre + ";" + escuderia + ";" + puntos;
    }
}
