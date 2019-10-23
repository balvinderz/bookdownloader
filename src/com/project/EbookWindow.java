package com.project;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
public class EbookWindow  {
    public static JFrame frame;
    public static JOptionPane optionPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JLabel lblTitle;
    private JLabel lblAuthor;

    //  public static int checker=1;
   public  ActionListener[] action=new ActionListener[5];

    public    String path="";
    JFileChooser chooser;
    ArrayList<String> downloadlink=new ArrayList<String>();
    ArrayList<String> titlellist=new ArrayList<>();
    ArrayList<String> authorlist=new ArrayList<>();
    ArrayList<String> extensionlist=new ArrayList<>();
    /**
     * Launch the application.
     */


    public static void main(String[] args)  throws IOException, URISyntaxException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EbookWindow window = new EbookWindow();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public EbookWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        frame = new JFrame();
        frame.setAlwaysOnTop(true);
        frame.getContentPane().setForeground(Color.WHITE);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(100, 100, 791, 555);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("select folder");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 19));
        textField.setBounds(12, 73, 321, 33);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JButton btnNewButton = new JButton("SEARCH");
        btnNewButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 21));
        btnNewButton.setBounds(361, 73, 150, 34);
        frame.getContentPane().add(btnNewButton);

        JLabel lblEbook = new JLabel("BOOKLABS");
        lblEbook.setForeground(Color.BLACK);
        lblEbook.setFont(new Font("Stencil Std", Font.PLAIN, 38));
        lblEbook.setBounds(12, 13, 243, 60);
        frame.getContentPane().add(lblEbook);

        Panel panel = new Panel();
        panel.setBounds(10, 132, 741, 366);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        Button button = new Button("DOWNLOAD");
        button.setBackground(Color.DARK_GRAY);
        button.setBounds(627, 47, 93, 29);
        panel.add(button);

        Button button_1 = new Button("DOWNLOAD");
        button_1.setBackground(Color.DARK_GRAY);
        button_1.setBounds(627, 115, 93, 29);
        panel.add(button_1);

        Button button_2 = new Button("DOWNLOAD");
        button_2.setBackground(Color.DARK_GRAY);
        button_2.setBounds(627, 176, 93, 29);
        panel.add(button_2);

        Button button_3 = new Button("DOWNLOAD");
        button_3.setBackground(Color.DARK_GRAY);
        button_3.setBounds(627, 243, 93, 29);
        panel.add(button_3);

        Button button_4 = new Button("DOWNLOAD");
        button_4.setBackground(Color.DARK_GRAY);
        button_4.setBounds(627, 302, 93, 29);
        panel.add(button_4);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_1.setBounds(12, 47, 305, 29);
        textField_1.setEditable(false);
        panel.add(textField_1);
        textField_1.setColumns(20);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_2.setBounds(350, 47, 245, 29);
        panel.add(textField_2);
        textField_2.setEditable(false);

        textField_2.setColumns(20);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_3.setColumns(10);
        textField_3.setBounds(12, 115, 305, 29);
        textField_3.setEditable(false);

        panel.add(textField_3);

        textField_4 = new JTextField();
        textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_4.setColumns(10);
        textField_4.setBounds(12, 176, 305, 29);
        textField_4.setEditable(false);

        panel.add(textField_4);

        textField_5 = new JTextField();
        textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_5.setColumns(10);
        textField_5.setBounds(12, 243, 305, 29);
        textField_5.setEditable(false);

        panel.add(textField_5);

        textField_6 = new JTextField();
        textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_6.setColumns(10);
        textField_6.setBounds(12, 302, 305, 29);
        textField_6.setEditable(false);

        panel.add(textField_6);

        textField_7 = new JTextField();
        textField_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_7.setColumns(10);
        textField_7.setBounds(350, 115, 245, 29);
        textField_7.setEditable(false);

        panel.add(textField_7);

        textField_8 = new JTextField();
        textField_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_8.setColumns(10);
        textField_8.setBounds(350, 176, 245, 29);
        textField_8.setEditable(false);

        panel.add(textField_8);

        textField_9 = new JTextField();
        textField_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_9.setColumns(10);
        textField_9.setBounds(350, 243, 245, 29);
        textField_9.setEditable(false);

        panel.add(textField_9);

        textField_10 = new JTextField();
        textField_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField_10.setColumns(10);
        textField_10.setBounds(350, 302, 245, 29);
        textField_10.setEditable(false);

        panel.add(textField_10);

        lblTitle = new JLabel("TITLE");
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 34));
        lblTitle.setBounds(12, 5, 129, 29);
        panel.add(lblTitle);

        lblAuthor = new JLabel("AUTHOR");
        lblAuthor.setForeground(Color.BLACK);
        lblAuthor.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 34));
        lblAuthor.setBounds(400, 5, 152, 29);
        panel.add(lblAuthor);
      //  frame.add(chooser);
        action[0]=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

              if(downloadlink.size()==0)
                  JOptionPane.showMessageDialog(frame,"Search First","ERROR",JOptionPane.INFORMATION_MESSAGE);
