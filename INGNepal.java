 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class INGNepal {

    public static void main(String[] args) {
        mainFrame mainFrame = new mainFrame();
    }
}

final class mainFrame extends JFrame {

    JLabel title;

    JPanel stvCard, staCard;

    JTextField vnTextAV, vnTextAP, dgText, snText, jtText, jdText, abText, qnText, whText, slryText, wphText;

    JComboBox stvCombo, staCombo, sftCombo;

    JButton addvButton, appButtonFT, appButtonPT, terButton, rtButtonFT, rtButtonPT, rtButtonAV, dispButtonAV, dispButtonAP;

    ArrayList<StaffHire> staffs = new ArrayList<>();

    mainFrame() {

        /*
         TEXT FIELDS WITH LABEL START
         */
        // Adding Vacancy Number Field
        JPanel vnPanelAV = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel vnLabelAV = new JLabel("Vacancy No:  ");
        vnTextAV = new JTextField(10);
        vnPanelAV.add(vnLabelAV);
        vnPanelAV.add(vnTextAV);

        // Adding Vacancy Number Field
        JPanel vnPanelAP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel vnLabelAP = new JLabel("Vacancy No:  ");
        vnTextAP = new JTextField(10);
        vnPanelAP.add(Box.createRigidArea(new Dimension(15, 0)));
        vnPanelAP.add(vnLabelAP);
        vnPanelAP.add(vnTextAP);

        // Adding Designation Field
        JPanel dgPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel dgLabel = new JLabel("      Designation:");
        dgText = new JTextField(10);
        dgPanel.add(dgLabel);
        dgPanel.add(dgText);

        // Adding StaffName Field
        JPanel snPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel snLabel = new JLabel("Staff Name:   ");
        snText = new JTextField(10);
        snPanel.add(snLabel);
        snPanel.add(snText);

        // Adding JobType Field
        JPanel jtPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel jtLabel = new JLabel("Job Type:  ");
        jtText = new JTextField(10);
        jtPanel.add(jtLabel);
        jtPanel.add(jtText);

        // Adding JoiningDate Field
        JPanel jdPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel jdLabel = new JLabel("Joining Date: ");
        jdText = new JTextField(10);
        jdPanel.add(jdLabel);
        jdPanel.add(jdText);

        // Adding Appointed By Field
        JPanel abPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel abLabel = new JLabel("Appointed By:");
        abText = new JTextField(10);
        abPanel.add(abLabel);
        abPanel.add(abText);

        // Adding Qualification Field
        JPanel qnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel qnLabel = new JLabel("Qualification:  ");
        qnText = new JTextField(10);
        qnPanel.add(qnLabel);
        qnPanel.add(qnText);

        // Adding Working Hour Field
        JPanel whPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel whLabel = new JLabel("Working Hour:");
        whText = new JTextField(10);
        whPanel.add(whLabel);
        whPanel.add(whText);

        // Adding Salary Field
        JPanel slryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel slryLabel = new JLabel("Salary:  ");
        slryText = new JTextField(10);
        slryPanel.add(slryLabel);
        slryPanel.add(slryText);

        // Adding Wages Per Hour Field
        JPanel wphPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel wphLabel = new JLabel("Wage P/H:");
        wphText = new JTextField(9);
        wphPanel.add(wphLabel);
        wphPanel.add(wphText);

        /*
         TEXTFIELDS WITH LABEL END
         */
        /*
         COMBOBOX START
         */
        // Staff Type Combo Box for Add Vacancy Fields
        JPanel stvPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel stvLabel = new JLabel("   Staff Type:   ");
        String stvFULLTIME = "Full Time";
        String stvPARTTIME = "Part Time";
        String stvComboItems[] = {stvFULLTIME, stvPARTTIME};
        stvCombo = new JComboBox(stvComboItems);
        stvCombo.addItemListener((ItemEvent e) -> {
            CardLayout c = (CardLayout) (stvCard.getLayout());
            c.show(stvCard, (String) e.getItem());
        });
        stvPanel.add(stvLabel);
        stvPanel.add(stvCombo);

        // Staff Type Combo Box for Appoint Fields
        JPanel staPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel staLabel = new JLabel("Staff Type:    ");
        String staFULLTIME = "Full Time";
        String staPARTTIME = "Part Time";
        String staComboItems[] = {staFULLTIME, staPARTTIME};
        staCombo = new JComboBox(staComboItems);
        staCombo.addItemListener((ItemEvent e) -> {
            CardLayout c = (CardLayout) (staCard.getLayout());
            c.show(staCard, (String) e.getItem());
        });
        staPanel.add(staLabel);
        staPanel.add(staCombo);

        //Shifts Combo Box
        JPanel sftPanel = new JPanel();
        JLabel sftLabel = new JLabel("Shifts:");
        String sftItems[] = {"Morning", "Day"};
        sftCombo = new JComboBox(sftItems);
        sftPanel.add(sftLabel);
        sftPanel.add(sftCombo);
        /*
         COMBOBOX END
         */

        /*
         BUTTONS START
         */
        addvButton = new JButton("Add Vacancy"); // Add Vacnacy Button
        addvButton.addActionListener((ActionEvent ae) -> {

            if (stvCombo.getSelectedItem().toString().equals("Full Time")) {
                if (checkValid(true, true)) {
                    addvacancyButtonClick(ae);
                }
            } else {
                if (checkValid(true, false)) {
                    addvacancyButtonClick(ae);
                }
            }

        });
        appButtonFT = new JButton("Appoint"); // Appoint Button
        appButtonFT.addActionListener((ActionEvent ae) -> {
            if(checkValid(false, true))
                appointButtonClick(ae);
        });
        appButtonPT = new JButton("Appoint"); // Appoint Button
        appButtonPT.addActionListener((ActionEvent ae) -> {
            if(checkValid(false, true))
                appointButtonClick(ae);
        });
        terButton = new JButton("Terminate"); // Terminate Button
        terButton.addActionListener((ActionEvent ae) -> {
            terminateButtonClick(ae);
        });
        rtButtonFT = new JButton("Reset"); // Reset Button
        rtButtonFT.addActionListener((ActionEvent ae) -> {
            resetButtonClick();
        });
        rtButtonPT = new JButton("Reset"); // Reset Button
        rtButtonPT.addActionListener((ActionEvent ae) -> {
            resetButtonClick();
        });
        rtButtonAV = new JButton("Reset"); // Reset Button
        rtButtonAV.addActionListener((ActionEvent ae) -> {
            resetButtonClick();
        });
        dispButtonAV = new JButton("Display"); // Display Button
        dispButtonAV.addActionListener((ActionEvent ae) -> {
            displayButtonClick(ae, stvCombo.getSelectedItem().toString());
        });
        dispButtonAP = new JButton("Display"); // Display Button
        dispButtonAP.addActionListener((ActionEvent ae) -> {
            displayButtonClick(ae, staCombo.getSelectedItem().toString());
        });
        /*
         BUTTONS END
         */

        // STAFF TYPE AND DISPLAY HOLDER IN VACANCY
        JPanel sftvDispHolder = new JPanel();
        sftvDispHolder.add(Box.createRigidArea(new Dimension(15, 0)));
        sftvDispHolder.setLayout(new BoxLayout(sftvDispHolder, BoxLayout.X_AXIS));
        sftvDispHolder.add(stvPanel);
        sftvDispHolder.add(dispButtonAV);
        sftvDispHolder.add(Box.createRigidArea(new Dimension(55, 0)));

        // VACANCY NUMBER AND DESIGNATION HOLDER 
        JPanel vndgHolder = new JPanel();
        vndgHolder.add(Box.createRigidArea(new Dimension(15, 0)));
        vndgHolder.setLayout(new BoxLayout(vndgHolder, BoxLayout.X_AXIS));
        vndgHolder.add(vnPanelAV);
        vndgHolder.add(dgPanel);

        // JOBTYPE AND WORKING HOUR HOLDER 
        JPanel jtwhHolder = new JPanel();
        jtwhHolder.add(Box.createRigidArea(new Dimension(30, 0)));
        jtwhHolder.setLayout(new BoxLayout(jtwhHolder, BoxLayout.X_AXIS));
        jtwhHolder.add(jtPanel);
        jtwhHolder.add(Box.createRigidArea(new Dimension(10, 0)));
        jtwhHolder.add(whPanel);

        // WAGES PER HOUR AND SHIFTS HOLDER 
        JPanel wphsftHolder = new JPanel();
        wphsftHolder.setLayout(new BoxLayout(wphsftHolder, BoxLayout.X_AXIS));
        wphsftHolder.add(wphPanel);
        wphsftHolder.add(Box.createRigidArea(new Dimension(52, 0)));
        wphsftHolder.add(sftPanel);

        // CARD LAYOUT HOLDER
        JPanel stvCardHolder = new JPanel(new FlowLayout(FlowLayout.LEFT));
        stvCard = new JPanel(new CardLayout());
        stvCard.add(slryPanel, stvFULLTIME);
        stvCard.add(wphsftHolder, stvPARTTIME);
        stvCardHolder.add(Box.createRigidArea(new Dimension(35, 0)));
        stvCardHolder.add(stvCard);

        // ADD VACANCY BUTTON AND RESET BUTTON HOLDER
        JPanel avrtHolder = new JPanel();
        avrtHolder.setLayout(new BoxLayout(avrtHolder, BoxLayout.X_AXIS));
        avrtHolder.add(addvButton);
        avrtHolder.add(Box.createRigidArea(new Dimension(95, 0)));
        avrtHolder.add(rtButtonAV);

        // STAFF TYPE AND DISPLAY HOLDER IN APPOINTED BY
        JPanel staDispHolder = new JPanel();
        staDispHolder.setLayout(new BoxLayout(staDispHolder, BoxLayout.X_AXIS));
        staDispHolder.add(Box.createRigidArea(new Dimension(25, 0)));
        staDispHolder.add(staPanel);
        staDispHolder.add(dispButtonAP);
        staDispHolder.add(Box.createRigidArea(new Dimension(55, 0)));

        // STAFF NAME AND JOINING DATE HOLDER
        JPanel snjdHolder = new JPanel();
        snjdHolder.setLayout(new BoxLayout(snjdHolder, BoxLayout.X_AXIS));
        snjdHolder.add(Box.createRigidArea(new Dimension(20, 0)));
        snjdHolder.add(snPanel);
        snjdHolder.add(jdPanel);

        // QUALIFICATION AND APPOINTED BY HOLDER
        JPanel qnabHolder = new JPanel();
        qnabHolder.setLayout(new BoxLayout(qnabHolder, BoxLayout.X_AXIS));
        qnabHolder.add(Box.createRigidArea(new Dimension(15, 0)));
        qnabHolder.add(qnPanel);
        qnabHolder.add(abPanel);

        // APPOINT AND RESET BUTTON HOLDER
        JPanel aprtButtonHolder = new JPanel();
        aprtButtonHolder.setLayout(new BoxLayout(aprtButtonHolder, BoxLayout.X_AXIS));
        aprtButtonHolder.add(appButtonFT);
        aprtButtonHolder.add(Box.createRigidArea(new Dimension(122, 0)));
        aprtButtonHolder.add(rtButtonFT);

        // APPOINT TERMINATE AND RESET BUTTON HOLDER
        JPanel apterrtButtonHolder = new JPanel();
        apterrtButtonHolder.setLayout(new BoxLayout(apterrtButtonHolder, BoxLayout.X_AXIS));
        apterrtButtonHolder.add(appButtonPT);
        apterrtButtonHolder.add(Box.createRigidArea(new Dimension(15, 0)));
        apterrtButtonHolder.add(terButton);
        apterrtButtonHolder.add(Box.createRigidArea(new Dimension(15, 0)));
        apterrtButtonHolder.add(rtButtonPT);

        // CARD LAYOUT HOLDER FOR APPOINT
        JPanel staCardHolder = new JPanel();
        staCard = new JPanel(new CardLayout());
        staCard.add(aprtButtonHolder, staFULLTIME);
        staCard.add(apterrtButtonHolder, staPARTTIME);
        staCardHolder.add(staCard);

        // ADD VACANCY CONTAINER
        JPanel avContainer = new JPanel();
        avContainer.setLayout(new BoxLayout(avContainer, BoxLayout.Y_AXIS));
        avContainer.add(sftvDispHolder);
        avContainer.add(vndgHolder);
        avContainer.add(jtwhHolder);
        avContainer.add(stvCardHolder);
        avContainer.add(avrtHolder);
        avContainer.add(Box.createRigidArea(new Dimension(0, 19)));

        // APPOINT CONTAINER
        JPanel apContainer = new JPanel();
        apContainer.setLayout(new BoxLayout(apContainer, BoxLayout.Y_AXIS));
        apContainer.add(staDispHolder);
        apContainer.add(vnPanelAP);
        apContainer.add(snjdHolder);
        apContainer.add(qnabHolder);
        apContainer.add(staCardHolder);

        //Tabbed Pane
        JPanel a = new JPanel();
        a.setLayout(new BorderLayout());
        a.add(avContainer);

        JPanel b = new JPanel();
        b.setLayout(new BorderLayout());
        b.add(apContainer);

        JTabbedPane tb = new JTabbedPane();
        tb.add("Add Vacancy", a);
        tb.add("Appoint", b);
        setTitle("INGNepal StaffHire");

        JPanel outer = new JPanel();
        outer.setLayout(new BorderLayout());
        outer.add(tb, BorderLayout.CENTER);
        add(outer);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setSize(550, 300);
    }

