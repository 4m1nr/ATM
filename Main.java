import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class Main extends JFrame {
    static int panelNumber = 0;
    static boolean passwordIsTrue = false;
    
    public static void main(String[] args){

        //frame and structure config
        Font buttonsFont = new Font(Font.SERIF,Font.BOLD,14);
        Font mainFont = new Font(Font.SERIF,Font.PLAIN,18);


        JFrame Frame = new JFrame("ATM");
        Frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Frame.setResizable(false);

        JLabel frameBackground = new JLabel(new ImageIcon("src\\ATM.jpg"));
        Frame.add(frameBackground);

        JPanel contentPanel = new JPanel(new CardLayout());
        frameBackground.add(contentPanel);
        contentPanel.setBounds(74,71,378,312);

        JPanel leftButtonsPanel = new JPanel(new GridLayout(3,1,0,1));
        frameBackground.add(leftButtonsPanel);
        leftButtonsPanel.setBounds(10,225,58,157);


        JPanel rightButtonsPanel = new JPanel(new GridLayout(3,1,0,1));
        frameBackground.add(rightButtonsPanel);
        rightButtonsPanel.setBounds(458,225,58,157);

        JButton[] Button_ = new JButton[6];
        for (int i = 0; i < 6; i++) Button_[i] = new JButton();
        Button_[2].setText("بازگشت");
        Button_[2].setFont(new Font(Font.SERIF,Font.BOLD,9));
        Button_[5].setText("ثبت");
        for (int i = 3; i < 6; i++) rightButtonsPanel.add(Button_[i]);
        for (int i = 0; i < 3; i++) leftButtonsPanel.add(Button_[i]);

        Rectangle[] buttonPosition = new Rectangle[6];
        buttonPosition[0] = new Rectangle(10,170,50,20);
        buttonPosition[1] = new Rectangle(10,220,50,20);
        buttonPosition[2] = new Rectangle(10,270,50,20);
        buttonPosition[3] = new Rectangle(318,170,50,20);
        buttonPosition[4] = new Rectangle(318,220,50,20);
        buttonPosition[5] = new Rectangle(318,270,50,20);



        //panels config//


        //welcome panel

        JPanel welcomePanel = new JPanel(null);
        welcomePanel.setBackground(Color.CYAN);

        JLabel chooseLanguageLanguage = new JLabel("زبان خود را انتخاب کنید" + "        " + "Choose language", SwingConstants.CENTER);
        chooseLanguageLanguage.setBounds(25,50,338,30);
        chooseLanguageLanguage.setFont(mainFont);

        JLabel farsiLanguageButtonText = new JLabel("English");
        farsiLanguageButtonText.setFont(buttonsFont);
        farsiLanguageButtonText.setBounds(buttonPosition[3]);


        JLabel englishLanguageButtonText = new JLabel("فارسی");
        englishLanguageButtonText.setFont(buttonsFont);
        englishLanguageButtonText.setBounds(buttonPosition[0]);

        welcomePanel.add(chooseLanguageLanguage);
        welcomePanel.add(farsiLanguageButtonText);
        welcomePanel.add(englishLanguageButtonText);

        //entrance panel

        JPanel entrancePanel = new JPanel(null);
        entrancePanel.setBackground(Color.CYAN);

        JLabel passwordInputText = new JLabel( "رمز خود را وارد کنید" , JLabel.CENTER);
        passwordInputText.setBounds(89,100,200,25);
        passwordInputText.setFont(mainFont);

        JPasswordField passwordInputField = new JPasswordField();
        passwordInputField.setHorizontalAlignment(JPasswordField.CENTER);
        passwordInputField.setBounds(89,150,200,40);
        passwordInputField.setFont(new Font(Font.SERIF,Font.BOLD,25));

        entrancePanel.add(passwordInputText);
        entrancePanel.add(passwordInputField);

        //menu panel

        JPanel menuPanel = new JPanel(null);
        menuPanel.setBackground(Color.CYAN);


        JLabel withdrawalButtonText = new JLabel("برداشت",SwingConstants.CENTER);
        withdrawalButtonText.setFont(buttonsFont);
        withdrawalButtonText.setBounds(buttonPosition[0]);

        JLabel transferButtonText = new JLabel("انتفال",SwingConstants.CENTER);
        transferButtonText.setFont(buttonsFont);
        transferButtonText.setBounds(buttonPosition[1]);

        JLabel balanceEnquiryButtonText = new JLabel("موجودی",SwingConstants.CENTER);
        balanceEnquiryButtonText.setFont(buttonsFont);
        balanceEnquiryButtonText.setBounds(buttonPosition[3]);

        JLabel pinChangeButtonText = new JLabel("تغییر رمز", SwingConstants.CENTER);
        pinChangeButtonText.setFont(buttonsFont);
        pinChangeButtonText.setBounds(buttonPosition[4]);

        menuPanel.add(withdrawalButtonText);
        menuPanel.add(transferButtonText);
        menuPanel.add(pinChangeButtonText);
        menuPanel.add(balanceEnquiryButtonText);

        //withdrawal panel
        JPanel withdrawalPanel = new JPanel(null);
        withdrawalPanel.setBackground(Color.CYAN);

        JLabel withdrawal10$ButtonText = new JLabel("10$");
        withdrawal10$ButtonText.setFont(buttonsFont);
        withdrawal10$ButtonText.setBounds(buttonPosition[0]);

        JLabel withdrawal50$ButtonText = new JLabel("50$");
        withdrawal50$ButtonText.setFont(buttonsFont);
        withdrawal50$ButtonText.setBounds(buttonPosition[1]);

        JLabel withdrawal100$ButtonText = new JLabel("100$");
        withdrawal100$ButtonText.setFont(buttonsFont);
        withdrawal100$ButtonText.setBounds(buttonPosition[3]);

        JLabel withdrawal200$ButtonText = new JLabel("200$");
        withdrawal200$ButtonText.setFont(buttonsFont);
        withdrawal200$ButtonText.setBounds(buttonPosition[4]);

        withdrawalPanel.add(withdrawal10$ButtonText);
        withdrawalPanel.add(withdrawal50$ButtonText);
        withdrawalPanel.add(withdrawal100$ButtonText);
        withdrawalPanel.add(withdrawal200$ButtonText);

        //PIN change panel

        JPanel pinChangePanel = new JPanel(null);
        pinChangePanel.setBackground(Color.CYAN);

        JLabel passwordChangeText = new JLabel( "رمز جدید را وارد کنید" , JLabel.CENTER);
        passwordChangeText.setBounds(89,100,200,25);
        passwordChangeText.setFont(mainFont);


        JPasswordField passwordChangeInputField = new JPasswordField();
        passwordChangeInputField.setHorizontalAlignment(JPasswordField.CENTER);
        passwordChangeInputField.setBounds(89,150,200,40);
        passwordChangeInputField.setFont(new Font(Font.SERIF,Font.BOLD,25));


        pinChangePanel.add(passwordChangeText);
        pinChangePanel.add(passwordChangeInputField);

        //transfer panel

        JPanel transferPanel = new JPanel(null);
        transferPanel.setBackground(Color.CYAN);

        JLabel transferAmountText = new JLabel( "مبلغ انتفال را وارد کنید" , JLabel.CENTER);
        transferAmountText.setBounds(89,50,200,25);
        transferAmountText.setFont(mainFont);

        JTextField transferAmountField = new JTextField();
        transferAmountField.setHorizontalAlignment(JTextField.CENTER);
        transferAmountField.setBounds(89,85,200,40);
        transferAmountField.setFont(new Font(Font.SERIF,Font.PLAIN,16));

        JLabel transferDestinationText = new JLabel( "شماره کارت مقصد را وارد کنید" , JLabel.CENTER);
        transferDestinationText.setBounds(89,175,200,25);
        transferDestinationText.setFont(mainFont);

        JTextField transferDestinationField = new JTextField();
        transferDestinationField.setHorizontalAlignment(JTextField.CENTER);
        transferDestinationField.setBounds(89,210,200,40);
        transferDestinationField.setFont(new Font(Font.SERIF,Font.PLAIN,16));

        transferPanel.add(transferAmountText);
        transferPanel.add(transferAmountField);
        transferPanel.add(transferDestinationText);
        transferPanel.add(transferDestinationField);


        //balance Enquiry panel

        JPanel balanceEnquiryPanel = new JPanel(null);
        balanceEnquiryPanel.setBackground(Color.CYAN);

        JLabel balanceEnquiryText = new JLabel("موجودی شما N/A است", SwingConstants.CENTER);
        balanceEnquiryText.setFont(mainFont);
        balanceEnquiryText.setBounds(89,100,200,25);

        balanceEnquiryPanel.add(balanceEnquiryText);

        //ssss panel

        JPanel resultPanel = new JPanel(null);
        resultPanel.setBackground(Color.CYAN);


        JLabel resultText = new JLabel("عملیات با موفقیت انجام شد" , SwingConstants.CENTER);
        resultText.setFont(mainFont);
        resultText.setBounds(89,100,200,25);

        resultPanel.add(resultText);

        //Action listener config

        Button_[0].addActionListener(e -> {
            if(panelNumber == 0) {
                if(passwordIsTrue) {
                    contentPanel.remove(0);
                    contentPanel.add(menuPanel);
                    panelNumber = 2;
                }else {
                    contentPanel.remove(0);
                    contentPanel.add(entrancePanel);
                    panelNumber = 1;
                }
            }else if (panelNumber== 2){
                contentPanel.remove(0);
                contentPanel.add(withdrawalPanel);
                panelNumber = 10;
            }else if (panelNumber == 3){
                contentPanel.remove(0);
                contentPanel.add(resultPanel);
                panelNumber=-1;
            }else if (panelNumber == 10) {
                contentPanel.remove(0);
                contentPanel.add(resultPanel);
                panelNumber = -1;
            }
            Frame.revalidate();
            Frame.repaint();
        });

        Button_[1].addActionListener(e -> {
            if(panelNumber == 2) {
                contentPanel.remove(0);
                contentPanel.add(transferPanel);
                panelNumber = 11;
            }else if (panelNumber == 3){
                contentPanel.remove(0);
                contentPanel.add(resultPanel);
                panelNumber=-1;
            }else if (panelNumber == 10) {
                contentPanel.remove(0);
                contentPanel.add(resultPanel);
                panelNumber = -1;
            }
            Frame.revalidate();
            Frame.repaint();
        });

        Button_[2].addActionListener(e -> {
            if(panelNumber > 2 || panelNumber == -1) {
                contentPanel.remove(0);
                contentPanel.add(menuPanel);
                panelNumber = 2;
            }else if (panelNumber > 0){
                contentPanel.remove(0);
                contentPanel.add(welcomePanel);
                panelNumber=0;
            }
            Frame.revalidate();
            Frame.repaint();
        });

        Button_[3].addActionListener(e -> {
            if(panelNumber == 2) {
                contentPanel.remove(0);
                contentPanel.add(balanceEnquiryPanel);
                panelNumber = 12;
            }else if (panelNumber == 10){
                contentPanel.remove(0);
                contentPanel.add(resultPanel);
                panelNumber=-1;
            }
            Frame.revalidate();
            Frame.repaint();
        });

        Button_[4].addActionListener(e -> {
            if(panelNumber == 2) {
                contentPanel.remove(0);
                contentPanel.add(pinChangePanel);
                panelNumber = 13;
            }else if (panelNumber == 10){
                contentPanel.remove(0);
                contentPanel.add(resultPanel);
                panelNumber=-1;
            }
            Frame.revalidate();
            Frame.repaint();
        });

        Button_[5].addActionListener(e -> {
            if(panelNumber == 1) {
                if(passwordInputField.getPassword().length>0) passwordIsTrue= true ;
                if(passwordIsTrue){
                contentPanel.remove(0);
                contentPanel.add(menuPanel);
                panelNumber = 2;
                }else passwordInputText.setText("رمز نمی تواند خالی باشد !!!");
            }else if (panelNumber == 11 ){
                if (!transferDestinationField.getText().isEmpty() && !transferAmountField.getText().isEmpty()) {
                    contentPanel.remove(0);
                    contentPanel.add(resultPanel);
                    panelNumber = -1;
                }else {
                    if (transferDestinationField.getText().isEmpty()) transferDestinationField.setText("نمیتواند خالی باشد");
                    if (transferAmountField.getText().isEmpty()) transferAmountField.setText("نمیتواند خالی باشد");
                }

            }else if (panelNumber == 13 && passwordChangeInputField.getPassword().length>0) {
                contentPanel.remove(0);
                contentPanel.add(resultPanel);
                panelNumber = -1;
            }else if(panelNumber == -1)
                Frame.dispatchEvent(new WindowEvent(Frame, WindowEvent.WINDOW_CLOSING));
            Frame.revalidate();
            Frame.repaint();
        });

        contentPanel.add(welcomePanel);
        Frame.revalidate();
        Frame.repaint();
        Frame.pack();
        Frame.setVisible(true);
    }
}