else      {      int r= chooser.showOpenDialog(frame);

                if(r==JFileChooser.APPROVE_OPTION)
                {
              path=chooser.getSelectedFile().getAbsolutePath();
              if(titlellist.get(0).length()>11)
                path=path+"\\"+titlellist.get(0).substring(0,10)+"."+extensionlist.get(0);
              else
                  path=path+"\\"+titlellist.get(0)+"."+extensionlist.get(0);

              

                Thread t=new Downloader(path,downloadlink.get(0),button);
                t.start();}
            }}
        };
        action[1]=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (downloadlink.size() == 0)
                    JOptionPane.showMessageDialog(frame, "Search First", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                else {
                    int r = chooser.showOpenDialog(frame);
                    if (r == JFileChooser.APPROVE_OPTION) {
                        path = chooser.getSelectedFile().getAbsolutePath();

                        if (titlellist.get(1).length() > 11)
                            path = path + "\\" + titlellist.get(1).substring(0, 10) + "." + extensionlist.get(1);
                        else
                            path = path + "\\" + titlellist.get(1) + "." + extensionlist.get(1);
                        System.out.println(path);

                        Thread t = new Downloader(path, downloadlink.get(1),button_1);
                        t.start();
                    }
                }
            }
        };
        action[2]=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(downloadlink.size()==0)
                    JOptionPane.showMessageDialog(frame,"Search First","ERROR",JOptionPane.INFORMATION_MESSAGE);
                else      {
                    int r=       chooser.showOpenDialog(frame);
                if(r==JFileChooser.APPROVE_OPTION)
                {                 path=chooser.getSelectedFile().getAbsolutePath();

                    if(titlellist.get(2).length()>11)
                        path=path+"\\"+titlellist.get(2).substring(0,10)+"."+extensionlist.get(2);
                    else
                        path=path+"\\"+titlellist.get(2)+"."+extensionlist.get(2);
                System.out.println(path);

                Thread t=new Downloader(path,downloadlink.get(2),button_2);
                t.start(); }
            } }
        };
        action[3]=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(downloadlink.size()==0)
                    JOptionPane.showMessageDialog(frame,"Search First","ERROR",JOptionPane.INFORMATION_MESSAGE);
                else      {
                    int r=       chooser.showOpenDialog(frame);
                if(r==JFileChooser.APPROVE_OPTION)
                {                 path=chooser.getSelectedFile().getAbsolutePath();
                    if(titlellist.get(3).length()>11)
                        path=path+"\\"+titlellist.get(3).substring(0,10)+"."+extensionlist.get(3);
                    else
                        path=path+"\\"+titlellist.get(3)+"."+extensionlist.get(3);

                Thread t=new Downloader(path,downloadlink.get(3),button_3);
                t.start(); }
            } }
        };
        action[4]=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(downloadlink.size()==0)
                    JOptionPane.showMessageDialog(frame,"Search First","ERROR",JOptionPane.INFORMATION_MESSAGE);
                else      {
                    int r=       chooser.showOpenDialog(frame);
                if(r==JFileChooser.APPROVE_OPTION)
                {
                path=chooser.getSelectedFile().getAbsolutePath();
                    if(titlellist.get(4).length()>11)
                        path=path+"\\"+titlellist.get(4).substring(0,10)+"."+extensionlist.get(4);
                    else
                        path=path+"\\"+titlellist.get(4)+"."+extensionlist.get(4);

                Thread t=new Downloader(path,downloadlink.get(4),button_4);
                t.start(); }
            } }
        };
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                titlellist.clear();
                authorlist.clear();
                extensionlist.clear();
                downloadlink.clear();
                String search=textField.getText();

                String link="http://libgen.is/search.php?req="+search+"&open=0&res=25&view=simple&phrase=1&column=def";
                Document connectintolink= null;
                try {
                    connectintolink = Jsoup.connect(link).get();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                Elements table=connectintolink.select("table").eq(2);
                Elements a=table.select("tbody").select("tr");

                if(a.size()<=5)
                    JOptionPane.showMessageDialog(frame,"No Books found");
                else
                {
                for(int i=1;i<=5;i++)
                {
                    String author=a.eq(i).select("td").eq(1).select("a").first().html();
                    Elements d=a.eq(i).select("td").eq(2).select("a");
                    int sizeofd=d.size();
                    String title=d.eq(sizeofd-1).html();
                    int index=title.indexOf("<font face");
                    String  realtitle;
                    if(index!=-1) {

                        realtitle=title.substring(0,index);
                        int brindex=realtitle.indexOf("<br>");
                        if(brindex==-1) {
                            titlellist.add(realtitle);
                        }
                        else
                        {
                            String realrealtitle=realtitle.substring(0,brindex);
                            titlellist.add(realrealtitle);
                        }
                    }
                    else {
                        titlellist.add(title);
                    }
                    authorlist.add(author);
                    String b=a.eq(i).select("td").eq(10).select("a").attr("href");
                    System.out.println(b);
                    String extension=a.eq(i).select("td").eq(8).html();
                    extensionlist.add(extension);
                    downloadlink.add(b);

                }
                textField_1.setText(titlellist.get(0));
                textField_3.setText(titlellist.get(1));
                textField_4.setText(titlellist.get(2));
                textField_5.setText(titlellist.get(3));
                textField_6.setText(titlellist.get(4));

                textField_2.setText(authorlist.get(0));
                textField_7.setText(authorlist.get(1));
                textField_8.setText(authorlist.get(2));
                textField_9.setText(authorlist.get(3));
                textField_10.setText(authorlist.get(4));
            }
        }
        });
        button.addActionListener(action[0]);
        button_1.addActionListener(action[1]);
        button_2.addActionListener(action[2]);
        button_3.addActionListener(action[3]);
        button_4.addActionListener(action[4]);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                titlellist.clear();
                authorlist.clear();
                extensionlist.clear();
                downloadlink.clear();
                //checker=1;
                String search=textField.getText();

                String link="http://libgen.io/search.php?req="+search+"&open=0&res=25&view=simple&phrase=1&column=def";
                Document connectintolink= null;
                try {
                    connectintolink = Jsoup.connect(link).get();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                Elements table=connectintolink.select("table").eq(2);
                Elements a=table.select("tbody").select("tr");
                if(a.size()<=5)
                    JOptionPane.showMessageDialog(frame,"No Books found");
               else
                {
                    for(int i=1;i<=5;i++)
                {
                    String author=a.eq(i).select("td").eq(1).select("a").first().html();
                    Elements d=a.eq(i).select("td").eq(2).select("a");
                    int sizeofd=d.size();
                    String title=d.eq(sizeofd-1).html();
                    int index=title.indexOf("<font face");
                    String  realtitle;
                    if(index!=-1) {

                        realtitle=title.substring(0,index);
                        int brindex=realtitle.indexOf("<br>");
                        if(brindex==-1) {

                            titlellist.add(realtitle);
                        }
                        else
                        {
                            String realrealtitle=realtitle.substring(0,brindex);

                            titlellist.add(realrealtitle);


                        }
                    }
                    else {
                        titlellist.add(title);
                    }
                    authorlist.add(author);
                    String b=a.eq(i).select("td").eq(11).select("a").attr("href");
                    String extension=a.eq(i).select("td").eq(8).html();
                    extensionlist.add(extension);
                    downloadlink.add(b);
                }
                textField_1.setText(titlellist.get(0));
                textField_3.setText(titlellist.get(1));
                textField_4.setText(titlellist.get(2));
                textField_5.setText(titlellist.get(3));
                textField_6.setText(titlellist.get(4));

                textField_2.setText(authorlist.get(0));
                textField_7.setText(authorlist.get(1));
                textField_8.setText(authorlist.get(2));
                textField_9.setText(authorlist.get(3));
                textField_10.setText(authorlist.get(4));
                }
            }
        });
    }
}