    // THE TWO PARAMETERS GIVE THIS METHOD THE IDEA TO CHECK VALIDITY OF WHICH FORM
    // THE va VARIABLE INDICATES WETHER IT'S FROM VACANCY FIELD OR APPOINT FIELD
    // THE fp VARIABLE INDICATES WETHER IT'S FROM FULLTIME OF PARTTIME
    boolean checkValid(boolean va, boolean fp) {
        if (va) { // va = true means we gotta check validity of add vacancy form
            try {
                if (vnTextAV.getText().trim().isEmpty() || dgText.getText().trim().isEmpty() || jtText.getText().trim().isEmpty() || whText.getText().trim().isEmpty()) {
                    throw new InterruptedException();
                }

                if (fp) { // fp == true when it's about FullTime Staff
                    if (slryText.getText().isEmpty()) {
                        throw new InterruptedException();
                    }
                } else {
                    if (wphText.getText().isEmpty()) {
                        throw new InterruptedException();
                    }
                }
                Integer.parseInt(vnTextAV.getText().trim());
                Integer.parseInt(whText.getText().trim());

                if (fp) // fp == true when it's about FullTime Staff
                {
                    Integer.parseInt(slryText.getText().trim());
                } else {
                    Integer.parseInt(wphText.getText().trim());
                }

            } catch (InterruptedException ie) {
                System.out.println("emptyfields");
                JOptionPane.showMessageDialog(null, "Please fill all the fields.");
                return false;
            } catch (NumberFormatException ne) {
                System.out.println("invalid");
                JOptionPane.showMessageDialog(null, "You can't input string in Vacancy no, \nworking hour or salary fields");
                return false;
            }
        } else { // va = false means we gotta check validity of appoint form
            try {
                if (vnTextAP.getText().trim().isEmpty() || snText.getText().trim().isEmpty() || jdText.getText().trim().isEmpty() || qnText.getText().trim().isEmpty() || abText.getText().trim().isEmpty()) {
                    throw new InterruptedException();
                }

                Integer.parseInt(vnTextAP.getText().trim());

            } catch (InterruptedException ie) {
                System.out.println("emptyfields");
                JOptionPane.showMessageDialog(null, "Please fill all the fields.");
                return false;
            } catch (NumberFormatException ne) {
                System.out.println("invalid input");
                JOptionPane.showMessageDialog(null, "You can't input string in Vacancy no, \nworking hour or wages per hour fields");

                return false;
            }
        }
        return true;
    }

