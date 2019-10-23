package com.project;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Downloader extends Thread {
    public String path,downloadlink;
    Button b;
    Downloader(String path,String downloadlink,Button b)
    {
        this.path=path;
        this.downloadlink=downloadlink;
        this.b=b;
    }
    @Override
    public void run()
    {

        Document download= null;
        try {
            download = Jsoup.connect(downloadlink).timeout(300000).get();
        } catch (IOException e1) {

        }

        String xyz=download.select("a").attr("href");
        File f=new File(path);

        URL url= null;
        try {
            url = new URL(xyz);
        } catch (MalformedURLException e1) {
             }
        try {
            JOptionPane k=new JOptionPane();

            System.out.println("downloadlink is "+downloadlink);
            b.setLabel("Downloading");
            System.out.println(url);
            System.out.println(path);
            FileUtils.copyURLToFile(url,f);
            b.setLabel("Download");
            JOptionPane.showMessageDialog(EbookWindow.frame,"Download complete ");
            Desktop.getDesktop().open(f.getParentFile());

        } catch (IOException e1) {
            System.out.println("xyz");

        }
    }


}