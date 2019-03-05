package com.javamail.notifymeMailApi;

import java.io.File;

public class Filepathfetch {
    public static void main(String a[]){
        File file = new File("src/main/resources/attachments");
        File[] files = file.listFiles();
        for(File f: files){
            System.out.println(f.getName());
            }
        }
}