    boolean isUnique(int vn) {
        for (StaffHire vac : staffs) {
            if (vac.getVacancyNumber() == vn) {
                return false;
            }
        }
        return true;
    }

    void addvacancyButtonClick(ActionEvent e) {

        int vacancyNumber = Integer.parseInt(vnTextAV.getText());

        if (isUnique(vacancyNumber)) {
            String designation = dgText.getText();
            String jobType = jtText.getText();
            int workingHour = Integer.parseInt(whText.getText());
            StaffHire tempStaff;
            if (stvCombo.getSelectedItem().toString().equals("Full Time")) {
                int salary = Integer.parseInt(slryText.getText());
                tempStaff = new FullTimeStaffHire(vacancyNumber, designation, jobType, salary, workingHour);
            } else {
                int wagesPerHour = Integer.parseInt(wphText.getText());
                String shifts = sftCombo.getSelectedItem().toString();
                tempStaff = new PartTimeStaffHire(vacancyNumber, designation, jobType, workingHour, wagesPerHour, shifts);
            }
            staffs.add(tempStaff);
            System.out.println("Vacancy added successfully");
            JOptionPane.showMessageDialog(null, "Vacancy added Successfully");
        } else {
            System.out.println("Can't add Vacancy. it already exists.");
            JOptionPane.showMessageDialog(null, "This Vacancy is already occupied");

        }
    }

