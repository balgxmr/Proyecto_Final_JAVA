public class Barco {
    private boolean seleccionado;
    private int tamaño;
    private String color;

    public Barco(int tamaño) {
        this.seleccionado = false;
        this.tamaño = tamaño;
    }

    public int getTamaño() {
        return tamaño;
    }

    public boolean getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado() {
        this.seleccionado = true;
    }

    public String getColor() {
        return color;
    }
}