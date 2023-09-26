package com.application;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.SecureRandom;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class RandomPasswordGenerator {

    private JFrame frmRandomPasswordGenerator;
    private JTextField outputField;
    private JTextField passwordLength;
    private JCheckBox ckbbxUpper;
    private JCheckBox chkbxLower;
    private JCheckBox chkbxNumbers;
    private JCheckBox chkbxSymbols;
    private JPanel panelinside;
    private JPanel paneloutside;
    private JButton copyButton;
    private JButton clearButton;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RandomPasswordGenerator window = new RandomPasswordGenerator();
                    window.frmRandomPasswordGenerator.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public RandomPasswordGenerator() {
        initialize();
    }

    private void initialize() {
        frmRandomPasswordGenerator = new JFrame();
        frmRandomPasswordGenerator.setIconImage(Toolkit.getDefaultToolkit().getImage("icon/reset-password.png"));
        frmRandomPasswordGenerator.setTitle("Random Password generator");
        frmRandomPasswordGenerator.setAutoRequestFocus(false);
        frmRandomPasswordGenerator.getContentPane().setEnabled(false);
        frmRandomPasswordGenerator.getContentPane().setBackground(Color.DARK_GRAY);
        frmRandomPasswordGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmRandomPasswordGenerator.setBounds(100, 100, 569, 422);
        frmRandomPasswordGenerator.getContentPane().setLayout(null);
        frmRandomPasswordGenerator.setResizable(false);

        outputField = new JTextField();
        outputField.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        outputField.setBounds(49, 82, 458, 25);
        frmRandomPasswordGenerator.getContentPane().add(outputField);
        outputField.setColumns(10);

        ckbbxUpper = new JCheckBox("Upper Case");
        ckbbxUpper.setForeground(Color.WHITE);
        ckbbxUpper.setBackground(Color.DARK_GRAY);
        ckbbxUpper.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        ckbbxUpper.setBounds(143, 170, 135, 21);
        frmRandomPasswordGenerator.getContentPane().add(ckbbxUpper);

        chkbxLower = new JCheckBox("Lower Case");
        chkbxLower.setForeground(Color.WHITE);
        chkbxLower.setBackground(Color.DARK_GRAY);
        chkbxLower.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        chkbxLower.setBounds(290, 170, 135, 21);
        frmRandomPasswordGenerator.getContentPane().add(chkbxLower);

        chkbxNumbers = new JCheckBox("Numbers");
        chkbxNumbers.setForeground(Color.WHITE);
        chkbxNumbers.setBackground(Color.DARK_GRAY);
        chkbxNumbers.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        chkbxNumbers.setBounds(143, 195, 135, 21);
        frmRandomPasswordGenerator.getContentPane().add(chkbxNumbers);

        chkbxSymbols = new JCheckBox("Symbols");
        chkbxSymbols.setForeground(Color.WHITE);
        chkbxSymbols.setBackground(Color.DARK_GRAY);
        chkbxSymbols.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        chkbxSymbols.setBounds(290, 195, 135, 21);
        frmRandomPasswordGenerator.getContentPane().add(chkbxSymbols);

        JLabel lblPasswordLength = new JLabel("Password Length");
        lblPasswordLength.setForeground(Color.WHITE);
        lblPasswordLength.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        lblPasswordLength.setBounds(165, 239, 135, 19);
        frmRandomPasswordGenerator.getContentPane().add(lblPasswordLength);

        passwordLength = new JTextField();
        passwordLength.setForeground(Color.BLACK);
        passwordLength.setBackground(Color.WHITE);
        passwordLength.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        passwordLength.setColumns(10);
        passwordLength.setBounds(311, 234, 30, 30);
        frmRandomPasswordGenerator.getContentPane().add(passwordLength);

        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        generateButton.setBounds(49, 293, 150, 32);
        frmRandomPasswordGenerator.getContentPane().add(generateButton);

        copyButton = new JButton("Copy Password");
        copyButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        copyButton.setBounds(203, 293, 150, 32);
        frmRandomPasswordGenerator.getContentPane().add(copyButton);

        clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        clearButton.setBounds(357, 293, 150, 32);
        frmRandomPasswordGenerator.getContentPane().add(clearButton);

        JLabel lblPasswordGenerator = new JLabel("Password Generator");
        lblPasswordGenerator.setForeground(Color.WHITE);
        lblPasswordGenerator.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
        lblPasswordGenerator.setBounds(176, 53, 198, 19);
        frmRandomPasswordGenerator.getContentPane().add(lblPasswordGenerator);

        panelinside = new JPanel();
        panelinside.setBackground(Color.DARK_GRAY);
        panelinside.setBounds(49, 117, 458, 166);
        panelinside.setBorder(new LineBorder(Color.YELLOW, 1)); // Add a white border with a 1-pixel size
        frmRandomPasswordGenerator.getContentPane().add(panelinside);

        JLabel lblNewLabel = new JLabel("Customize Password");
        lblNewLabel.setForeground(Color.WHITE);
        panelinside.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 15));

        paneloutside = new JPanel();
        paneloutside.setBackground(Color.DARK_GRAY);
        paneloutside.setBounds(23, 38, 507, 319);
        paneloutside.setBorder(new LineBorder(Color.YELLOW, 1)); // Add a white border with a 1-pixel size
        frmRandomPasswordGenerator.getContentPane().add(paneloutside);

        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generatePassword();
            }
        });

        copyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                copyToClipboard(outputField.getText());
                JOptionPane.showMessageDialog(frmRandomPasswordGenerator, "Password copied to clipboard!", "Copy Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputField.setText("");
            }
        });

        // Handle Enter key press
        passwordLength.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    generatePassword();
                }
            }
        });
    }

    private void generatePassword() {
        SecureRandom random = new SecureRandom();
        String characters = "";

        if (ckbbxUpper.isSelected()) {
            characters += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }
        if (chkbxLower.isSelected()) {
            characters += "abcdefghijklmnopqrstuvwxyz";
        }
        if (chkbxNumbers.isSelected()) {
            characters += "0123456789";
        }
        if (chkbxSymbols.isSelected()) {
            characters += "!@#$%^&*()_+";
        }

        int length;

        try {
            length = Integer.parseInt(passwordLength.getText());
        } catch (NumberFormatException e) {
            length = 6; // Default length if parsing fails
        }

        if (length <= 0) {
            JOptionPane.showMessageDialog(frmRandomPasswordGenerator, "Password can't be 0 or a negative number", "Invalid Password Length", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (characters.isEmpty()) {
            characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        }

        StringBuilder passwordBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            passwordBuilder.append(randomChar);
        }
        String password = passwordBuilder.toString();
        outputField.setText(password);
    }

    private void copyToClipboard(String text) {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}