    void appointButtonClick(ActionEvent e) {
        int vacancyNumber = Integer.parseInt(vnTextAP.getText());

        if (!isUnique(vacancyNumber)) { // If the vacancy number is not unique ie. if the vacancy number exists.
            // start searching the object with that vacancy number
            for (StaffHire staff : staffs) {
                if (staff.getVacancyNumber() == vacancyNumber) { // when object is found
                    if (staff instanceof FullTimeStaffHire && staCombo.getSelectedItem().toString().equals("Full Time")) {
                        FullTimeStaffHire s = (FullTimeStaffHire) staff;
                        s.hireFullTimeStaff(snText.getText(), jdText.getText(), qnText.getText(), abText.getText());

                    } else if (staff instanceof PartTimeStaffHire && staCombo.getSelectedItem().toString().equals("Part Time")) {
                        PartTimeStaffHire s = (PartTimeStaffHire) staff;
                        s.hirePartTimeStaff(snText.getText(), jdText.getText(), qnText.getText(), abText.getText());
                    } else {
                        System.out.println("The staffType doesnot match for this vacancy number");
                        JOptionPane.showMessageDialog(null, "The staffType doesnot match for this vacancy number");

                    }
                }

            }
        } else {
            System.out.println("This vacnacy doesnot Exist");
            JOptionPane.showMessageDialog(null, "This vacnacy doesnot Exist");

        }
    }

