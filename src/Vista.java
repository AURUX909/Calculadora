import javax.swing.*;
import java.awt.event.ActionListener;

public class Vista extends JFrame {
    private JTextField txtVer;
    private JButton[] botonesNumeros;
    private JButton btnSuma, btnResta, btnMul, btnDiv, btnResultado, btnBorrar, btnSalir;

    public Vista() {
        initComponents();
    }

    private void initComponents() {
        txtVer = new JTextField();
        txtVer.setEditable(false);
        txtVer.setFont(new java.awt.Font("Segoe UI", 0, 24));

        botonesNumeros = new JButton[10];
        for (int i = 0; i < 10; i++) {
            botonesNumeros[i] = new JButton(String.valueOf(i));
            botonesNumeros[i].setFont(new java.awt.Font("Segoe UI", 0, 24));
        }

        btnSuma = new JButton("+");
        btnResta = new JButton("-");
        btnMul = new JButton("x");
        btnDiv = new JButton("÷");
        btnResultado = new JButton("=");
        btnBorrar = new JButton("C");
        btnSalir = new JButton("X");

        // Estilo de los botones de operaciones
        btnSuma.setFont(new java.awt.Font("Segoe UI", 0, 24));
        btnResta.setFont(new java.awt.Font("Segoe UI", 0, 24));
        btnMul.setFont(new java.awt.Font("Segoe UI", 0, 24));
        btnDiv.setFont(new java.awt.Font("Segoe UI", 0, 24));
        btnResultado.setFont(new java.awt.Font("Segoe UI", 0, 24));
        btnBorrar.setFont(new java.awt.Font("Segoe UI", 0, 24));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 0, 24));
        btnSalir.setBackground(new java.awt.Color(255, 0, 51));

        // Configuración del layout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(txtVer, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(botonesNumeros[7])
                            .addComponent(botonesNumeros[8])
                            .addComponent(botonesNumeros[9])
                            .addComponent(btnDiv))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(botonesNumeros[4])
                            .addComponent(botonesNumeros[5])
                            .addComponent(botonesNumeros[6])
                            .addComponent(btnMul))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(botonesNumeros[1])
                            .addComponent(botonesNumeros[2])
                            .addComponent(botonesNumeros[3])
                            .addComponent(btnResta))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(botonesNumeros[0])
                            .addComponent(btnBorrar)
                            .addComponent(btnSalir)
                            .addComponent(btnSuma))
                        .addComponent(btnResultado, GroupLayout.Alignment.CENTER, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                    )
                )
        );
        layout.setVerticalGroup(
    layout.createSequentialGroup()
        .addComponent(txtVer, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
        .addGap(10)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(botonesNumeros[7], GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
            .addComponent(botonesNumeros[8], GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
            .addComponent(botonesNumeros[9], GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnDiv, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
        .addGap(10)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(botonesNumeros[4], GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
            .addComponent(botonesNumeros[5], GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
            .addComponent(botonesNumeros[6], GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnMul, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
        .addGap(10)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(botonesNumeros[1], GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
            .addComponent(botonesNumeros[2], GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
            .addComponent(botonesNumeros[3], GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnResta, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
        .addGap(10)
        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(botonesNumeros[0], GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnBorrar, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
            .addComponent(btnSuma, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
        .addGap(10)
        .addComponent(btnResultado, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
        .addGap(20)
);

pack();  // Ajusta el tamaño de la ventana al contenido
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setTitle("Calculadora");
setLocationRelativeTo(null);  // Centra la ventana en la pantalla
}

// Método para agregar listeners a todos los botones
public void agregarListeners(ActionListener controlador) {
    for (JButton boton : botonesNumeros) {
        boton.addActionListener(controlador);
    }
    btnSuma.addActionListener(controlador);
    btnResta.addActionListener(controlador);
    btnMul.addActionListener(controlador);
    btnDiv.addActionListener(controlador);
    btnResultado.addActionListener(controlador);
    btnBorrar.addActionListener(controlador);
    btnSalir.addActionListener(controlador);
}

// Métodos de acceso
public JTextField getTxtVer() {
    return txtVer;
}

public void setTxtResultado(String resultado) {
    txtVer.setText(resultado);
}

public void mostrarError(String mensaje) {
    JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
}
}