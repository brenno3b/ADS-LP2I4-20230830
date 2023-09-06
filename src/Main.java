import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        final AlunoController alunoController = new AlunoController();

        final JFrame frame = new JFrame("TP02 - LP2I4");
        frame.setSize(400,180);

        final JPanel inputPanel = new JPanel();
        final GridLayout inputLayout = new GridLayout(3, 2, 10, 10);
        inputPanel.setLayout(inputLayout);

        final JTextField nomeTextField = new JTextField();
        final JTextField enderecoTextField = new JTextField();
        final JTextField idadeTextField = new JTextField();

        inputPanel.add(new JLabel("Nome: "));
        inputPanel.add(nomeTextField);
        inputPanel.add(new JLabel("Endereço: "));
        inputPanel.add(enderecoTextField);
        inputPanel.add(new JLabel("Idade: "));
        inputPanel.add(idadeTextField);

        final JPanel actionPanel = new JPanel();
        final GridLayout actionLayout = new GridLayout(1, 4, 10, 10);
        actionPanel.setLayout(actionLayout);

        final JButton okButton = new JButton("Ok");
        final JButton limparButton = new JButton("Limpar");
        final JButton mostrarButton = new JButton("Mostrar");
        final JButton sairButton = new JButton("Sair");

        okButton.addActionListener(e -> {
            try {
                final boolean isSuccess = alunoController.addAluno(
                        nomeTextField.getText(),
                        enderecoTextField.getText(),
                        Integer.parseInt(idadeTextField.getText())
                );

                if (isSuccess) {
                    nomeTextField.setText("");
                    enderecoTextField.setText("");
                    idadeTextField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Dados inválidos.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Idade inválida.");
            }
        });

        limparButton.addActionListener(e -> {
            nomeTextField.setText("");
            enderecoTextField.setText("");
            idadeTextField.setText("");
        });

        mostrarButton.addActionListener(e -> {
            StringBuilder message = new StringBuilder("Resultado:\n");

            for (Aluno aluno: alunoController.getAlunos()) {
                message.append("Id: ").append(aluno.getUuid()).append(" Nome: ").append(aluno.getNome()).append("\n");
            }

            JOptionPane.showMessageDialog(frame, message.toString());
        });

        sairButton.addActionListener(e -> {
            frame.dispose();
            System.exit(0);
        });

        actionPanel.add(okButton);
        actionPanel.add(limparButton);
        actionPanel.add(mostrarButton);
        actionPanel.add(sairButton);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(actionPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}