    void displayButtonClick(ActionEvent e, String selected) {

        //Creating new frame to display the table
        JFrame tableHolder = new JFrame();

        // Defining column and rows for our Table
        String cols[] = null;
        String rows[] = null;
        // Creating Columns for FullTime and PartTime display
        if (selected.equals("Full Time")) {
            cols = new String[]{"Vacancy Number", "Designation", "JobType", "WorkingHour", "Salary", "Joined", "Name", "Joining Date", "Qualification", "AppointedBy"};
        } else {
            cols = new String[]{"Vacancy Number", "Designation", "JobType", "WorkingHour", "W.P.H", "Shift", "Joined", "Name", "JoiningDate", "Qualification", "AppointedBy"};
        }
        
        // Defining dynamic table
        DefaultTableModel tableModel = new DefaultTableModel(cols, 0);
        
        // creating dynamic table
        JTable table = new JTable(tableModel);

        //Creating the rows..
        for (StaffHire rawStaff : staffs) {
            
            // For displaying full time staffs
            if (selected.equals("Full Time")) {
                if (rawStaff instanceof FullTimeStaffHire) {
                    FullTimeStaffHire tempStaff = (FullTimeStaffHire) rawStaff;
                    String vn = Integer.toString(tempStaff.getVacancyNumber());
                    String dg = tempStaff.getDesignation();
                    String jt = tempStaff.getJobType();
                    String wh = Integer.toString(tempStaff.getWorkingHour());
                    String slry = Integer.toString(tempStaff.getSalary());
                    String joined = Boolean.toString(tempStaff.getJoined());
                    String name = tempStaff.getStaffName();
                    String jd = tempStaff.getJoiningDate();
                    String qn = tempStaff.getQualification();
                    String ab = tempStaff.getAppointedBy();
                    rows = new String[]{vn, dg, jt, wh, slry, joined, name, jd, qn, ab};
                    tableModel.addRow(rows);
                }
            } else { // For displaying part time staffs
                if (rawStaff instanceof PartTimeStaffHire) {
                    PartTimeStaffHire tempStaff = (PartTimeStaffHire) rawStaff;
                    String vn = Integer.toString(tempStaff.getVacancyNumber());
                    String dg = tempStaff.getDesignation();
                    String jt = tempStaff.getJobType();
                    String wh = Integer.toString(tempStaff.getWorkingHour());
                    String wph = Integer.toString(tempStaff.getWagesPerHour());
                    String shift = tempStaff.getShifts();
                    String joined = Boolean.toString(tempStaff.getJoined());
                    String name = tempStaff.getStaffName();
                    String jd = tempStaff.getJoiningDate();
                    String qn = tempStaff.getQualification();
                    String ab = tempStaff.getAppointedBy();
                    rows = new String[]{vn, dg, jt, wh, wph, shift, joined, name, jd, qn, ab};
                    tableModel.addRow(rows);
                }
            }

            // Adding Rows in each etiration.
            
        }

        //Creating Scrollable Pane
        JScrollPane scrollable = new JScrollPane(table);
        tableHolder.getContentPane().add(scrollable);
        tableHolder.setVisible(true);
        tableHolder.setSize(1200, 400);
    }

