import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controlador implements ActionListener {
    private Modelo modelo;
    private Vista vista;
    private float num1, num2;
    private String operador;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.agregarListeners(this);  // Método agregado en Vista para simplificar el manejo de listeners
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String textoBoton = ((javax.swing.JButton) source).getText();

        try {
            switch (textoBoton) {
                case "+":
                case "-":
                case "x":
                case "÷":
                    operador = textoBoton;
                    num1 = Float.parseFloat(vista.getTxtVer().getText());
                    vista.getTxtVer().setText("");
                    break;
                case "=":
                    num2 = Float.parseFloat(vista.getTxtVer().getText());
                    float resultado = realizarOperacion();
                    vista.setTxtResultado(String.valueOf(resultado));
                    break;
                case "C":
                    vista.getTxtVer().setText("");
                    break;
                case "X":
                    int confirmacion = JOptionPane.showConfirmDialog(vista, "¿Seguro desea salir?", "Saliendo", JOptionPane.YES_NO_OPTION);
                    if (confirmacion == JOptionPane.YES_OPTION) System.exit(0);
                    break;
                default:
                    vista.getTxtVer().setText(vista.getTxtVer().getText() + textoBoton);
                    break;
            }
        } catch (NumberFormatException ex) {
            vista.mostrarError("Formato de número incorrecto.");
        }
    }

    private float realizarOperacion() {
        switch (operador) {
            case "+": return modelo.suma(num1, num2);
            case "-": return modelo.resta(num1, num2);
            case "x": return modelo.multiplicacion(num1, num2);
            case "÷":
                if (num2 != 0) return modelo.division(num1, num2);
                else {
                    vista.mostrarError("No se puede dividir entre cero.");
                    return 0;
                }
            default: return 0;
        }
    }
}