    // Method to set all textfields to empty.
    void resetButtonClick() {

        vnTextAV.setText(null);
        vnTextAP.setText(null);
        dgText.setText(null);
        snText.setText(null);
        jtText.setText(null);
        jdText.setText(null);
        abText.setText(null);
        qnText.setText(null);
        whText.setText(null);
        slryText.setText(null);
        wphText.setText(null);
    }

    void terminateButtonClick(ActionEvent e) {
        ArrayList<Integer> vacancyNumbers = new ArrayList<>();

        for(StaffHire s : staffs) {
            if (s instanceof PartTimeStaffHire) {
                PartTimeStaffHire ss = (PartTimeStaffHire) s;
                if (ss.getJoined()) {
                    vacancyNumbers.add(ss.getVacancyNumber());
                }

            }
        }
        Integer[] vn = vacancyNumbers.toArray(new Integer[0]);

        try {
            int n = (int) JOptionPane.showInputDialog(null, "Chose Vacancy of appointed PartTimeStaffs that you want to terminate", "", JOptionPane.QUESTION_MESSAGE, null, vn, vn[0]);
            for (StaffHire s : staffs) {
                if (s.getVacancyNumber() == n) {
                    PartTimeStaffHire a = (PartTimeStaffHire) s;
                    a.terminateStaff();
                }
            }
        } catch (ArrayIndexOutOfBoundsException ae) {
            JOptionPane.showMessageDialog(null, "No Part Time Staff is appointed");
        } catch (NullPointerException ae) {

        }

    }

}
